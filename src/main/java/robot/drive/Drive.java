package robot.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import static edu.wpi.first.units.Units.Second;

import java.util.List;
import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.Time;
import edu.wpi.first.units.Unit;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Constants;
import robot.Ports;
import robot.Robot;
import robot.drive.driveConstants.FF;
import robot.drive.driveConstants.PID;

public class drive extends SubsystemBase {
    private final CANSparkMax leftLeader = new CANSparkMax(Ports.Drive.LEFT_LEADER, MotorType.kBrushless);
    private final CANSparkMax leftFollower = new CANSparkMax(Ports.Drive.LEFT_FOLLOWER, MotorType.kBrushless);

    private final CANSparkMax rightLeader = new CANSparkMax(Ports.Drive.RIGHT_LEADER, MotorType.kBrushless);
    private final CANSparkMax rightFollower = new CANSparkMax(Ports.Drive.RIGHT_FOLLOWER, MotorType.kBrushless);

    private final RelativeEncoder leftEncoder = leftLeader.getEncoder();
    private final RelativeEncoder rightEncoder = rightLeader.getEncoder();

    private final AnalogGyro gyro = new AnalogGyro(Ports.Drive.GYRO_CHANNEL);

    private final DifferentialDriveOdometry odometry;

    private final SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(FF.kS, FF.kV);

    private final PIDController leftPIDController =
      new PIDController(PID.kP, PID.kI, PID.kD);
    private final PIDController rightPIDController =
      new PIDController(PID.kP, PID.kI, PID.kD);

    private final DifferentialDrivetrainSim driveSim;

    public drive() {
        for (CANSparkMax spark : List.of(leftLeader, leftFollower, rightLeader, rightFollower)) {
            spark.restoreFactoryDefaults();
            spark.setIdleMode(IdleMode.kBrake);
        }

        rightFollower.follow(rightLeader);
        leftFollower.follow(leftLeader);

        leftLeader.setInverted(true);

        leftEncoder.setPositionConversionFactor(driveConstants.POSITION_FACTOR);
        rightEncoder.setPositionConversionFactor(driveConstants.POSITION_FACTOR);
    
        leftEncoder.setVelocityConversionFactor(driveConstants.VELOCITY_FACTOR);
        rightEncoder.setVelocityConversionFactor(driveConstants.VELOCITY_FACTOR);

        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);

        gyro.reset();

        odometry = new DifferentialDriveOdometry(
            gyro.getRotation2d(), 
            leftEncoder.getPosition(), 
            rightEncoder.getPosition(), 
            new Pose2d()
        );

        // Simulation
        driveSim = new DifferentialDrivetrainSim(
            DCMotor.getMiniCIM(2),
            driveConstants.GEARING,
            driveConstants.MOI,
            driveConstants.DRIVE_MASS,
            driveConstants.WHEEL_RADIUS,
            driveConstants.TRACK_WIDTH,
            driveConstants.STD_DEVS);
    }

    private void drive(double leftSpeed, double rightSpeed) {
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);

        final double realLeftSpeed = leftSpeed * driveConstants.MAX_SPEED;
        final double realRightSpeed = rightSpeed * driveConstants.MAX_SPEED;
        
        final double leftFeedforward = feedforward.calculate(realLeftSpeed);
        final double rightFeedforward = feedforward.calculate(realRightSpeed);
    
        final double leftPID = 
        leftPIDController.calculate(leftEncoder.getVelocity(), realLeftSpeed);
        final double rightPID = 
        rightPIDController.calculate(rightEncoder.getVelocity(), realRightSpeed);

        double leftVoltage = leftPID + leftFeedforward;
        double rightVoltage = rightPID + rightFeedforward;
  
        leftLeader.setVoltage(leftVoltage);
        rightLeader.setVoltage(rightVoltage);

        driveSim.setInputs(leftVoltage, rightVoltage);
    }

    public Command drive(DoubleSupplier vLeft, DoubleSupplier vRight){
        return run(() -> drive(vLeft.getAsDouble(), vRight.getAsDouble()));
    }

    private void updateOdometry(Rotation2d rotation) {
        odometry.update(rotation, leftEncoder.getPosition(), rightEncoder.getPosition());
    }

    public void resetOdometry(Pose2d pose) {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
        odometry.resetPosition(gyro.getRotation2d(), 0, 0, pose);
    }

    @Override 
    public void periodic() {
        updateOdometry(Robot.isReal() ? gyro.getRotation2d() :  driveSim.getHeading());
    }

    @Override
    public void simulationPeriodic() {
        // sim.update() tells the simulation how much time has passed
        driveSim.update(Constants.PERIOD.in(Second));
        leftEncoder.setPosition(driveSim.getLeftPositionMeters());
        rightEncoder.setPosition(driveSim.getRightPositionMeters());
    }

    public Pose2d pose() {
        return odometry.getPoseMeters();
    }
}

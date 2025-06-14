package robot.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import static edu.wpi.first.units.Units.Second;

import java.util.List;
import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import monologue.Logged;
import monologue.Annotations.Log;
import robot.Constants;
import robot.Ports;
import robot.Robot;
import robot.drive.DriveConstants.FF;
import robot.drive.DriveConstants.PID;

import static robot.drive.DriveConstants.TURNING_FACTOR;

/**KIdiuaiwhiawhifwa */
public class Drive extends SubsystemBase implements Logged {
    private final CANSparkMax leftLeader = new CANSparkMax(Ports.Drive.LEFT_LEADER, MotorType.kBrushless);
    private final CANSparkMax leftFollower = new CANSparkMax(Ports.Drive.LEFT_FOLLOWER, MotorType.kBrushless);

    private final CANSparkMax rightLeader = new CANSparkMax(Ports.Drive.RIGHT_LEADER, MotorType.kBrushless);
    private final CANSparkMax rightFollower = new CANSparkMax(Ports.Drive.RIGHT_FOLLOWER, MotorType.kBrushless);

    private final RelativeEncoder leftEncoder = leftLeader.getEncoder();
    private final RelativeEncoder rightEncoder = rightLeader.getEncoder();

    private final GyroIO gyro = new GyroIO.NoGyro();//new AnalogGyro(Ports.Drive.GYRO_CHANNEL);

    private final DifferentialDriveOdometry odometry;

    /**idioawjiodjioawjfiojwiofjiawojfioawjf */
    private final SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(FF.kS, FF.kV);

    private final PIDController leftPIDController =
      new PIDController(PID.kP, PID.kI, PID.kD);
    private final PIDController rightPIDController =
      new PIDController(PID.kP, PID.kI, PID.kD);

    @Log.NT
    private final DifferentialDrivetrainSim driveSim;
    private final Field2d field2d = new Field2d();

    public Drive() {
        for (CANSparkMax spark : List.of(leftLeader, leftFollower, rightLeader, rightFollower)) {
            spark.restoreFactoryDefaults();
            spark.setIdleMode(IdleMode.kBrake);
        }

        rightFollower.follow(rightLeader);
        leftFollower.follow(leftLeader);

        leftLeader.setInverted(true);

        leftEncoder.setPositionConversionFactor(DriveConstants.POSITION_FACTOR);
        rightEncoder.setPositionConversionFactor(DriveConstants.POSITION_FACTOR);
    
        leftEncoder.setVelocityConversionFactor(DriveConstants.VELOCITY_FACTOR);
        rightEncoder.setVelocityConversionFactor(DriveConstants.VELOCITY_FACTOR);

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
            DriveConstants.GEARING,
            DriveConstants.MOI,
            DriveConstants.DRIVE_MASS,
            DriveConstants.WHEEL_RADIUS,
            DriveConstants.TRACK_WIDTH,
            DriveConstants.STD_DEVS);
    }
    private void drive(double leftY, double rightX) {
        leftY = leftY * -1;
        if (leftY < 0.1 && leftY > -0.1){
            leftY = 0.0;
        }
        if (rightX < 0.1 && rightX > -0.1){
            rightX = 0.0;
        }

        double leftSpeed = leftY + (rightX * TURNING_FACTOR);
        double rightSpeed = leftY - (rightX * TURNING_FACTOR);

        leftSpeed = MathUtil.clamp(leftSpeed, -1.0, 1.0);
        rightSpeed = MathUtil.clamp(rightSpeed, -1.0, 1.0);

        final double realLeftSpeed = leftSpeed * DriveConstants.MAX_SPEED;
        final double realRightSpeed = rightSpeed * DriveConstants.MAX_SPEED;

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


    public Command drivec(DoubleSupplier vLeft, DoubleSupplier vRight){
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
        field2d.setRobotPose(pose());
        driveSim.update(Constants.PERIOD.in(Second));
        leftEncoder.setPosition(driveSim.getLeftPositionMeters());
        rightEncoder.setPosition(driveSim.getRightPositionMeters());
    }

    @Log.NT
    public Pose2d pose() {
        return odometry.getPoseMeters();
    }
}

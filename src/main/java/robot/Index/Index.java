package robot.Index;

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

public class Index extends SubsystemBase {
    private final CANSparkMax indexMotor;

    public Index() {
        indexMotor = new CANSparkMax(Ports.Intake.INTAKE_MOTOR, MotorType.kBrushless);
        indexMotor.restoreFactoryDefaults();
        indexMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        indexMotor.setSmartCurrentLimit(30);
    }

    public void setSpeed(double speed) {
        indexMotor.set(speed);
    }

    public void stop() {
        indexMotor.set(0);
    }

    public Command runIndexerCommand() {
        return run(() -> setSpeed(IndexConstants.INDEXER_MAX_SPEED));
    }
    

    public Command stopIndexerCommand() {
        return run(() -> setSpeed(0));
    }
}


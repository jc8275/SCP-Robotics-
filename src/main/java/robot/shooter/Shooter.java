package robot.shooter;

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

@SuppressWarnings("unused")
public class Shooter extends SubsystemBase {
    // private final CANSparkMax motor = new CANSparkMax(Ports.Shooter.SHOOTER_ONE, MotorType.kBrushless);
    private final ShooterIO hardware;

    public Shooter(ShooterIO hardware) {
        this.hardware = hardware;
    }

    public Command shoot() {
        return run(() -> hardware.setVoltage(ShooterConstants.VOLTAGE));
    }

    public Command shootstop() {
        return run(() -> hardware.setVoltage(0));
    }
}


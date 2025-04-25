package robot.shooter;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import java.util.List;
import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class Shooter extends SubsystemBase {
    private final CANSparkMax shooterOne = new CANSparkMax(Ports.Drive.SHOOTER_ONE, MotorType.kBrushless);

    public Shooter() {
        for (CANSparkMax spark : List.of(shooterOne)) {
            spark.restoreFactoryDefaults();
        }
    }

    
}


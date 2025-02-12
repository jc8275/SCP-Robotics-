package robot.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class DriveConstants {
    public static final double WHEEL_RADIUS = 0.08; //Meters
    public static final double CIRCUMFERENCE = 2.0 * Math.PI * WHEEL_RADIUS;
    public static final double GEARING = 8.0;
    
    public static final double POSITION_FACTOR = CIRCUMFERENCE * GEARING;
    public static final double VELOCITY_FACTOR = POSITION_FACTOR / 60.0;
}
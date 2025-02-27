package robot.shooter;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterConstants {
    // Motor port for the shooter motor
    public static final int SHOOTER_MOTOR_PORT = 0;  

    // Motor type for shooter motor 
    public static final MotorType SHOOTER_MOTOR_TYPE = MotorType.kBrushless;  

    // Speed values (can be adjusted for proper tuning)
    public static final double SHOOTER_IDLE_SPEED = 0.0;  
    public static final double SHOOTER_OPERATING_SPEED = 0.80;  

    // Max and Min speed for the shooter motor (to avoid over-revving or under-performing)
    public static final double MAX_SHOOTER_SPEED = 1.0;  // 
    public static final double MIN_SHOOTER_SPEED = 0.2;  // 

    // Shooter wheel specifications
    public static final double SHOOTER_WHEEL_DIAMETER = 4.0; // 
    public static final double SHOOTER_WHEEL_RPM = 5000;  // s

    // Shooter control constants
    public static final double SHOOTER_SPEED_TOLERANCE = 0.05;  // 

    // Adjustments for aiming or feed system can be added as needed
    public static final double FEED_WHEEL_SPEED = 0.5;  // Speed for feeding mechanism (could vary based on ball type/size)
}

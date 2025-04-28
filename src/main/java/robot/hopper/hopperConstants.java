package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class hopperConstants {
    public static final double ELEVATOR_MAX_SPEED = 50.0;
    public static boolean hasStuff = false;
    public static final double ELEVATOR_ACCELERATION = 210;
    public static final double ELEVATOR_MAX_DISTANCE = 100.0;
}

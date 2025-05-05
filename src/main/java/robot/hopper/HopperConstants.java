package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

@SuppressWarnings("unused")
public class HopperConstants {
    public static final double ELEVATOR_MAX_SPEED = 50.0;
    public static boolean hasStuff = false;
    public static final double ELEVATOR_ACCELERATiON = 20;
    public static final double ELEVATOR_MAX_DISTANCE = 100.0;
    public static final double SPEED = 10.0;
}

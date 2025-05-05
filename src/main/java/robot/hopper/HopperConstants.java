package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

@SuppressWarnings("unused")
public class HopperConstants {
    public static final double ELEVATOR_MAX_SPEED = 45.0; //Careful as speed can break things.
    public static boolean hasItems = false;
    public static final double ELEVATOR_ACCELERATiON = 20;
    public static final double ELEVATOR_MAX_DISTANCE = 100.0;
    public static final double SPEED = 5.0; //The motors are powerful enough that this is a reasonable speed
    public static final double INTAKE_POWER = 0.5;
}

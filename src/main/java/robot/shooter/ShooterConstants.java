package robot.shooter;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterConstants {
    public static final double SPEED = 0.8;

    // what is all this stuff below? vv
    public static final int SHOOTER_MOTOR_ID = 1; // motor id
    public static final double SPEED_MAX = 4; //values unknown
    public static final double SPEED_MIN = 0; //like, how weak it can possibly be
    public static final double SPEED_TARGET = 2; //like, I think we need to choose how quickly we want to shoot or balls.TARGET is the range we want our shooting-speed to be in. Sort of like the arm in that one video they showed us?
    public static final double VOLTAGE_MAX = 4.0; //maximum voltage (its like the maximum energy in the system)
    public static final double POWER_MAX = 1.0; //maximum power(idk what this is, it was just a variable in "shooterIO.java" so i'll elaborate on it more?)
}

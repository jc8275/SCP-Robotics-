package robot.shooter;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterConstants {
    public static final double SPEED_MAX = 4; //erm, we dont know the values for these yet D: so i just put random stuff ig???
    public static final double SPEED_MIN = 0; //like, how weak it can possibly be
    public static final double SPEED_TARGET = 2; //like, I think we need to choose how quickly we want to shoot or balls.TARGET is the range we want our shooting-speed to be in. Sort of like the arm in that one video they showed us?
    public static final double VOLTAGE_MAX = 4.0; //maximum voltage (i learned this in elements of engineering lol, anyways its like the maximum energy in the system)
    public static final double POWER_MAX = 1.0; //maximum power(idk what this is, it was just a variable in "shooterIO.java" so i'll elaborate on it more?)
}

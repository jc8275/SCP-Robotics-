package robot;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Time;


public class Constants {
  public static final double WHEEL_RADIUS = 0.05;
  public static final double WHEEL_BASE = 0.15;
  public static final double ARM_LENGTH = 0.3;
  public static final int MAX_TILT_ANGLE = 90;

  public static final double MAX_MOTOR_SPEED = 1.0;
  public static final double MIN_MOTOR_SPEED = 0.1;
  public static final int MOTOR_PWM_MAX = 255;
  public static final int MOTOR_PWM_MIN = 50;

  public static final double MAX_BATTERY_VOLTAGE = 12.0;
  public static final double MIN_BATTERY_VOLTAGE = 10.5;

  public static final String SERIAL_PORT = "";
  public static final int SERIAL_BAUD_RATE = 115200;
  public static final String NETWORK_IP = "192.168.0.1";
  public static final int NETWORK_PORT = 8080;

  public static final double TIMEOUT_LIMIT = 5.0;
  public static final double LOOP_DELAY = 0;

  public static final Measure<Time> PERIOD = Seconds.of(0.02); // roborio tickrate (s)
}

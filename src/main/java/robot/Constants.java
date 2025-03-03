package robot;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Time;



WHEEL_RADIUS = 0.05  # Radius of the wheel in meters
WHEEL_BASE = 0.15    # Distance between the left and right wheels (wheelbase) in meters
ARM_LENGTH = 0.3     # Length of the robotic arm (if applicable), in meters
MAX_TILT_ANGLE = 90  # Maximum tilt angle of the arm or robot in degrees


MAX_MOTOR_SPEED = 1.0  # Maximum motor speed (in meters per second or relevant units)
MIN_MOTOR_SPEED = 0.1  # Minimum motor speed (in meters per second or relevant units)
MOTOR_PWM_MAX = 255    # Max PWM signal for motors (if using PWM control)
MOTOR_PWM_MIN = 50     # Min PWM signal for motors (if using PWM control)



MAX_BATTERY_VOLTAGE = 12.0  # Max battery voltage in volts (for monitoring battery levels)
MIN_BATTERY_VOLTAGE = 10.5  # Min battery voltage in volts (for triggering warnings)



SERIAL_PORT =    # Serial port for communication with the robot (example)
SERIAL_BAUD_RATE = 115200       # Baud rate for serial communication
NETWORK_IP = "192.168.0.1"      # IP address for network communication
NETWORK_PORT = 8080             # Port for communication (e.g., for a web server or socket)


TIMEOUT_LIMIT = 5.0  # Timeout limit in seconds (e.g., waiting for sensor data)
LOOP_DELAY = 0.1     # Delay between control loop iterations (in seconds)



public class Constants {
  public static final Measure<Time> PERIOD = Seconds.of(0.02); // roborio tickrate (s)
}

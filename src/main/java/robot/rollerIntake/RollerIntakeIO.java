package robot.rollerIntake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public interface RollerIntakeIO {
    /**manages power of the intake**/
    void setPower(double power);
}

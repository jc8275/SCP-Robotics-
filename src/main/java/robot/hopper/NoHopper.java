package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class NoHopper {
   public void setVoltage(double voltage) {
        elevatorMotor.setVoltage(voltage);
    }
    public void getVoltage(double voltage) {
    return elevatorMotor.getVoltage;
    }
}

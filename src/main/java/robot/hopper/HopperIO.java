package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;
public interface HopperIO {
  # Elevator Interface Voltage Setter

public interface Elevator {
    void setVoltage(int voltage);
}

  
}

package robot.rollerIntake;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import robot.Ports;

public class RealRollerIntake implements RollerIntakeIO {
  private final CANSparkMax hopperMotor;

  public RealRollerIntake() {
    hopperMotor = new CANSparkMax(Ports.Intake.INTAKE_MOTOR, MotorType.kBrushless);
  }

  @Override
  public void setVoltage(double voltage) { // just gives us the voltage
    hopperMotor.setVoltage(voltage);
  }

  @Override
  public double getVoltage() {
    return hopperMotor.getBusVoltage();
  }
}

package robot.hopper;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import robot.Ports;

public class RealHopper implements HopperIO {
  private final CANSparkMax hopperTop;
  private final CANSparkMax hopperBottom;

  public RealHopper() {
    hopperTop = new CANSparkMax(Ports.Hopper.HOPPER_TOP, MotorType.kBrushless);
    hopperBottom = new CANSparkMax(Ports.Hopper.HOPPER_BOTTOM, MotorType.kBrushless);

    hopperBottom.follow(hopperTop);
    hopperBottom.setInverted(true);
  }

  @Override
  public void setVoltage(double voltage) {
    hopperTop.setVoltage(voltage);
  }

  @Override
  public double getVoltage() {
    return hopperTop.getBusVoltage();
  }
}

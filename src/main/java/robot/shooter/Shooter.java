package robot.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

@SuppressWarnings("unused")
public class Shooter extends SubsystemBase {
  // private final CANSparkMax motor = new CANSparkMax(Ports.Shooter.SHOOTER_ONE,
  // MotorType.kBrushless);
  private final ShooterIO hardware;

  public Shooter(ShooterIO hardware) {
    this.hardware = hardware;
  }

  public Command shoot() {
    return run(() -> hardware.setVoltage(ShooterConstants.VOLTAGE));
  }

  public Command shootstop() {
    return run(() -> hardware.setVoltage(0));
  }
}

package robot.rollerIntake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

@SuppressWarnings("unused")
public class RollerIntake extends SubsystemBase {
  private final RollerIntakeIO hardware;

  public RollerIntake(RollerIntakeIO hardware) {
    this.hardware = hardware;
  }

  public Command run_forwards() {
    return run(() -> hardware.setVoltage(RollerIntakeConstants.VOLTAGE));
  }

  public Command run_backwards() {
    return run(() -> hardware.setVoltage(-RollerIntakeConstants.VOLTAGE));
  }

  public Command stop() {
    return run(() -> hardware.setVoltage(0));
  }
}

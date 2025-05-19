package robot.hopper;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// this code doesnt specify whether the motors are intaking moving or pusing into shooter
@SuppressWarnings("unused")
public class Hopper extends SubsystemBase {
  private final HopperIO hardware;

  public Hopper(HopperIO hardware) {
    this.hardware = hardware;
  }

  public Command runHopper() {
    return run(() -> hardware.setVoltage(HopperConstants.SPEED));
  }

  public Command stopHopper() {
    return run(() -> hardware.setVoltage(0));
  }

  public Command intake() {
    return run(() -> hardware.setVoltage(HopperConstants.INTAKE_POWER));
  }

  public Command outtake() {
    return run(() -> hardware.setVoltage(-HopperConstants.INTAKE_POWER));
  }
}

package robot.Index;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class Index extends SubsystemBase {
  private final CANSparkMax indexMotor;

  public Index() {
    indexMotor = new CANSparkMax(Ports.Intake.INTAKE_MOTOR, MotorType.kBrushless);
    indexMotor.restoreFactoryDefaults();
    indexMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    indexMotor.setSmartCurrentLimit(30);
  }

  public void setSpeed(double speed) {
    indexMotor.set(speed);
  }

  public void stop() {
    indexMotor.set(0);
  }

  public Command runIndexerCommand() {
    return run(() -> setSpeed(IndexConstants.INDEXER_MAX_SPEED));
  }

  public Command stopIndexerCommand() {
    return run(() -> setSpeed(0));
  }
}

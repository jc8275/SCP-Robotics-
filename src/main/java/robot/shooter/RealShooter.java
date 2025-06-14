package robot.shooter;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import robot.Ports;

public class RealShooter implements ShooterIO {
  private final CANSparkMax shooterMotor; // we need our motor, ofc

  public RealShooter() { // constructor
    shooterMotor =
        new CANSparkMax(
            Ports.Shooter.SHOOTER_ONE,
            MotorType
                .kBrushless); // OK, so we're gonna have to fix the motor type cuz i just put some
    // random "kbrushed" there. no idea what that means
  }

  @Override
  public void setVoltage(double voltage) { // just gives us the voltage
    shooterMotor.setVoltage(voltage);
  }

  @Override
  public double getVelocity() {
    return shooterMotor.getEncoder().getVelocity();
  }

  @Override
  public double getVoltage() {
    return shooterMotor.getBusVoltage();
  }
}

package robot.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.AnalogGyro;
import robot.Ports;

public interface GyroIO {
  public Rotation2d getRotation2d();

  public void reset();

  public class RealGyro implements GyroIO {
    private final AnalogGyro gyro;

    public RealGyro() {
      gyro = new AnalogGyro(Ports.Drive.GYRO_CHANNEL);
    }

    public Rotation2d getRotation2d() {
      return gyro.getRotation2d();
    }

    public void reset() {
      gyro.reset();
    }
  }

  public class NoGyro implements GyroIO {
    public NoGyro() {}

    public Rotation2d getRotation2d() {
      return new Rotation2d();
    }

    public void reset() {}
  }
}

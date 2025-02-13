package robot.shooter;

/
public class NoShooter implements ShooterIO {
    @Override
    public void setVoltage(double voltage) {
        // Does nothing
    }

    @Override
    public void setPower(double power) {
        // Does nothing
    }

    @Override
    public double getVelocity() {
        return 0;  // Returns a dummy value
    }
}

package robot.shooter;

public class SimShooter implements ShooterIO {
    private double velocity = 0;  

    @Override
    public void setVoltage(double voltage) {
        velocity = voltage * 100;  // Simulated velocity calculation
    }

    @Override
    public void setPower(double power) {
        velocity = power * 3000;  // Simulated power-based velocity
    }

    @Override
    public double getVelocity() {
        return velocity;
    }
}

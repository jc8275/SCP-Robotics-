package robot.shooter;

public class SimShooter implements ShooterIO {
    private double velocity = 0;  

    @Override
    public void setVoltage(double voltage) {
        velocity = voltage * 100;
    }

    @Override
    public void setPower(double power) {
        velocity = power * 3000;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }
}

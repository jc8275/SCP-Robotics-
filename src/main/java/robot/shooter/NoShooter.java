package robot.shooter;

public class NoShooter implements ShooterIO {
    @Override
    public void setVoltage(double voltage) {

    }

    @Override
    public void setPower(double power) {

    }

    @Override
    public double getVelocity() {
        return 0;  
    }
}

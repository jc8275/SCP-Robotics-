package robot.shooter;

public class NoShooter implements ShooterIO {
    @Override
    public void setVoltage(double voltage) {

    }

    @Override
    public double getVelocity() {
        return 0;  
    }

    @Override
    public double getVoltage() {
        // TODO method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVoltage'");
    }
}

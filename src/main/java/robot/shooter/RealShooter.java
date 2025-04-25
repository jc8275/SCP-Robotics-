package robot.shooter;

public class RealShooter implements ShooterIO {
    private double power = 0;

    @Override
    public void setVoltage(double voltage) {

    }

    @Override
    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public double getVelocity() {
       return power * 100; 
    }
}


package robot.shooter;

public class RealShooter implements ShooterIO {
    private double power = 0;

    @Override
    public void setVoltage(double voltage) {
        // In real life, send voltage to motor
        System.out.println("RealShooter: Setting voltage to " + voltage);
    }

    @Override
    public void setPower(double power) {
        this.power = power;
        System.out.println("RealShooter: Setting power to " + power);
    }

    @Override
    public double getVelocity() {
       return power * 100; 
    }
}


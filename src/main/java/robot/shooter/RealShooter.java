package robot.shooter;


public class RealShooter implements ShooterIO {
    private final MotorController shooterMotor;  // Replace with actual motor controller class

    public RealShooter() {
        shooterMotor = new MotorController(ShooterConstants.SHOOTER_MOTOR_ID); // Example motor init
    }

    @Override
    public void setVoltage(double voltage) {
        shooterMotor.setVoltage(voltage);
    }

    @Override
    public void setPower(double power) {
        shooterMotor.set(power);
    }

    @Override
    public double getVelocity() {
        return shooterMotor.getVelocity();  // Replace with actual motor velocity method
    }
}

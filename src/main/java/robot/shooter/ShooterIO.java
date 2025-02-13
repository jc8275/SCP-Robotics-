package robot.shooter;


public interface ShooterIO {
    /** Sets the shooter motor voltage. */
    void setVoltage(double voltage);
    
    /** Sets the shooter motor power. */
    void setPower(double power);
    
    /** Gets the current shooter velocity (RPM). */
    double getVelocity();
}

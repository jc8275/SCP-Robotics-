package robot.shooter;


public interface ShooterIO {

    void setSpeed(double speed);
    void setVoltage(double voltage);
    
    void setPower(double power); // -1 to 1
    
    double getVelocity();
    double getSpeed();
    double getPower();
    void stopShooter();
}

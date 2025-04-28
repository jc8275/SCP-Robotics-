package robot.shooter;


public interface ShooterIO {

    void setSpeed(double speed);
    void setVoltage(double voltage);
    
    void setPower(double power); // -1 to 1
    
    // these are to stop errors because all functions need to root from shooterIO (according 2 quickfix)-> ???
    double getVelocity();
    double getVoltage();
    double getSpeed();
    double getPower();
    double getShooterSpeed();
    void setShooterSpeed(double speed);
    void stopShooter();
}

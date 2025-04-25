package robot.shooter;


public interface ShooterIO {
    void setVoltage(double voltage);
    
    void setPower(double power); // -1 to 1
    
    double getVelocity();
}

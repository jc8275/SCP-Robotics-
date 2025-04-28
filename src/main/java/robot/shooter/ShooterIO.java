package robot.shooter;


public interface ShooterIO {
    void setVoltage(double voltage);

    // these are to stop errors because all functions need to root from shooterIO (according 2 quickfix)-> ???
    double getVoltage();
    double getVelocity();
}

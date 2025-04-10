package robot.storage;

public interface StorageIO {
    void setPower(double power);  // Control the storage motor power (positive for intake, negative for eject)
    double getCurrentLoad();      // Get the current load of items in the storage 
}


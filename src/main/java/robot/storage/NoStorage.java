package robot.storage;

public class NoStorage implements StorageIO {
    @Override
    public void setPower(double power) {
        System.out.println("NoStorage: Ignored setPower with power " + power);
    }

    @Override
    public double getCurrentLoad() {
        return 0;  // Dummy value, no actual load to track
    }
}


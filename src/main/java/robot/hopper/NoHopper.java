package robot.hopper;

@SuppressWarnings("unused")
public class NoHopper implements HopperIO {
  public void setVoltage(double voltage) {}

  public void getVoltage(double voltage) {}

  @Override
  public double getVoltage() {
    // TODO method stub
    throw new UnsupportedOperationException("Unimplemented method 'getVoltage'");
  }
}

package robot.rollerIntake;

// again pretty unnecessary

public interface RollerIntakeIO {
  /** manages power of the intake* */
  void setVoltage(double voltage);

  double getVoltage();
}

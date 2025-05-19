package robot;

public final class Ports {
  // TODO: Add and change all ports as needed.
  public static final class OI {
    public static final int OPERATOR = 0;
    public static final int DRIVER = 1;
  }

  public static final class Intake {
    public static final int INTAKE_MOTOR = 2; //This is for intake

  }

  public static final class Drive {
    public static final int RIGHT_LEADER = 3;
    public static final int RIGHT_FOLLOWER = 4;
    public static final int LEFT_LEADER = 5;
    public static final int LEFT_FOLLOWER = 6;
    public static final int GYRO_CHANNEL = 7;
  }

  public static final class Shooter {
    public static final int SHOOTER_ONE = 8; // replace with the id for the robot later 
  }

  public static final class Hopper {
    public static final int HOPPER_TOP = 9;
    public static final int HOPPER_BOTTOM = 10;
  }
}




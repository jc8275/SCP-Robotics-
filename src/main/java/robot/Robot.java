package robot;

import static edu.wpi.first.units.Units.Seconds;
import static robot.Constants.PERIOD;

import java.util.function.BooleanSupplier;

import org.littletonrobotics.urcl.URCL;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import lib.CommandRobot;
import lib.FaultLogger;
import monologue.Logged;
import monologue.Monologue;
import monologue.Annotations.Log;
import robot.Ports.OI;
import robot.drive.Drive;
import robot.shooter.RealShooter;
import robot.shooter.Shooter;


// Reference: https://github.com/AnkitKumar5250/SummerInstitute2024Team1/blob/main/src/main/java/frc/robot/Robot.java
public class Robot extends CommandRobot {
  private final Shooter shooter = new Shooter(new RealShooter());
  private final Drive drive = new Drive();

  private final CommandXboxController operator = newCommandXboxController(Ports.Operator.driverControllerPort);

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance()
      .schedule(shooter.shoot()); //TODO: drive.drivec(), how to get controller input, doublesuppliers.
  }

  @Override
  public void teleopInit() {
    // Cancels all autonomous commands at the beggining of telop
    CommandScheduler.getInstance().cancelAll();

    // Configures the controller bindings
    commands.configureButtonBindings();
  }

  @Override
  public void simulationInit() {
    // Adds field visualizer to dashboard
    SmartDashboard.putData("Field", field);
  }

  @Override
  public void simulationPeriodic() {

  }
}

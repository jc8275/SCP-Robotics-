package robot;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import static edu.wpi.first.units.Units.Second;

import java.util.function.DoubleSupplier;
import lib.CommandRobot;
import lib.FaultLogger;
import monologue.Annotations.Log;
import monologue.Logged;
import monologue.Monologue;
import robot.drive.Drive;
import robot.shooter.RealShooter;
import robot.shooter.Shooter;

// Reference:
// https://github.com/AnkitKumar5250/SummerInstitute2024Team1/blob/main/src/main/java/frc/robot/Robot.java
public class Robot extends CommandRobot implements Logged {
  private final Shooter shooter = new Shooter(new RealShooter());
  @Log.NT private final Drive drive = new Drive();

  private final CommandXboxController operator = new CommandXboxController(Ports.OI.OPERATOR);

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance()
        .schedule(
            shooter.shoot(),
            drive.drivec(
                new DoubleSupplier() {
                  @Override
                  public double getAsDouble() {
                    return operator.getLeftX();
                  }
                },
                new DoubleSupplier() {
                  @Override
                  public double getAsDouble() {
                    return operator.getRightX();
                  }
                }));
  }

  @Override
  public void teleopInit() {
    // Cancels all autonomous commands at the beggining of telop
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void simulationInit() {
    // Adds field visualizer to dashboard
        DataLogManager.start();
    Monologue.setupMonologue(this, "/Robot", false, true);
    addPeriodic(Monologue::updateAll, Constants.PERIOD.in(Second));
    addPeriodic(FaultLogger::update, 2);
  }

  @Override
  public void simulationPeriodic() {}
}

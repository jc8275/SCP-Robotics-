package robot;

import static edu.wpi.first.units.Units.Seconds;
import static robot.Constants.PERIOD;

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
import robot.shooter.Shooter;


// Reference: https://github.com/AnkitKumar5250/SummerInstitute2024Team1/blob/main/src/main/java/frc/robot/Robot.java
public class Robot extends CommandRobot {
  private final Shooter shooter = new Shooter();
  private final Drive drive = new Drive();

  private final CommandXboxController operator = newCommandXboxController(Ports.Operator.driverControllerPort);
  private final Commands commands = new Commands(shooter, drive, operator);

  public void robotPeriodic() {
    // Updates the command sceduler
    CommandScheduler.getInstance().run();

    // TODO: We dont have a positioning system
    // Updates the robot visualizer
    field.setRobotPose(Positioning.robot);
  }

  @Override
  public void autonomousInit() {
    // Runs the shoot command whenever the beambreak is triggered
    commands.BeamBreak().onTrue(commands.shoot());
    CommandScheduler.getInstance()
      .schedule(commands.shoot()
        .andThen(commands.score(BALL_ONE_POSITION)
          .andThen(commands.score(BALL_TWO_POSITION))
          .andThen(commands.score(BALL_THREE_POSITION)))
        .andThen(run(() -> {
          commands.moveTo(AUTO_SCORE_POS_1).andThen(commands.moveTo(AUTO_SCORE_POS_2));
    })));
  }
}

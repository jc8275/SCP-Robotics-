package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class ShooterSubsystemTester {

    private ShooterSubsystem m_shooterSubsystem;

    public ShooterSubsystemTester(ShooterSubsystem shooterSubsystem) {
        this.m_shooterSubsystem = shooterSubsystem;
    }

    // A simple method to test the shooter motor
    public void testShooterMotor(double speed) {
        // Set the motor speed to the specified value (positive for shooting, negative for reverse)
        m_shooterSubsystem.setShooterSpeed(speed);

        // Print or log the state for manual checking
        System.out.println("Shooter motor set to speed: " + speed);

        // Simulate running the shooter for 2 seconds to see the effect
        Timer.delay(2);

        // Stop the shooter motor after testing
        m_shooterSubsystem.setShooterSpeed(0);
        System.out.println("Shooter motor stopped.");
    }
}


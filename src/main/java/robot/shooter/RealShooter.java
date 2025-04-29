package subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RealShooter extends SubsystemBase {
    public enum HoodPosition { UP, DOWN }   //Our shooter is fixed so change this

    private static final int kShooterMasterCANID = 1;
    private static final int kShooterSlaveCANID = 2;
    private static final int kBallSensorDIO = 0;
    private static final int kHoodSolenoidForward = 0;
    private static final int kHoodSolenoidReverse = 1;

    private final CANSparkMax m_shooterMaster;
    private final CANSparkMax m_shooterSlave;
    private final RelativeEncoder m_encoder;
    private final SparkMaxPIDController m_pid;
    private final DigitalInput m_ballSensor;
    private boolean m_prevBallDetected = false;
    private int m_ballCount = 0;
    private final DoubleSolenoid m_hoodSolenoid;
    private HoodPosition m_hoodPosition = HoodPosition.DOWN;

    public RealShooter() {
        m_shooterMaster = new CANSparkMax(kShooterMasterCANID, MotorType.kBrushless);
        m_shooterSlave = new CANSparkMax(kShooterSlaveCANID, MotorType.kBrushless);
        m_shooterMaster.restoreFactoryDefaults();
        m_shooterSlave.restoreFactoryDefaults();

        m_shooterSlave.follow(m_shooterMaster, true); // Invert if needed

        m_encoder = m_shooterMaster.getEncoder();
        m_pid = m_shooterMaster.getPIDController();
        m_pid.setFeedbackDevice(m_encoder);

        // PID Constants (You must tune these!)
        m_pid.setP(0.0005);
        m_pid.setI(0.0);
        m_pid.setD(0.0);
        m_pid.setFF(0.0002); // Feedforward for RPM
        m_pid.setOutputRange(-1.0, 1.0);

        m_shooterMaster.setSmartCurrentLimit(40); // Optional safety

        m_ballSensor = new DigitalInput(kBallSensorDIO);

        m_hoodSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
                                            kHoodSolenoidForward, kHoodSolenoidReverse);
        setHoodPosition(HoodPosition.DOWN);
    }

    /** Set shooter velocity (RPM) using closed-loop control. */
    public void setShooterRPM(double rpm) {
        m_pid.setReference(rpm, CANSparkMax.ControlType.kVelocity);
    }

    /** Stop shooter motor. */
    public void stopShooter() {
        m_shooterMaster.stopMotor();
    }

    /** Returns current RPM. */
    public double getShooterVelocity() {
        return m_encoder.getVelocity(); // RPM by default
    }

    /** Set the hood position. */
    public void setHoodPosition(HoodPosition position) {
        m_hoodPosition = position;
        m_hoodSolenoid.set(position == HoodPosition.UP
            ? DoubleSolenoid.Value.kForward
            : DoubleSolenoid.Value.kReverse);
    }

    /** Toggle the hood. */
    public void toggleHood() {
        setHoodPosition(m_hoodPosition == HoodPosition.UP ? HoodPosition.DOWN : HoodPosition.UP);
    }

    public int getBallCount() {
        return m_ballCount;
    }

    public void resetBallCount() {
        m_ballCount = 0;
    }

    @Override
    public void periodic() {
        boolean ballDetected = !m_ballSensor.get();
        if (ballDetected && !m_prevBallDetected) {
            m_ballCount++;
        }
        m_prevBallDetected = ballDetected;

        SmartDashboard.putNumber("Shooter RPM", getShooterVelocity());
        SmartDashboard.putNumber("Ball Count", m_ballCount);
        SmartDashboard.putBoolean("Hood Up", m_hoodPosition == HoodPosition.UP);
    }
}




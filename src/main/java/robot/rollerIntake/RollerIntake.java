package robot.rollerIntake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;
import robot.rollerIntake.RollerIntakeConstants;

public class RollerIntake extends SubsystemBase{
    private final CANSparkMax intakeMotor;

    public RollerIntake() {
        this.intakeMotor = new CANSparkMax(1, MotorType.kBrushed);
    }
    
    public void intake(double speed){
        intakeMotor.set(RollerIntakeConstants.ROLLER_INTAKE_SPEED);
    }
    public void stop(double speed){
        intakeMotor.set(RollerIntakeConstants.ROLLER_INTAKE_STOP);
    }
    public void reverse(double speed){
        intakeMotor.set(RollerIntakeConstants.ROLLER_INTAKE_REVERSE_SPEED);
    }
    
}


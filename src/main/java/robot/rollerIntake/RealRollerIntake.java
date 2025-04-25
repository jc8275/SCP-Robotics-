package robot.rollerIntake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import robot.Ports;

public class RealRollerIntake implements RollerIntakeIO{
    private CANSparkMax intakeMotor;

    public RealRollerIntake(){
    intakeMotor = new CANSparkMax(Ports.Intake.INTAKE_MOTOR, MotorType.kBrushless);
}

    public void setPower(double power){
        intakeMotor.set(power);

    }
}



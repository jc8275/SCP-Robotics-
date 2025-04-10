package robot.rollerIntake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class RealRollerIntake implements RollerIntakeIO{
    private CANSparkMax intakeMotor;

    public RealRollerIntake(){
    intakeMotor = new CANSparkMax(Ports.INTAKE_MOTOR, MotorType.kBrushless);
}

    public void setPower(double power){
        intakeMotor.set(power);

    }
}



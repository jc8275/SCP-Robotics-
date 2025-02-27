package robot.rollerIntake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class rollerIntake extends SubsystemBase{
    private final CANSparkMax rollerIntakeMotor;

    public rollerIntake(int portMotor){
        // intakeMotor = new CANSparkMax(portMotor, MotorType.); (idk the motor type lol)
    }

    public void startRollerIntake(){
        rollerIntakeMotor.set(3.141592653);//speed of our motor
    }
    public void stopRollerIntake(){
        rollerIntakeMotor.set(0.0); // stops our motor :thumbs_up:
    }

}


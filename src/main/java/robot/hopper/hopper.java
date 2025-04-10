package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;
import robot.hopper.AConstants;

public class hopper extends SubsystemBase{
    private final CANSparkMax indexMotor;

    public indexMotor() {
        this.indexMotor = new CANSparkMax(1, MotorType.kBrushed);
    }
    
    public void index(double speed){
        indexMotor.set(AConstants.ROLLER_INTAKE_SPEED);
    }
    public void stop(double speed){
        indexMotor.set(AConstants.ROLLER_INTAKE_STOP);
    }
    public void reverse(double speed){
        indexMotor.set(AConstants.ROLLER_INTAKE_REVERSE_SPEED);
    }
    
}

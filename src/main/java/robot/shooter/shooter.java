package robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {


    private final CANSparkMax motor;


    public MotorSubsystem(int canId, MotorType motorType) {
        motor = new CANSparkMax(canId, motorType);
    }

  
    public void setSpeed(double speed) {
        motor.set(speed);
    }

 
    public void stop() {
        motor.stopMotor();
    }


    @Override
    public void periodic() {
       
    }
}

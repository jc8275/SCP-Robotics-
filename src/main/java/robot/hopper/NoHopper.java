package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

@SuppressWarnings("unused")
public class NoHopper implements HopperIO {
    public void setVoltage(double voltage) {
        
    }
    public void getVoltage(double voltage) {
        
    }
    @Override
    public double getVoltage() {
        // TODO method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVoltage'");
    }
}

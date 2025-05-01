package robot.hopper;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class RealHopper implements HopperIO {
    private final CANSparkMax hopperTop;
    private final CANSparkMax hopperBottom;

    public RealHopper() {
        hopperTop = new CANSparkMax(Ports.Hopper.HOPPER_TOP, MotorType.kBrushless);
        hopperBottom = new CANSparkMax(Ports.Hopper.HOPPER_BOTTOM, MotorType.kBrushless);

        hopperBottom.follow(hopperTop);
        hopperBottom.setInverted(true);
    }

    @Override 
    public void setVoltage(double voltage) {
        
    }
    @Override
    public double getVoltage() {
        return hopperTop.getBusVoltage();
        
    }
}

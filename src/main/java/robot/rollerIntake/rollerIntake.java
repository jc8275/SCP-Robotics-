package robot.rollerIntake;

<<<<<<< HEAD
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
//TODO this import is the engines from difdrive. probably not the right ones. change later. URGENT.
=======
>>>>>>> 1f040ed (added subsystems)
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class rollerIntake extends SubsystemBase{
 // these are just some constants to define things like the speed of the roller intake depending on what it is currently doing
 // TODO: add more constants as needed
    public static final double ROLLER_INTAKE_SPEED = 0.5;
    public static final double ROLLER_INTAKE_REVERSE_SPEED = -0.5; 
    public static final double ROLLER_INTAKE_STOP = 0.0;
    public static final double ROLLER_MAX_SPEED = 1.0;
    public static final double ROLLER_MIN_SPEED = -1.0;

}


package robot.rollerIntake;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;

public class rollerIntakeConstants extends SubsystemBase{
     // these are just some constants to define things like the speed of the roller intake depending on what it is currently doing
 // TODO: add more constants as needed
 public static final double ROLLER_INTAKE_SPEED = 0.5;
 public static final double ROLLER_INTAKE_REVERSE_SPEED = -0.5; 
 public static final double ROLLER_INTAKE_STOP = 0.0;
 public static final double ROLLER_MAX_SPEED = 1.0;
 public static final double ROLLER_MIN_SPEED = -1.0;

}


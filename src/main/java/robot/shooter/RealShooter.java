package robot.shooter;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 
public class RealShooter implements ShooterIO {
    private final CANSparkMax shooterMotor; //we need our motor, ofc
    private double voltage = 0;
    private double power = 0;
    private double speed = 0;

    public RealShooter() {//constructor 
        shooterMotor = new CANSparkMax(ShooterConstants.SHOOTER_MOTOR_ID, MotorType.kBrushed); //OK, so we're gonna have to fix the motor type cuz i just put some random "kbrushed" there. no idea what that means
    }
    @Override
    public double getSpeed(){ //gets velocity of our motor's encoder
        return shooterMotor.getEncoder().getVelocity();
       }
    @Override
    public void setSpeed(double speed){
        this.speed=speed;
        ((ShooterIO)shooterMotor).setSpeed(this.speed);
    }
    @Override
    public void stopShooter(){
        shooterMotor.set(0);//self explanitory
        setPower(0);
        setVoltage(0);
    }

    @Override 
    public void setVoltage(double voltage){// just gives us the voltage
        this.voltage=voltage;
        shooterMotor.setVoltage(this.voltage);
    }
    @Override
    
    public double getVoltage(){// returns voltage of motor 
        return voltage;
    } 

    @Override
    public void setPower(double power){//same thing as voltage
        this.power = power;
    ((ShooterIO) shooterMotor).setPower(this.power);
    }
    @Override 
    public double getPower(){
        return power;
    }

    }



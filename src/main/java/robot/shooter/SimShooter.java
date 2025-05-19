// package robot.shooter;

// public class SimShooter implements ShooterIO {
//     private double voltage =0;
//     private double power = 0;
//     private double speedCurrent =0;
// //Ok so i'm guessing this "simShooter" is tryna simulate values? So we would want it to say all
// the values to make sure we have them all
// //getting simulated values for speed
//     @Override
//     public void setSpeed(double speed) {
//         speedCurrent = speed;
//     System.out.println("shooter speed is " +speedCurrent);
//     }
//     @Override
//     public double getSpeed(){
//         return speedCurrent;
//     }
//     @Override
//     public void stopShooter(){
//         speedCurrent = ShooterConstants.SPEED_MIN;
//     System.out.println("the shooter stopped");
//     }
// //getting simulated values for voltage
//     @Override
//     public void setVoltage(double voltage){
//         this.voltage = voltage;
//     System.out.println("this is the voltage "+voltage);
//     }
//     @Override

//     public double getVoltage(){
//         return voltage;
// }

// //geting simulated values for power
//     @Override public void setPower(double power){
//         this.power = power;
//     System.out.println("this is the power "+power);
//     }
//     @Override
//     public double getPower(){
//     return power;
//     }
// }

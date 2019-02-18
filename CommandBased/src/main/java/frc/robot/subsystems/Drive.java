/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.commands.Movement;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {

  public WPI_TalonSRX BR;
  public WPI_TalonSRX FL;
  public WPI_TalonSRX FR;
  public WPI_TalonSRX BL;

  public Drive(){
    BR = new WPI_TalonSRX(2);
    FL = new WPI_TalonSRX(4);
    FR = new WPI_TalonSRX(1);
    BL = new WPI_TalonSRX(3);

    FL.setInverted(true);
    BL.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Movement());
  }

  public void move(double left, double right){
    FL.set(left);
    BL.set(left);
    FR.set(right);
    BR.set(right);
  }

  double integral, error, derivative, prev, zerror = 0;
  double kP = 0.0002;
  double kI = 0.00002;
  double kD = 0.0;
  
  public void PID(double left, double right) {
    double speedL = OI.enc_L.getRate();
    double speedR = OI.enc_R.getRate();
    double speedZ = OI.navx.getRate();

    error = speedR - speedL;  
    integral += error;
    derivative = speedZ; 

    double correction = (error * kP) + (integral * kI) + (derivative * kD);
    left -= correction;
    right += correction;
    move(left, right);
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class ExactMove extends Command {

  double distance, vel, init;
  
  public ExactMove(double dist) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.d);
    distance = dist;
    
  }

  // Called just before this Command runs the first time
  double deg = ((distance*60) / (Math.PI)) - init;

  @Override
  protected void initialize() {
    init = OI.enc_L.getRate();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Deceleration(deg);
    Robot.d.PID(vel, vel);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return OI.enc_L.get()-init >= deg;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

  }

  double k = 0.001;

  public void Deceleration(double deg) {
    double rate = OI.enc_L.get() - init;
    if(rate <= 0.25*deg) {
      vel = k*(rate);
    } else if (rate >= 0.75*deg) {
      vel = k*(deg-rate);
    } else {
      vel = k*0.5*deg;
    }
  }

}

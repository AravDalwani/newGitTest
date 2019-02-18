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

public class Turn extends Command {

  
  double deg;

  public Turn(double angle) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.d);
    deg = angle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double error = deg - OI.navx.getFusedHeading();
    double kP = 0.001;
    if (Math.abs(error) > 180) { Robot.d.move(error*kP, -error*kP); }
    else { Robot.d.move(-error*kP, error*kP); }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (deg-2 <= OI.navx.getFusedHeading() && OI.navx.getFusedHeading() <= deg+2) {
      return true;
    }
    return false;
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


}

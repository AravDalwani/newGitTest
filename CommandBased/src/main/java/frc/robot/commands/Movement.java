/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class Movement extends Command {
  public Movement() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.d);
  }

  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double yaxis = OI.stick.getRawAxis(1);
    double zaxis = OI.stick.getRawAxis(2);
    
    if ( Math.abs(zaxis) >= 0.2) {
      Robot.d.move(-zaxis*0.2,zaxis*0.2);
    } 
    else if (Math.abs(yaxis) >= 0.1){ 
      Robot.d.PID(yaxis*0.2, yaxis*0.2); 
    }
    else { 
      Robot.d.move(0,0); 
    } 

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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

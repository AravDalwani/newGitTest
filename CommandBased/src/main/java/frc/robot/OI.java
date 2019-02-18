/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.ExactMove;
import frc.robot.commands.Turn;
import frc.robot.commands.ShootForward;
import frc.robot.commands.ShootBackward;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {

  public static Joystick stick = new Joystick(1);
  public static Encoder enc_R = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
  public static Encoder enc_L = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
  public static AHRS navx = new AHRS(SPI.Port.kMXP);

  /*
  public static Button button1 = new JoystickButton(stick, 1);
  public static Button button2 = new JoystickButton(stick, 2);
  public static Button button3 = new JoystickButton(stick, 3);
  public static Button button4 = new JoystickButton(stick, 4);
  public static Button button5 = new JoystickButton(stick, 5);
  */
  public static AnalogInput ultrasonic = new AnalogInput(0);
  

  public OI() {
    
    //button2.whenPressed(new Turn(0));
    //button3.whenPressed(new ShootForward());
    //button4.whenPressed(new ShootBackward());
    //button5.whenPressed(new ExactMove(20));

  }
  

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}

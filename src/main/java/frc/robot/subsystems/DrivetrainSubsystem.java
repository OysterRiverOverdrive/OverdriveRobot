// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


  
public class DrivetrainSubsystem extends SubsystemBase
 {

  // in our robot we have two motors on left
  private final PWMVictorSPX m_left1 = new PWMVictorSPX(0);
  private final PWMVictorSPX m_left2 = new PWMVictorSPX(1);
  MotorControllerGroup m_left = new MotorControllerGroup(m_left1, m_left2);

  // in our robot we have two motors on right
  private final PWMVictorSPX m_right1 = new PWMVictorSPX(2);
  private final PWMVictorSPX m_right2 = new PWMVictorSPX(3);
  MotorControllerGroup m_right = new MotorControllerGroup(m_right1, m_right2);

  // we use diffrential drive
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);

  // we use two joysticks.
  private final Joystick m_stick = new Joystick(0);
  private final Joystick m_action = new Joystick(1);
  // Sets Drive joystick port

  /** Creates a new MyDriveTrain. */
  public DrivetrainSubsystem() 
  {

  }

  @Override
  public void periodic()
   {
    // double dist_test1 = m_left1;
    // SmartDashboard.putNumber("left front", dist_test1);
    // This method will be called once per scheduler run
  }


  /** This is the method that makes the bot go fwd. It takes the X and Y from the joystick */
  public void driveTheBot()
  {
    // m_robotDrive.arcadeDrive(-.80 * m_stick.getY(), .6 * m_stick.getX());
    m_robotDrive.tankDrive(.8*m_stick.getY(), .8*m_action.getY());

  }


  /** This method stops the bot by stopping all the motors */
  public void stopDriving()
  {
    m_robotDrive.stopMotor();
  }


  /**  This method drives the robot forward 
   * This can be called by the autonomous routine
  */
  public void autoDrive()
  {
    m_robotDrive.tankDrive(.8, .8);
  }

}

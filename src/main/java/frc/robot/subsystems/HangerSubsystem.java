// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


  
public class HangerSubsystem extends SubsystemBase
 {

  // in our robot we have two motors on left
  private final PWMVictorSPX m_1 = new PWMVictorSPX(0);
  private final PWMVictorSPX m_2 = new PWMVictorSPX(1);
  MotorControllerGroup m_bottom = new MotorControllerGroup(m_1, m_2);

  // in our robot we have two motors on right
  private final PWMVictorSPX m_3 = new PWMVictorSPX(2);
  private final PWMVictorSPX m_4 = new PWMVictorSPX(3);
  MotorControllerGroup m_upper = new MotorControllerGroup(m_3, m_4);

  // we use diffrential drive
  private final DifferentialDrive m_robotHang = new DifferentialDrive(m_bottom, m_upper);

  // we use two joysticks.
  // private final Joystick m_stick = new Joystick(0);
  // Sets Drive joystick port

  /** Creates a new MyDriveTrain. */
  public HangerSubsystem() 
  {

  }

  @Override
  public void periodic()
   {
    // This method will be called once per scheduler run
  }


  /** This is the method that makes the bot go fwd. It takes the X and Y from the joystick */
  public void starthang()
  {
    // m_robotHang.set(1.0);
  }


  /** This method stops the bot by stopping all the motors */
  public void stophang()
  {
    
  }


  /**  This method drives the robot forward 
   * This can be called by the autonomous routine
  */
  
}

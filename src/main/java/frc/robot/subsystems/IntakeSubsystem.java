// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class IntakeSubsystem extends SubsystemBase 
{

  private final PWMVictorSPX m_intake = new PWMVictorSPX(9);

  private final Joystick m_stick = new Joystick(0);

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() 
  {

  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

public void runIntake()
{ 
  m_intake.set(-.80 * m_stick.getY());
   
}

public void stopIntake()
{
   m_intake.set(0); 
}

}
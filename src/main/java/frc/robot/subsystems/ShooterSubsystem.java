// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSubsystem extends SubsystemBase {
  PWMVictorSPX shooterRight = new PWMVictorSPX(4);
  PWMVictorSPX shooterLeft = new PWMVictorSPX(5);

  MotorControllerGroup shooterGroup = new MotorControllerGroup(shooterLeft, shooterRight);
  // Assign a motors to a group

  private static final int kJoystickPort = 1;
  // Sets shooter joystick port
  private Joystick m_joystick;
  
  @Override
  public void periodic() {
    
  }
  public void shoot () {
    m_joystick = new Joystick(kJoystickPort);
    // import a joystick
    shooterLeft.setInverted(true);
    // invert a motor to spin same direction
    if (m_joystick.getY() > 0){
      shooterGroup.set(0);
    } else {
      shooterGroup.set(m_joystick.getY());
    }
    
    // associate motor speed with joystick Y-axis
  }
  public void stopShoot () {
    shooterGroup.set(0);
    // Stop shooter group
  }
}

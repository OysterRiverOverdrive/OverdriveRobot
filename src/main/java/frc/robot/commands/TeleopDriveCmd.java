// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// Libraries used by this command
import edu.wpi.first.wpilibj2.command.CommandBase;

// remember that a command needs a subsystem ALWAYS
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopDriveCmd extends CommandBase 
{

   private static DrivetrainSubsystem teleopDrive ;
  
  /** Creates a new DriverCommand. The constructor takes the subsystem */
  public TeleopDriveCmd(DrivetrainSubsystem drvTrain) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    teleopDrive = drvTrain;
    addRequirements(teleopDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {

  }

  // Called every time the scheduler runs while the command is scheduled.
  // This is called automatically
  // This is where we call the method on the subsystem that we want.
  @Override
  public void execute() 
  {
     my_driveTrain.driveTheBot();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// Libraries used by this command
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriverCommand extends CommandBase 
{

   private static DrivetrainSubsystem my_driveTrain ;
  
  /** Creates a new DriverCommand. The constructor takes the subsystem */
  public DriverCommand(DrivetrainSubsystem drvTrain) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    my_driveTrain = drvTrain;
    addRequirements(my_driveTrain);
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

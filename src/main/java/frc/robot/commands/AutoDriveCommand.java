// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Timer;


public class AutoDriveCommand extends CommandBase
 {

  private static DrivetrainSubsystem my_Auto_driveTrain ;
  private Timer m_timer = new Timer();
  /** Creates a new AutoDriveCommand. */
   /** Creates a new DriverCommand. */
   public AutoDriveCommand(DrivetrainSubsystem drvTrain) 
   {
     // Use addRequirements() here to declare subsystem dependencies.
     my_Auto_driveTrain = drvTrain;
     addRequirements(my_Auto_driveTrain);
   }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    System.out.println(">>>>>>>>>>>>>>> Auto Init >>>>>>>>>>>>>> ");
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    my_Auto_driveTrain.autoDrive();
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
    System.out.println(">>>>>>>>>>>>>>> Is Finished >>>>>>>>>>>>>> ");
    boolean retval;
    if(m_timer.get()>=10)
    // Time for driving forwards
      retval = true;
    else
       retval = false; 

    System.out.println(">>>>>>>>>>>>>>> RETVAL >>>>>>>>>>>>>> " + retval);   
    return retval;
  }
}

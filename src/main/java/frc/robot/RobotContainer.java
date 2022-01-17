package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
// import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.TeleopDriveCmd;
import frc.robot.commands.shootCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.stopShoot;

// added imports
// import edu.wpi.first.wpilibj.Joystick;
// import frc.robot.subsystems.DrivetrainSubsystem;
// import frc.robot.commands.TeleopDriveCmd;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...
  
  private final DrivetrainSubsystem drvTrain = new DrivetrainSubsystem();
  private final TeleopDriveCmd teleop = new TeleopDriveCmd(drvTrain);

  
  private final ShooterSubsystem shooterSubSys = new ShooterSubsystem();
  private final shootCommand shoot = new shootCommand(shooterSubSys);
  private final stopShoot stopShoot = new stopShoot(shooterSubSys);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // this is the defaut command and is always scheduled if nothing else is using the same sub system
    drvTrain.setDefaultCommand(teleop);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    JoystickButton triggerButton = new JoystickButton(new Joystick(0), 5);
    // Sets joystick button
    triggerButton.whenPressed(shoot);
    // Turn on shooter when button is pressed
    triggerButton.whenReleased(stopShoot);
    // Turn off shooter when button is released
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand()
  //  {
  //   // Command will run in autonomous
  //   // return m_autoCommand;
  // }
}

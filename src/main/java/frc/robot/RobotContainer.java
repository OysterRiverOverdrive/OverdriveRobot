package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.DriverCommand;
import frc.robot.commands.shootCommand;
import frc.robot.subsystems.MyDriveTrain;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.stopShoot;
import frc.robot.commands.hangCommand;
import frc.robot.commands.stopHangCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...
  
  private final MyDriveTrain dt = new MyDriveTrain();
  private final DriverCommand dCmd = new DriverCommand(dt);
  private final AutoDriveCommand dAutoCmd = new AutoDriveCommand(dt);
  
  private final ShooterSubsystem shooterSubSys = new ShooterSubsystem();
  private final shootCommand shoot = new shootCommand(shooterSubSys);
  private final stopShoot stopShoot = new stopShoot(shooterSubSys);

  private final HangerSubsystem hanger = new HangerSubsystem();
  private final hangCommand hang = new hangCommand(hanger);
  private final stopHangCommand stopHang = new stopHangCommand(hanger);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // this is the defaut command and is always scheduled if nothing else is using the same sub system
    dt.setDefaultCommand(dCmd);
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
    JoystickButton hangButton = new JoystickButton(new Joystick(0), 4);
    //sets hang button
    hangButton.whenPressed(hang);
    //Turn on hanger when button is pressed
    hangButton.whenReleased(stopHang);
    //Turn off hanger when button is released
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
   {
    // Command will run in autonomous
    return dAutoCmd;
  }
}
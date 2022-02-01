package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangerSubsystem;

public class hangCommand extends CommandBase {

    private HangerSubsystem Hanger;
    public hangCommand(HangerSubsystem hang){
        Hanger = hang;
        addRequirements(Hanger);
    }

    @Override
    public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Hanger.hang();
    }

  // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

  // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class HangerSubsystem extends SubsystemBase {
    
    PWMVictorSPX hangerMotor1 = new PWMVictorSPX(6);
    PWMVictorSPX hangerMotor2 = new PWMVictorSPX(7);
    MotorControllerGroup hangerGroup = new MotorControllerGroup(hangerMotor1, hangerMotor2);
    

    public void hang(){
        hangerGroup.set(1.0);
    }

    public void stopHanging(){
        hangerGroup.set(0.0);
    }

    public HangerSubsystem() {}

    @Override
    public void periodic() {}
    // This method will be called once per scheduler run
}

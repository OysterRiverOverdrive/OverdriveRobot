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
<<<<<<< Updated upstream
    public void periodic() {}
=======
    public void periodic() {
      arm_Encoder.setDistancePerRotation(1.0);
      clip_Encoder.setDistancePerRotation(1.0);
      rotate_Encoder.setDistancePerRotation(1.0);
    }}
>>>>>>> Stashed changes
    // This method will be called once per scheduler run
}

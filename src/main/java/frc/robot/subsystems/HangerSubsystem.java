
package frc.robot.subsystems;


// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class HangerSubsystem extends SubsystemBase {
    
    PWMVictorSPX armMotor1 = new PWMVictorSPX(6);
    PWMVictorSPX armMotor2 = new PWMVictorSPX(7);
    MotorControllerGroup armGroup = new MotorControllerGroup(armMotor1, armMotor2);
    PWMVictorSPX clipMotor1 = new PWMVictorSPX(8);
    PWMVictorSPX clipMotor2 = new PWMVictorSPX(9);
    MotorControllerGroup clipGroup = new MotorControllerGroup(clipMotor1, clipMotor2);
    PWMVictorSPX rotateMotor = new PWMVictorSPX(10);

    private DutyCycleEncoder arm_Encoder = new DutyCycleEncoder(0);
    private DutyCycleEncoder clip_Encoder = new DutyCycleEncoder(0);
    private DutyCycleEncoder rotate_Encoder = new DutyCycleEncoder(0);
    
    public void armUp(int upDist){
        arm_Encoder.reset();
        if(arm_Encoder.getDistance() < upDist){
            armGroup.set(1.0);
        }
        else{
            armGroup.set(0.0);
        }
    }

    public void armDown(int downDist){
        arm_Encoder.reset();
        armGroup.setInverted(true);
        if(arm_Encoder.getDistance() < downDist){
            armGroup.set(1.0);
        }
        else{
            armGroup.set(0.0);
        }
    }
    public void rotateRight(int rightDist){
        rotate_Encoder.reset();
        if(rotate_Encoder.getDistance() < rightDist)
        {
            rotateMotor.set(1.0);
        }
        else{
            rotateMotor.set(0.0);
        }
    }

    public void rotateLeft(int leftDist){
        rotate_Encoder.reset();
        rotateMotor.setInverted(true);
        if(rotate_Encoder.getDistance() < leftDist)
        {
            rotateMotor.set(1.0);
        }
        else{
            rotateMotor.set(0.0);
        }   
    }

    public void clipUp(int clipUpDist){
        clip_Encoder.reset();
        if(clip_Encoder.getDistance() < clipUpDist){
            clipGroup.set(1.0);
        }
        else{
            clipGroup.set(0.0);
        }
    }

    public void clipDown(int clipDownDist){
        clip_Encoder.reset();
        if(clip_Encoder.getDistance() < clipDownDist){
            clipGroup.set(1.0);
        }
        else{
            clipGroup.set(0.0);
        }
    }


    public HangerSubsystem() {}

    @Override
    public void periodic() {
      arm_Encoder.setDistancePerRotation(1.0);
      clip_Encoder.setDistancePerRotation(1.0);
      rotate_Encoder.setDistancePerRotation(1.0);
    }
    // This method will be called once per scheduler run

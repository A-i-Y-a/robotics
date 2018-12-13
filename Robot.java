import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

class Robot extends TimedRobot {

    WPI_TalonSRX motorFL;
    WPI_TalonSRX motorFR;
    WPI_TalonSRX motorBL;
    WPI_TalonSRX motorBR;
    SpeedControllerGroup right;
    SpeedControllerGroup left;
    DifferentialDrive drive;
    XboxController controller;
    
    public void robotInit() {
        motorFL = new WPI_TalonSRX(1);
        motorFR = new WPI_TalonSRX(2);
        motorBL = new WPI_TalonSRX(3);
        motorBR = new WPI_TalonSRX(4);
        
        controller = new XboxController(0);
        
        left = new SpeedControllerGroup(motorFL, motorBL);
        right = new SpeedControllerGroup(motorFR, motorBR);
        
        drive = new DifferentDrive(left, right);
    }

    public void teleopInit() {
        
    }
    
    public void teleopPeriodic() {
        

        if (controller.getAButton() == true) {
            
            double driveSpeedLeft = controller.getY(GenericHID.Hand.kLeft);
            double turnSpeedLeft = controller.getX(GenericHID.Hand.kLeft);
            drive.arcadeDrive(driveSpeedLeft, turnSpeedLeft);
        }
        
        else if (controller.getBumper (GenericHID.hand left) == true) {
            
            double driveSpeedLeft = controller.getY(GenericHID.Hand.kLeft);
            double turnSpeedRight = controller.getX(GenericHID.Hand.kRight);
            drive.arcadeDrive(driveSpeedLeft, turnSpeedRight);
        }
        
        else if (controller.getBumper (GenericHID.hand right) == true) {
            
            double driveSpeedRight = controller.getY(GenericHID.Hand.kRight);
            double turnSpeedLeft = controller.getX(GenericHID.Hand.kLeft);
            drive.arcadeDrive(driveSpeedRight, turnSpeedLeft);
        }
        
        //spinning
        else if (controller.getAButton() == true) {
        
            drive.arcadeDrive(0, -1);
        }
    }
    
}
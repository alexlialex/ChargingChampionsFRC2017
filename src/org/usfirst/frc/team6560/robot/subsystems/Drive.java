package org.usfirst.frc.team6560.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team6560.robot.RobotMap.Can;
import org.usfirst.frc.team6560.robot.commands.DriveWithJoysticks;

public class Drive extends Subsystem {
    CANTalon leftTopMotor = new CANTalon(Can.LEFT_FWD_MOTOR);
    CANTalon leftBottomMotor = new CANTalon(Can.LEFT_REAR_MOTOR);
    CANTalon rightTopMotor = new CANTalon(Can.RIGHT_FWD_MOTOR);
    CANTalon rightBottomMotor = new CANTalon(Can.RIGHT_REAR_MOTOR);
    RobotDrive drivetrain = new RobotDrive(leftTopMotor, leftBottomMotor, rightTopMotor, rightBottomMotor);
    public ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public Drive() {
    	gyro.calibrate();
    }
    
    public void driveWithJoysticks(double left, double right) {
    	drivetrain.tankDrive(left, right);
    }
    
    public void driveWithPOV(int angle) {
    	switch(angle) {
    	case 0:
    		drivetrain.tankDrive(-0.5, -0.5);
    	case 90:
    		drivetrain.tankDrive(-0.3, 0.3);
    	case 180:
    		drivetrain.tankDrive(0.5, 0.5);
    	case 270:
    		drivetrain.tankDrive(0.3, -0.3);
    	}
    }
    
    public void driveStraight() {
    }
    
    public void driveStraightBackwards() {
    }
    
    public void turn90DegreesLeft() {
    }
    
    public void turn90DegreesRight() {
    }
    
    public void turnToAngle(int angle) {
    	
    }
    
    public void stop() {
    	leftTopMotor.set(0);
    	leftBottomMotor.set(0);
    	rightTopMotor.set(0);
    	rightBottomMotor.set(0);
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    }
}

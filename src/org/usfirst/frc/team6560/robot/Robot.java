package org.usfirst.frc.team6560.robot;

import org.usfirst.frc.team6560.robot.subsystems.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;

	//Subsystems
	public static Drive drive;
	public static GearMission gearMission;
	private static SendableChooser chooser;
	private CameraServer cam0 = CameraServer.getInstance();
	
	Command autonomousCommand;
	
    public void robotInit() {
    	drive = new Drive();
		chooser = new SendableChooser();
		gearMission = new GearMission();
		cam0.startAutomaticCapture();	
		oi = new OI();
		gearMission.compressor_0.start();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    
    }
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	if(autonomousCommand != null)
    		autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Ultrasound Distance", gearMission.ultrasound.getVoltage());
    	SmartDashboard.putNumber("Angle", drive.imu.getAngle());
    	SmartDashboard.putNumber("Acceleration", drive.imu.getAccelX());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}

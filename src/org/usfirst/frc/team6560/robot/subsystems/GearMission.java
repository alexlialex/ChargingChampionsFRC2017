package org.usfirst.frc.team6560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6560.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;

public class GearMission extends Subsystem {

	public Solenoid solenoid_0 = new Solenoid(RobotMap.Can.SOLENOID_0);
	public Solenoid solenoid_1 = new Solenoid(RobotMap.Can.SOLENOID_1);
	public Solenoid solenoid_2 = new Solenoid(RobotMap.Can.SOLENOID_2);
	public Solenoid solenoid_3 = new Solenoid(RobotMap.Can.SOLENOID_3);
	public Compressor compressor_0 = new Compressor(RobotMap.Can.COMPRESSOR);
	public Servo gearServo = new Servo(RobotMap.Pwm.GEAR_SERVO);
	public boolean gearShiftStatus;
	
	/**
	 * Starts compressor when initialized
	 */
	public GearMission() {
		compressor_0.setClosedLoopControl(true);
	}
	
	/**
	 * Opens the two flaps on the gear collection system
	 */
    public void openFlaps() {
    	solenoid_0.set(true);
    	solenoid_3.set(true);
    }
    
    /**
     * Closes the two flaps on the gear collection system
     */
    public void closeFlaps() {
    	solenoid_0.set(false);
    	solenoid_3.set(false);
    }
    
    /**
     * Tilts servo to receive gear from gear drop
     */
    public void collectGear() {
    	//gearServo.set(0); // for backup robot
    	gearServo.set(1); // for real robot
    }
    
    /**
     * Resets servo to default position
     */
    public void resetServo() {
    	//gearServo.set(0.55); // for backup robot
    	gearServo.set(0.45); // for real robot
    }
    
    /**
     * Activates piston to push gear out of gear collection system
     */
    public void pushGear() {
    	solenoid_1.set(true);
    }
    
    /**
     * Retracts pusher piston
     */
    public void retract() {
    	solenoid_1.set(false);
    }
    
    public void initDefaultCommand() {
    	compressor_0.start();
    	solenoid_0.set(false);
    	solenoid_1.set(false);
    	solenoid_2.set(false);
    	solenoid_3.set(false);
    }
}

 

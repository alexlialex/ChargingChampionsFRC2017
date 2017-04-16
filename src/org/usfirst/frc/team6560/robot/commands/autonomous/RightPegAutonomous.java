package org.usfirst.frc.team6560.robot.commands.autonomous;

import org.usfirst.frc.team6560.robot.commands.DeployGear;
import org.usfirst.frc.team6560.robot.commands.DriveStraightBackwardsTime;
import org.usfirst.frc.team6560.robot.commands.DriveStraightTime;
import org.usfirst.frc.team6560.robot.commands.ResetGear;
import org.usfirst.frc.team6560.robot.commands.StopDriveTime;
import org.usfirst.frc.team6560.robot.commands.TurnToAngle;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Time-based autonomous program that drops gear on right peg
 */
public class RightPegAutonomous extends CommandGroup {

    public RightPegAutonomous() {
    	addSequential(new DriveStraightTime(1.3, 0.5));
    	addSequential(new StopDriveTime(0.5));
    	addSequential(new TurnToAngle(-38));
    	addSequential(new StopDriveTime(0.5));
    	addSequential(new DriveStraightTime(0.2, 0.5));
    	addSequential(new DriveStraightTime(0.15, 0.2));
    	addSequential(new TurnToAngle(1));
    	addSequential(new TurnToAngle(-2));
    	addSequential(new DriveStraightTime(0.5, 0.2));
    	addSequential(new StopDriveTime(0.4));
    	addSequential(new DeployGear());
    	addSequential(new DriveStraightBackwardsTime(0.5, 0.5));
    	addSequential(new ResetGear());
    }
}

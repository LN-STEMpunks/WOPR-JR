package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author cade
 */
public class BaseCommand extends Command {
	
	public BaseCommand(Subsystem... dependencies) {
		for (Subsystem s : dependencies) {
			requires(s);
		}
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
	
}

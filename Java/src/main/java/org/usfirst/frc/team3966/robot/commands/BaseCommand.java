/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3966.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3966.util.Logger;

/**
 *
 * @author cade
 */
public class BaseCommand extends Command {
    
    private Logger command_logger;

    
    public BaseCommand(Subsystem... dependencies) {
        command_logger = new Logger(this.getClass().getSimpleName());
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

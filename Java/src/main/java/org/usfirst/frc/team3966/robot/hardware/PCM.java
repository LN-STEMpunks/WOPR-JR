package org.usfirst.frc.team3966.robot.hardware;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team3966.util.Logger;

/**
 * Creates PCM (baseclass Solenoid)
 * @author cade
 */
public class PCM extends Solenoid {
    
    private Logger pcm_logger;


    public PCM(int node, int portnumber) {
        super(node, portnumber);
        pcm_logger = new Logger(String.format("PCM %d:%d", node, portnumber));
        this.set(false);
    }
    
    public void enable() {
        pcm_logger.info("enabled");
        this.set(true);
    }
    
    public void disable() {
        pcm_logger.info("disabled");
        this.set(false);
    }
    
}

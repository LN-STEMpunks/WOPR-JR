/*
 * L&N STEMpunks c 2017
 *
 * WOPR-JR.
 *
 * Full repo: github.com/ln-stempunks/WOPR-JR
 *
 * Full licensing here: programming.lnstempunks.org/licensing
 *
 * GPLv3
 */
package team3966.robot.pidcontrollers;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class NavXPIDSource implements PIDSource {
	
	private AHRS navx;

	// by default, do distance
	private PIDSourceType sourceType = PIDSourceType.kDisplacement;
	
	public NavXPIDSource(AHRS _navx) {
		navx = _navx;
	}


	public double pidGet() {
		return navx.getYaw();
	}


	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	public void setPIDSourceType(PIDSourceType arg0) {
		sourceType = arg0;
	}
}
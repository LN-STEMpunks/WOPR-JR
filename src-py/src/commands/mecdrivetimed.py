"""

Sets tankdrive lspeed and rspeed for a time in seconds

"""


from wpilib.command import TimedCommand

import subsystems

class MecDriveTimed(TimedCommand):
	def __init__(self, xspeed, yspeed, timeoutInSeconds):
		super().__init__('MecDrivedTime', timeoutInSeconds)

		self.xspeed, self.yspeed = xspeed, yspeed
		self.requires(subsystems.drive)

	def execute(self):
		subsystems.drive.mecanum_cartesian(self.xspeed, -self.yspeed)

	def end(self):
		subsystems.drive.mecanum_cartesian(0, 0, 0)

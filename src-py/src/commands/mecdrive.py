"""

Tank drive, using controllers

"""


from wpilib.command import Command

import subsystems

from values import exbuttons

from math import atan2

class MecDrive(Command):

	def __init__(self):
		super().__init__('MecDrive')

		self.requires(subsystems.drive)


	def execute(self):

		_axis = subsystems.oi.joystick.getAxis

		#subsystems.drive.mecanum_polar(mag, atan2(y, x), r)
		print ('Distance from surface: %f' % (subsystems.sensors.getDistanceIn()))
		subsystems.drive.mecanum_cartesian(_axis(exbuttons.STICK_X_AXIS), _axis(exbuttons.STICK_Y_AXIS), _axis(exbuttons.STICK_ROT))





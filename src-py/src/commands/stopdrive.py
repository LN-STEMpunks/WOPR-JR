
from wpilib.command import Command

import subsystems

class StopDrive(Command):

	def __init__(self):
		super().__init__('StopDrive')

		self.requires(subsystems.drive)


	def execute(self):
		subsystems.drive.tank(0, 0)

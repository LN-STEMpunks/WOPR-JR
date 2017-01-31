"""

Autonomous program

Current goal:

  * Drive forward, strafe left, strafe right, drive back


Problems:


"""
from wpilib.command.commandgroup import CommandGroup

#from commands.tankdrivetimed import TankDriveTimed
from commands.mecdrivetimed import MecDriveTimed

class Autonomous(CommandGroup):

	def __init__(self):
		super().__init__('Autonomous Program')
		pw = .15
		tm = 1.2

		self.addSequential(MecDriveTimed(0, pw, tm))
		self.addSequential(MecDriveTimed(3*-pw, 0, tm))
		self.addSequential(MecDriveTimed(3*pw, 0, tm))
		self.addSequential(MecDriveTimed(0, -pw, tm))
"""

Autonomous program

Current goal:

  * Go in circle
  * Enter other stuff here


Problems:

  * doesn't go in circle
  * something else

"""
from wpilib.command.commandgroup import CommandGroup

from commands.tankdrivetimed import TankDriveTimed

class Autonomous(CommandGroup):

	def __init__(self):
		super().__init__('Autonomous Program')
		pw = .75
		tm = 1
		# circle pattern
		self.addSequential(TankDriveTimed(pw, pw, tm))
		self.addSequential(TankDriveTimed(-pw, pw, tm))
		self.addSequential(TankDriveTimed(pw, pw, tm))
		self.addSequential(TankDriveTimed(-pw, pw, tm))
		self.addSequential(TankDriveTimed(pw, pw, tm))
		self.addSequential(TankDriveTimed(-pw, pw, tm))
		self.addSequential(TankDriveTimed(pw, pw, tm))
		self.addSequential(TankDriveTimed(-pw, pw, tm))

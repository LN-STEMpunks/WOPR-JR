
from wpilib.command.subsystem import Subsystem

from wpilib import RobotDrive

from values import ids

from wpilib.analoginput import AnalogInput
from wpilib.ultrasonic import Ultrasonic

class Sensors(Subsystem):

	def __init__(self):
		super().__init__('Sensors')
		self.ultrasonic0 = Ultrasonic(ids.ULTRASONIC0, ids.ULTRASONIC0)
		#self.ultrasonic0 = AnalogInput(ids.ULTRASONIC0, ids.ULTRASONIC0)
		#self.ultrasonic0.setOversampleBits(4)
		#self.ultrasonic0.setAverageBits(2)

	def getDistanceIn(self):
		return self.ultrasonic0.getRangeInches()
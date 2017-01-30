import wpilib

class DistanceSensor(wpilib.AnalogInput):
	
	def __init__(self, channel):
		super().__init__(channel)
		self.MV_PER_M = 100 * 4.9

	# distance in meters
	def getDistance(self):
		millivolts = self.getVoltage() * 1000.0
		return millivolts / self.MV_PER_M

	

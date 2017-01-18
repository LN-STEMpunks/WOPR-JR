import wpilib

class Motor(wpilib.Talon):
    def __init__(self, channel):
        super().__init__(channel)

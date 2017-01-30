"""

Input and output data

"""

from networktables import NetworkTables

import logging
logging.basicConfig(level=logging.DEBUG)

SD = NetworkTables.getTable("SmartDashboard")

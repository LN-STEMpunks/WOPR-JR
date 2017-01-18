## VexBot python

If this doesn't work, you can find the instructions here: (https://github.com/robotpy/robotpy-wpilib)[https://github.com/robotpy/robotpy-wpilib].

NOTE: our travis config does not test python code, because they use a VERY outdated apt set of packages, and there is not a good way to install pip3. It's very sad, but unfortunately I cannot get it to work.

I had to choose between testing Java and python, and chose Java. Hopefully, I will eventuall support both.

## Getting started

First, run:

`pip3 install pyfrc pynetworktables wpilib`

Or, for downtrodden (non-free) Windows users:

`py -m pip install pyfrc pynetworktables wpilib`

## Deploying

If this is the first time deploying to a robot, or if you aren't sure, follow this quick guide:

(http://robotpy.readthedocs.io/en/stable/install/robot.html#install-robotpy)[http://robotpy.readthedocs.io/en/stable/install/robot.html#install-robotpy]

Now, everytime you run:

`python3 src/robot.py deploy`

Or, for downtrodden Windows users:

`py src/robot.py deploy`

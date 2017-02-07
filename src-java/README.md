# WOPR-JR Java

## Getting started

First, set up your work environment:

### Eclipse

Follow instructions [here](https://wpilib.screenstepslive.com/s/4485/m/13809/l/599681-installing-eclipse-c-java)

Now, open with: `File -> New -> Project`

Now, select `Java Project from Existing Ant Buildfile`

Set the name to `WOPR-JR`, and navigate to this folder (the README.md is) and add the `build.xml` as the Ant buildfile.

You're done!


### NetBeans

First, follow instructions for eclipse, then follow [this](https://netbeans.org/kb/74/java/import-eclipse.html)


## Deploying

After you have set up your environment, you'll want to deploy to a robot.

On all platforms, use:

`ant deploy`

or, to test the build, run:

`ant`

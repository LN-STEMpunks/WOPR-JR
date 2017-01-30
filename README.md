# WOPR-JR

Code for our 2017 Competition robot.

Currently in prototype stage


## Getting Started

Clone the repository:

`git clone https://github.com/LN-STEMpunks/WOPR-JR.git && cd WOPR-JR`

Now, whether you want to work on python, or java, either run `cd src-py` or `cd src-java`.

Now, to see instructions for that language, view the README.md in that subfolder.


## Developing

First, follow [Getting Started](#getting-started), then:

We will push straight to master. But, before you do, make sure the code runs.

You can test these with:

`python3 src/robot.py test` or replace `test` with `sim` to simulate

Or, for downtrodden Windows users:

`py src/robot.py deploy`



`cd src-java && ant deploy`

If these run fine, then run:

`git add $FILES` where `$FILES` are the files you want to commit. (most likely `Python/` or `Java/` and `CHANGELOG.md`)

`git commit -m"MESSAGE HERE"` replacing MESSAGE HERE with whatever message you want to use.

`git push`


## Process

Written by the [L&N STEMpunks](http://lnstempunks.org). More specifically, the [programming team](http://programming.lnstempunks.org).

We use Travis, Git, Java, Python3, and primarily VSCODE and eclipse to develop this.

We also have a python version, which is meant to be equivelant to the java version, but more Pythonic.

Ben Klein wrote most of the base, which was then refactored by Cade Brown.


## Licensing

See [LICENSE.md](./LICENSE.md) for an explanation, or [our full licensing page](lnstempunks.github.io/licensing/).

Essentially, this repo is GPLv3 with some BSD and Apache components.

2017 L&N STEMpunks

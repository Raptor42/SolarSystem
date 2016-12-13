# SolarSystem
To start, use:
	java SolarSystem -h

Included starting data (located in ./Data/):

planets.dat 	The 8 planets, plus the sun
	
fullSystem.dat 	The 8 Planets, the sun, pluto, every moon listed by wikipedia as having enough mass to be sepherical, plus phobos and demios

More data is available in ./Data/HORIZONS - this is the direct output from JPL's HORIZON ephemerides system, so it is not machine readable.

## Description of classes:
See ./JavaDoc/ for a detailed overview.

### PhysicsVector
Provides constructors and a library of methods for working with vectors in a physics context

### Particle
Provides constructors and a library of methods for working with particles in a physics context

### GravField
Provides constructors and a library of methods for working with gravitational fields in a physics context

### SolarSystem
Includes main method.
Program to simulate a solar system for given input data. Uses Euler or Euler-Cramer method. Includes associated methods to complete the task, such as writing to a file.

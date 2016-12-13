/**
 * Purpose: Class to represent a Particle, including various properties such as mass and velocity.
 *
 * @author James Smith
 * @version  1.0
 */

public class Particle {
	private static final double G = 6.67E-11;
	private PhysicsVector position;
	private PhysicsVector velocity;
	private PhysicsVector acceleration;
	private double mass;
	private String name;
	private GravField field;
	private PhysicsVector newPosition;
	private PhysicsVector newVelocity;
	private double momentum;
	private double energy;

	/**
	 * Purpose: Default Constructor. Sets position, velocity, acceleration, mass, name to 0.
	 */
	public Particle() {
		position = new PhysicsVector();
		velocity = new PhysicsVector();
		acceleration = new PhysicsVector();
		mass = 0;
		name = "";
		field = new GravField(position, mass);
		newPosition = new PhysicsVector();
		newVelocity = new PhysicsVector();
		momentum = 0;
		energy = 0;
	}

	/**
	 * Purpose: Constructor. Sets position to a given vector, mass to a given double, and name to a given string.
	 * @param  p Position Vector
	 * @param  m Double to use as mass
	 * @param  n String to use as name
	 */
	public Particle(PhysicsVector p, double m, String n) {
		position = new PhysicsVector(p);
		velocity = new PhysicsVector();
		acceleration = new PhysicsVector();
		mass = m;
		name = n;
		field = new GravField(position, mass);
		newPosition = new PhysicsVector();
		newVelocity = new PhysicsVector();
		momentum = 0;
		energy = 0;
	}

	/**
	 * Purpose: Constructor. Sets position and velocity to given vectors, mass to a given double, and name to a given string.
	 * @param  p Position Vector
	 * @param  v Velocity Vector
	 * @param  m double to use as mass 
	 * @param  n String to use as name
	 */
	public Particle(PhysicsVector p, PhysicsVector v, double m, String n) {
		position = new PhysicsVector(p);
		velocity = new PhysicsVector(v);
		acceleration = new PhysicsVector();
		mass = m;
		name = n;
		field = new GravField(position, mass);
		newPosition = new PhysicsVector();
		newVelocity = new PhysicsVector();
		momentum = 0;
		energy = 0;
	}

	/**
	 * Constructor. Sets position and velocity to given vectors, mass to a given double, and name to a given string.
	 * @param  p Position Vector
	 * @param  v Velocity Vector
	 * @param  a Acceleration vector
	 * @param  m mass double
	 * @param  n name String
	 */
	public Particle(PhysicsVector p, PhysicsVector v, PhysicsVector a, double m, String n) {
		position = new PhysicsVector(p);
		velocity = new PhysicsVector(v);
		acceleration = new PhysicsVector(a);
		mass = m;
		name = n;
		field = new GravField(position, mass);
		newPosition = new PhysicsVector();
		newVelocity = new PhysicsVector();
		momentum = 0;
		energy = 0;
	}

	/**
	 * Purpose: Get a vector representing the particle's position
	 * @return Particle's position vector. 
	 */
	public PhysicsVector getPosition() {
		return position;
	}

	/**
	 * Purpose: Get a particle's x-position
	 * @return Particle's x-position
	 */
	public double getPositionX() {
		return position.getX();
	}

	/**
	 * Purpose: Get a particle's y-position
	 * @return Particle's y-position
	 */
	public double getPositionY() {
		return position.getY();
	}

	/**
	 * Purpose: Get a particle's z-position
	 * @return Particle's z-position
	 */
	public double getPositionZ() {
		return position.getZ();
	}

	/**
	 * Purpose: Get a vector representing the particle's velocity
	 * @return Particle's velocity vector. 
	 */
	public PhysicsVector getVelocity() {
		return velocity;
	}

	/**
	 * Purpose: Get a particle's x-velocity
	 * @return Particle's x-velocity
	 */
	public double getVelocityX() {
		return velocity.getX();
	}

	/**
	 * Purpose: Get a particle's y-velocity
	 * @return Particle's y-velocity
	 */
	public double getVelocityY() {
		return velocity.getY();
	}

	/**
	 * Purpose: Get a particle's z-velocity
	 * @return Particle's z-velocity
	 */
	public double getVelocityZ() {
		return velocity.getZ();
	}

	/**
	 * Purpose: Get a vector representing the particle's acceleration
	 * @return Particle's acceleration vector. 
	 */
	public PhysicsVector getAcceleration() {
		return acceleration;
	}

	/**
	 * Purpose: Get a particle's x-acceleration
	 * @return Particle's x-acceleration
	 */
	public double getAccelerationX() {
		return acceleration.getX();
	}

	/**
	 * Purpose: Get a particle's y-acceleration
	 * @return Particle's y-acceleration
	 */
	public double getAccelerationY() {
		return acceleration.getY();
	}

	/**
	 * Purpose: Get a particle's z-acceleration
	 * @return Particle's z-acceleration
	 */
	public double getAccelerationZ() {
		return acceleration.getZ();
	}

	/**
	 * Purpose: Get a vector representing the particle's newPosition
	 * @return Particle's newPosition vector. 
	 */
	public PhysicsVector getNewPosition() {
		return newPosition;
	}

	/**
	 * Purpose: Get a particle's x-newPosition
	 * @return Particle's x-newPosition
	 */
	public double getNewPositionX() {
		return newPosition.getX();
	}

	/**
	 * Purpose: Get a particle's y-newPosition
	 * @return Particle's y-newPosition
	 */
	public double getNewPositionY() {
		return newPosition.getY();
	}

	/**
	 * Purpose: Get a particle's z-newPosition
	 * @return Particle's z-newPosition
	 */
	public double getNewPositionZ() {
		return newPosition.getZ();
	}

	/**
	 * Purpose: Get a vector representing the particle's newVelocity
	 * @return Particle's newVelocity vector. 
	 */
	public PhysicsVector getNewVelocity() {
		return newVelocity;
	}

	/**
	 * Purpose: Get a particle's x-newVelocity
	 * @return Particle's x-newVelocity
	 */
	public double getNewVelocityX() {
		return newVelocity.getX();
	}

	/**
	 * Purpose: Get a particle's y-newVelocity
	 * @return Particle's y-newVelocity
	 */
	public double getNewVelocityY() {
		return newVelocity.getY();
	}

	/**
	 * Purpose: Get a particle's z-newVelocity
	 * @return Particle's z-newVelocity
	 */
	public double getNewVelocityZ() {
		return newVelocity.getZ();
	}


	/**
	 * Purpose: get a particle's mass
	 * @return Particle's mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Purpose: Get a particle's name
	 * @return Particle's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Purpose: Get the associated field for a particle
	 * @return Particle's field
	 */
	public GravField getField() {
		return field;
	}

	/**
	 * Purpose: Get a particle's momentum
	 * @return Particle's momentum
	 */
	public double getMomentum() {
		return momentum;
	}

	/**
	 * Purpose: Get a particle's energy
	 * @return Particle's Energy
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * Purpose: Set the position vector to 0
	 */
	public void setPosition() {
		position.setVector(0,0,0);
	}

	/**
	 * Purpose: Set the position vector to equal a new vector
	 * @param v Vector to replace current position vector
	 */
	public void setPosition(PhysicsVector v) {
		position.setVector(0,0,0);
		position.setVector(v);
	}

	/**
	 * Purpose: Set the velocity vector to 0
	 */
	public void setVelocity() {
		velocity.setVector(0,0,0);
	}

	/**
	 * Purpose: Set the velocity vector to equal a new vector
	 * @param v Vector to replace current velocity vector
	 */
	public void setVelocity(PhysicsVector v) {
		velocity.setVector(0,0,0);
		velocity.setVector(v);
	}

	/**
	 * Purpose: Set the acceleration vector to 0
	 */
	public void setAcceleration() {
		acceleration.setVector(0,0,0);
	}

	/**
	 * Purpose: Set the acceleration vector to equal a new vector
	 * @param v Vector to replace current acceleration vector
	 */
	public void setAcceleration(PhysicsVector v) {
		acceleration.setVector(0,0,0);
		acceleration.setVector(v);
	}

	/**
	 * Purpose: Set the newPosition vector to 0
	 */
	public void setNewPosition() {
		newPosition.setVector(0,0,0);
	}


	/**
	 * Purpose: Set the newPosition vector to equal a new vector
	 * @param v Vector to replace current newPosition vector
	 */
	public void setNewPosition(PhysicsVector v) {
		newPosition.setVector(0,0,0);
		newPosition.setVector(v);
	}

	/**
	 * Purpose: Set the newVelocity vector to 0
	 */
	public void setNewVelocity() {
		newVelocity.setVector(0,0,0);
	}

	/**
	 * Purpose: Set the newVelocity vector to equal a new vector
	 * @param v Vector to replace current newVelocity vector
	 */
	public void setNewVelocity(PhysicsVector v) {
		newVelocity.setVector(0,0,0);
		newVelocity.setVector(v);
	}

	/**
	 * Purpose: Set the particle's mass to a new value
	 * @param m New mass
	 */
	public void setMass(double m) {
		mass = m;
	}

	/**
	 *  Purpose: Set the particle's name to a new value
	 * @param n New name
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * Purpose: Set the particle's momentum to a new value
	 * @param m New momentum
	 */
	public void setMomentum(double m) {
		momentum = m;
	}

	/**
	 * Purpose: Set the particle's energy to a new value
	 * @param e New Energy
	 */
	public void setEnergy(double e) {
		energy = e;
	}

	/**
	 * Purpose: calculate a particle's momentum
	 * <p>
	 * Use p=mv
	 * @return Particle's current momentum
	 */
	public double calcMomentum() {
		double vel = velocity.magnitude();
		return vel*mass;
	}

	/**
	 * Purpose: Update's a particle's momentum value to the current value
	 */
	public void updateMomentum() {
		this.setMomentum(this.calcMomentum());
	}

	/**
	 * Purpose: Calculate a particles kinetic energy.
	 * <p>
	 * Uses E=(mv^2)/2
	 * @return Particle's Kinetic Energy
	 */
	public double calcKE() {
		double vel = velocity.magnitude();
		double kE = 0.5*mass*vel*vel;
		return kE;
	}

	/**
	 * Purpose: Find the gravitational potential energy of this particle due to a gravitating particle g.
	 * <p>
	 * Uses E = GMm/r
	 * @param  g Gravitating particle.
	 * @return   Gravitational Potential Energy
	 */
	public double calcGPE(Particle g) {
		PhysicsVector gravPos = new PhysicsVector(g.getPosition());
		PhysicsVector targetPos = new PhysicsVector(this.getPosition());
		double gravMass = g.getMass();
		double targetMass = this.getMass();
		PhysicsVector seperation = PhysicsVector.subtract(gravPos, targetPos);
		double sepMag = seperation.magnitude();
		double gPE =  (G*targetMass*gravMass)/sepMag;
		return gPE;
	}


	/**
	 * Purpose: Generate new variables to use for position and velocity using Euler method.
	 * @param t Time step
	 */
	public void newVars(double t) {
		setNewVelocity(PhysicsVector.add(velocity, PhysicsVector.scale(t, acceleration)));
		setNewPosition(PhysicsVector.add(position, PhysicsVector.scale(t, velocity)));
	}

	/**
	 *  Purpose: Generate new variables to use for position and velocity using Euler-Cramer method.
	 * @param t Time step
	 */
	public void newVarsC(double t) {
		setNewVelocity(PhysicsVector.add(velocity, PhysicsVector.scale(t, acceleration)));
		setNewPosition(PhysicsVector.add(position, PhysicsVector.scale(t, newVelocity)));
	}

	/**
	 * Purpose: Replace existing velocity and position with new positions and velocities. Zero newPosition/newVelocity/acceleration.
	 */
	public void updateVars() {
		setVelocity(newVelocity);
		setPosition(newPosition);
		setNewPosition();
		setNewVelocity();
		setAcceleration();
	}
}
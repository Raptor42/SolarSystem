public class Particle {
	private Vector position;
	private Vector velocity;
	private Vector acceleration;
	private GravField field;
	private double mass;
	private Vector newPosition;
	private Vector newVelocity;
	private Vector newAcceleration;
	// private Vector force;
	private static int noParticles = 0;
	private String name;
	private double energy;

	public Particle() {
		position = new Vector();
		velocity = new Vector();
		acceleration = new Vector();
		mass = 0.0;
		field = new GravField(position, mass);
		newPosition = new Vector();
		newVelocity = new Vector();
		newAcceleration = new Vector();
		// force = new Vector();
		noParticles +=1;
		name = "";
		energy = 0;
	}

	public Particle(String n) {
		position = new Vector();
		velocity = new Vector();
		acceleration = new Vector();
		mass = 0.0;
		field = new GravField(position, mass);
		newPosition = new Vector();
		newVelocity = new Vector();
		newAcceleration = new Vector();
		// force = new Vector();
		noParticles +=1;
		name = n;
		energy = 0;
	}

	public Particle(Vector p, double m, String n) {
		position = new Vector(p);
		velocity = new Vector();
		acceleration = new Vector();
		mass = m;
		field = new GravField(position, mass);
		newPosition = new Vector();
		newVelocity = new Vector();
		newAcceleration = new Vector();
		// force = new Vector();
		noParticles +=1;
		name = n;
		energy = 0;
	}

	public Particle(Vector p, Vector v, double m, String n) {
		position = new Vector(p);
		velocity = new Vector(v);
		acceleration = new Vector();
		mass = m;
		field = new GravField(position, mass);
		newPosition = new Vector();
		newVelocity = new Vector();
		newAcceleration = new Vector();
		// force = new Vector();
		noParticles +=1;
		name = n;
		energy = 0;
	}

	public Particle(Vector p, Vector v, Vector a, double m, String n) {
		position = new Vector(p);
		velocity = new Vector(v);
		acceleration = new Vector(a);
		mass = m;
		field = new GravField(position, mass);
		newPosition = new Vector();
		newVelocity = new Vector();
		newAcceleration = new Vector();
		// force = new Vector();
		noParticles +=1;
		name = n;
		energy = 0;
	}

	public void setPosition() {
		position.setVector();
		updateField();
	}

	public void setPosition(double x) {
		position.setVector(x);
		updateField();
	}

	public void setPosition(double x, double y) {
		position.setVector(x, y);
		updateField();
	}

	public void setPosition(double x, double y, double z) {
		position.setVector(x, y, z);
		updateField();
	}

	public void setPosition(double[] p) {
		position.setVector(p);
		updateField();
	}

	public void setPosition(Vector v) {
		position.setVector(v);
		updateField();
	}

	public void setPositionX(double x) {
		position.setX(x);
		updateField();
	} 

	public void setPositionY(double y) {
		position.setY(y);
		updateField();
	}

	public void setPositionZ(double z) {
		position.setZ(z);
		updateField();
	}

	public void setVelocity() {
		velocity.setVector();
	}

	public void setVelocity(double x) {
		velocity.setVector(x);
	}

	public void setVelocity(double x, double y) {
		velocity.setVector(x, y);
	}

	public void setVelocity(double x, double y, double z) {
		velocity.setVector(x, y, z);
	}

	public void setVelocity(double[] p) {
		velocity.setVector(p);
	}

	public void setVelocity(Vector v) {
		velocity.setVector(v);
	}

	public void setVelocityX(double x) {
		velocity.setX(x);
	} 

	public void setVelocityY(double y) {
		velocity.setY(y);
	}

	public void setVelocityZ(double z) {
		velocity.setZ(z);
	}

	public void setAcceleration() {
		acceleration.setVector();
	}

	public void setAcceleration(double x) {
		acceleration.setVector(x);
	}

	public void setAcceleration(double x, double y) {
		acceleration.setVector(x, y);
	}

	public void setAcceleration(double x, double y, double z) {
		acceleration.setVector(x, y, z);
	}

	public void setAcceleration(double[] p) {
		acceleration.setVector(p);
	}

	public void setAcceleration(Vector v) {
		acceleration.setVector(v);
	}

	public void setAccelerationX(double x) {
		acceleration.setX(x);
	} 

	public void setAccelerationY(double y) {
		acceleration.setY(y);
	}

	public void setAccelerationZ(double z) {
		acceleration.setZ(z);
	}

	public void setNewPosition() {
		newPosition.setVector();
	}

	public void setNewPosition(double x) {
		newPosition.setVector(x);
	}

	public void setNewPosition(double x, double y) {
		newPosition.setVector(x, y);
	}

	public void setNewPosition(double x, double y, double z) {
		newPosition.setVector(x, y, z);
	}

	public void setNewPosition(double[] p) {
		newPosition.setVector(p);
	}

	public void setNewPosition(Vector v) {
		newPosition.setVector(v);
	}

	public void setNewPositionX(double x) {
		newPosition.setX(x);
	} 

	public void setNewPositionY(double y) {
		newPosition.setY(y);
	}

	public void setNewPositionZ(double z) {
		newPosition.setZ(z);
	}

	public void setNewVelocity() {
		newVelocity.setVector();
	}

	public void setNewVelocity(double x) {
		newVelocity.setVector(x);
	}

	public void setNewVelocity(double x, double y) {
		newVelocity.setVector(x, y);
	}

	public void setNewVelocity(double x, double y, double z) {
		newVelocity.setVector(x, y, z);
	}

	public void setNewVelocity(double[] p) {
		newVelocity.setVector(p);
	}

	public void setNewVelocity(Vector v) {
		newVelocity.setVector(v);
	}

	public void setNewVelocityX(double x) {
		newVelocity.setX(x);
	} 

	public void setNewVelocityY(double y) {
		newVelocity.setY(y);
	}

	public void setNewVelocityZ(double z) {
		newVelocity.setZ(z);
	}

	public void setNewAcceleration() {
		newAcceleration.setVector();
	}

	public void setNewAcceleration(double x) {
		newAcceleration.setVector(x);
	}

	public void setNewAcceleration(double x, double y) {
		newAcceleration.setVector(x, y);
	}

	public void setNewAcceleration(double x, double y, double z) {
		newAcceleration.setVector(x, y, z);
	}

	public void setNewAcceleration(double[] p) {
		newAcceleration.setVector(p);
	}

	public void setNewAcceleration(Vector v) {
		newAcceleration.setVector(v);
	}

	public void setNewAccelerationX(double x) {
		newAcceleration.setX(x);
	} 

	public void setNewAccelerationY(double y) {
		newAcceleration.setY(y);
	}

	public void setNewAccelerationZ(double z) {
		newAcceleration.setZ(z);
	}

	/*
	public void setForce() {
		force.setVector();
	}

	public void setForce(double x) {
		force.setVector(x);
	}

	public void setForce(double x, double y) {
		force.setVector(x, y);
	}

	public void setForce(double x, double y, double z) {
		force.setVector(x, y, z);
	}

	public void setForce(double[] p) {
		force.setVector(p);
	}

	public void setForce(Vector v) {
		force.setVector(v);
	}

	public void setForceX(double x) {
		force.setX(x);
	} 

	public void setForceY(double y) {
		force.setY(y);
	}

	public void setForceZ(double z) {
		force.setZ(z);
	}
	 */

	public void setMass(double m) {
		this.mass = m;
		updateField();
	}

	public void updateField() {
		field.updateVars(position, mass);
	}

	public Vector getPosition() {
		return this.position;
	}

	public double getPositionX() {
		return this.position.getX();
	}

	public double getPositionY() {
		return this.position.getY();
	}

	public double getPositionZ() {
		return this.position.getZ();
	}

	public Vector getVelocity() {
		return this.velocity;
	}

	public double getVelocityX() {
		return this.velocity.getX();
	}

	public double getVelocityY() {
		return this.velocity.getY();
	}

	public double getVelocityZ() {
		return this.velocity.getZ();
	}

	public Vector getAcceleration() {
		return this.acceleration;
	}

	public double getAccelerationX() {
		return this.acceleration.getX();
	}

	public double getAccelerationY() {
		return this.acceleration.getY();
	}

	public double getAccelerationZ() {
		return this.acceleration.getZ();
	}

	public double getMass() {
		return this.mass;
	}

	/*
	public Vector getForce() {
		return this.force;
	}

	public double getForceX() {
		return this.force.getX();
	}

	public double getForceY() {
		return this.force.getY();
	}

	public double getForceZ() {
		return this.force.getZ();
	}

	public void forceOn(Particle p) {
		// double pMass = p.getMass();
		Vector newForce = new Vector();
		Vector fieldAccel = new Vector(field.computeField(p));
		newForce.setVector(fieldAccel.scalar(p.getMass()));
		Vector pForce = new Vector(p.getForce());
		p.setForce(Vector.add(pForce, newForce));
	}
	 */

	public void accelFrom(Particle p) {
		setAcceleration(acceleration.add(p.field.computeField(this)));
	}

	/*
	public void updateAccel() {
		setAcceleration(force.scalar(1/mass));
	}
	 */

	public void newVars(double t) {
		// updateAccel();
		setNewVelocity(Vector.add(velocity, acceleration.scalar(t)));
		setNewPosition(Vector.add(position, velocity.scalar(t)));
	}

	public void updateVars() {
		setVelocity(newVelocity);
		setPosition(newPosition);
		setAcceleration();
		// setForce();
	}

	public void print() {
		String posString = position.returnSimpleString();
		String velString = velocity.returnSimpleString();
		System.out.println("Position:" + posString);
		System.out.println("Velocity:" + velString);
		System.out.println();
	}

	public static int getNumberOf() {
		return noParticles;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public void setEnergy(double e) {
		energy = e;
	}

	public double getEnergy() {
		return this.energy;
	}

	public void energyFrom(Particle p) {
		Vector seperation = field.getSeperation(p);
		double sepMag = seperation.getMag();
		Vector acceleration = p.field.computeField(this);
		setEnergy(energy + mass*(acceleration.getMag())*sepMag);
	}
}
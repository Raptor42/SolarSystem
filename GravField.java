/**
 * Purpose: Class to represent a gravitational field, including methods to aid in field computation.
 *
 * @author James Smith
 * @version 1.0
 */
public class GravField {
	private PhysicsVector position;
	private double mass;
	public static final double G = 6.67E-11;

	/**
	 * Purpose: Default constructor. Sets position and masss to 0.
	 */
	public GravField() {
		position = new PhysicsVector();
		mass = 0;
	}

	/**
	 * Purpose: Constructor. Sets position and mass to given quantaties.
	 * @param  v Position Vector. 
	 * @param  m Mass variable.
	 */
	public GravField(PhysicsVector v, double m) {
		position = new PhysicsVector(v);
		mass = m;
	}

	/**
	 * Purpose: Constructor. Sets position and mass to those of a given particle.
	 * @param  g Gravitating particle to take variables from.
	 */
	public GravField(Particle g) {
		position = new PhysicsVector(g.getPosition());
		mass = g.getMass();
	}

	/**
	 * Purpose: Set the position and mass to new given quantaties.
	 * @param v New position vector.
	 * @param m New mass variable.
	 */
	public void setField(PhysicsVector v, double m) {
		position.setVector(v);
		mass = m;
	}

	/**
	 * Purpose: Set the position and mass to those  of a given particle.
	 * @param g Gravitating particle to take values from.
	 */
	public void setField(Particle g) {
		PhysicsVector newPosition = new PhysicsVector(g.getPosition());
		double newMass = g.getMass();
		position.setVector(newPosition);
		mass = newMass;
	}

	/**
	 * Purpose: Set the position vector to a new given Vector.
	 * @param v New position vector
	 */
	public void setPosition(PhysicsVector v) {
		position.setVector(v);
	}

	/**
	 * Purpose: Set the mass to a new given mass.
	 * @param m New mass
	 */
	public void setMass(double m) {
		mass = m;
	}

	/**
	 * Purpose: Get acceleration at the position of particle p due to this field.
	 * @param  p Particle to use as test position
	 * @return   Acceleration vector at particle p
	 */
	public PhysicsVector getAccelAt(Particle p) {
		PhysicsVector targetPos = new PhysicsVector(p.getPosition());
		PhysicsVector accel = new PhysicsVector(getAccelAt(targetPos));
		return accel;
	}

	/**
	 * Purpose: Get acceleration due to this field at position p.
	 * <p>
	 * Uses a = (GM/[mod(R-R`)^3])*(R-R`)
	 *          	
	 * @param  p Vector to use as test position
	 * @return   Acceleration vector at position p
	 */
	public PhysicsVector getAccelAt(PhysicsVector p) {
		PhysicsVector accel = new PhysicsVector();
		PhysicsVector targetPos = new PhysicsVector(p);
		PhysicsVector seperation = new PhysicsVector( PhysicsVector.subtract(targetPos, position) );
		double distance = seperation.magnitude();
		double k = -(G*mass)/(distance*distance*distance); // get one quantity to scale the seperation vector by
		accel.setVector( PhysicsVector.scale(k, seperation));
		return accel;
	}

	/**
	 * Purpose: Calculate the acceleration of a target particle due to a gravitating particle.
	 * @param  g Gravitating Particle
	 * @param  t Target Particle
	 * @return   Acceleration vector of t due to g
	 */
	public static PhysicsVector calcAccel(Particle g, Particle t) {
		PhysicsVector accel = new PhysicsVector();
		PhysicsVector targetPos = new PhysicsVector(t.getPosition());
		PhysicsVector gravPos = new PhysicsVector(g.getPosition());
		double gravMass = g.getMass();

		GravField workingField = new GravField(gravPos, gravMass);
		accel = workingField.getAccelAt(targetPos);
		return accel;
	}
}
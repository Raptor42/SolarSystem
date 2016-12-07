public class GravField {
	private static final double G = 6.67408e-11;
	private static final double mE = 5.974e24;
	private static final double rE = 6.380e6;
	private Vector position;
	private double mass;

	public GravField() {
		position = new Vector();
		mass = 0;
	}

	public GravField(Vector v, double m) {
		position = new Vector(v);
		mass = m;
	}

	public GravField(Particle p) {
		position = new Vector(p.getPosition());
		mass = p.getMass();
	}

	public GravField(double[] a, double m) {
		position = new Vector(a);
		mass = m;
	}

	public void updateVars() {
		position.setVector();
		mass = 0;
	}

	public void updateVars(Vector v, double m) {
		position.setVector(v);
		mass = m;
	}
	public void updateVars(Vector v) {
		position.setVector(v);
	}

	public void updateVars(double m) {
		mass = m;
	}

	public void updateVars(double[] a, double m) {
		position.setVector(a);
		mass = m;
	}

	public void updateVars(double[] a) {
		position.setVector(a);
	}

	public void updateVars(Particle p) {
		Vector pos = p.getPosition();
		double m = p.getMass();
		position.setVector(pos);
		mass = m;
	}

	public double getFieldStrength(Particle p) {
		Vector field = computeField(p);
		return field.getMag();
	}

	public Vector computeField(Particle p) {
		Vector field = new Vector();
		double M = mass;
		Vector seperation = getSeperation(p);
		double modSep = seperation.getMag();

		modSep = modSep*modSep*modSep;

		double k = (G*M)/modSep;

		double fieldX = -(k*seperation.getX());
		double fieldY = -(k*seperation.getY());
		double fieldZ = -(k*seperation.getZ());

		field.setX(fieldX);
		field.setY(fieldY);
		field.setZ(fieldZ);

		return field;
	}

	public double getFieldStrength(Vector v) {
		Vector field = computeField(v);
		return field.getMag();
	}

	public Vector computeField(Vector v) {
		Vector field = new Vector();
		double M = mass;
		Vector seperation = getSeperation(v);
		double modSep = seperation.getMag();

		modSep = modSep*modSep*modSep;

		double k = (G*M)/modSep;

		double fieldX = k*seperation.getX();
		double fieldY = k*seperation.getY();
		double fieldZ = k*seperation.getZ();

		field.setX(fieldX);
		field.setY(fieldY);
		field.setZ(fieldZ);

		return field;
	}

	public Vector getSeperation(Particle p) {
		Vector testPoint = p.getPosition();
		return testPoint.subtract(position);
	}

	public Vector getSeperation(Vector v) {
		return v.subtract(position);
	}

	public static Vector getSeperation(Particle p1, Particle p2) {
		return Vector.subtract(p1.getPosition(), p2.getPosition());
	}
}
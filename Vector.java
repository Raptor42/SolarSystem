/**
 * Purpose: Create an object to represent a 3-Dimensional vector, and methods to perform various vector operations
 *
 * @author  James Smith
 * @versiom 1.0
 */

import java.lang.Math;

public class Vector {
	private static final int size = 3;
	private double[] components = new double[size];

	/**
	 * Purpose: Default constructor for Vector. Sets x,y,z=0.
	 */
	public Vector() {
		for (int i=0; i<components.length; i++)
			components[i] = 0;
	}

	/**
	 * Purpose: Constructor for Vector. Sets x=x, y,z=0.
	 * 
	 * @param x Variable for x-component. Must be of type double.
	 */
	public Vector(double x) {
		components[0] = x;
		components[1] = 0;
		components[2] = 0;
	}

	/**
	 * Purpose: Constructor for Vector. Sets x=x, y=y, z=0.
	 * 
	 * @param x Variable for x-component. Must be of type double.
	 * @param y Variable for y-component. Must be of type double.
	 */
	public Vector(double x, double y) {
		components[0] = x;
		components[1] = y;
		components[2] = 0;
	}

	/**
	 * Purpose: Constructor for Vector. Sets x=x, y=y, z=z.
	 * 
	 * @param x Variable for x-component. Must be of type double.
	 * @param y Variable for y-component. Must be of type double.
	 * @param z Variable for z-component. Must be of type double.
	 */
	public Vector(double x, double y, double z) {
		components[0] = x;
		components[1] = y;
		components[2] = z;
	}

	/**
	 * Purpose: Constructor for Vector. Copies components from an existing Vector.
	 * 
	 * @param vector Vector to be copied.
	 */
	public Vector(Vector vector) {
		for (int i=0; i<components.length; i++)
			components[i] = vector.components[i];
	}

	/**
	 * Purpose: Constructor for Vector. Takes x,y,z-components from an array, assuming that order. Extra items ignored. If there is less, the missing items are assumed to be 0.
	 * 
	 * @param array Array to retrive values from. Must be of type double[].
	 */
	public Vector(double[] array) {
		if (array.length <= 3) {
			for (int i=0; i<array.length; i++) 
				components[i] = array[i];

			for (int i=array.length; i<components.length; i++)
				components[i] = 0;
		} else {
			for (int i=0; i<components.length; i++)
				components[i] = array[i];
		}
	}

	/**
	 * Purpose: Returns the Vector formatted as a String in the form "xi + yj + zk ".
	 * 
	 * @return Formatted Vector - type String.
	 */
	public String returnString() {
		String string = "";
		if (components[0] < 0) {
			string += components[0] + "i ";
		} else if (components[0] > 0) {
			string += components[0] + "i " ;
		}

		if (components[1] < 0) {
			string += components[1] + "j ";
		} else if (components[1] > 0) {
			string += "+ " + components[1] + "j " ;
		}

		if (components[2] < 0) {
			string += components[2] + "k ";
		} else if (components[2] > 0) {
			string += "+ " + components[2] + "k " ;
		}

		return string;
	}

	/**
	 * Purpose: Returns the Vector formatted as a String in the form "x y z ".
	 * 
	 * @return Formatted Vector - type String.
	 */
	public String returnSimpleString() {
		String string = "";
		for (int i=0; i<components.length; i++) 
			string += components[i] + " ";

		return string;
	}

	/**
	 * Purpose: Formats Vector using returnString(), then prints to terminal.
	 */
	public void print() {
		String string = this.returnString();
		System.out.println(string);
	}

	/**
	 * Purpose: Sets vector to 0-vector.
	 */
	public void setVector() {
		for (int i=0; i<components.length; i++)
			components[i] = 0;
	}

	/**
	 * Purpose: Sets x=x, y,z=0
	 * 
	 * @param x Variable for x-component. Must be of type double.
	 */
	public void setVector(double x) {
		components[0] = x;
		components[1] = 0;
		components[2] = 0;
	}

	/**
	 * Purpose: Sets x=x, y=y, z=0.
	 * 
	 * @param x Variable for x-component. Must be of type double.
	 * @param y Variable for y-component. Must be of type double.
	 */
	public void setVector(double x, double y) {
		components[0] = x;
		components[1] = y;
		components[2] = 0;
	}

	/**
	 * Purpose: Sets x=x, y=y, z=z.
	 * 
	 * @param x Variable for x-component. Must be of type double.
	 * @param y Variable for y-component. Must be of type double.
	 * @param z Variable for z-component. Must be of type double.
	 */
	public void setVector(double x, double y, double z) {
		components[0] = x;
		components[1] = y;
		components[2] = z;
	}

	/**
	 * Purpose: Sets components to those of another Vector.
	 * 
	 * @param vector Vector to be copied.
	 */
	public void setVector(Vector vector) {
		for (int i=0; i<components.length; i++)
			components[i] = vector.components[i];
	}

	/**
	 * Purpose: Sets components to values copied from an array. Takes x,y,z-components from an array, assuming that order. Extra items ignored. If there is less, the missing items are assumed to be 0.
	 * 
	 * @param array Array to be copied.
	 */
	public void setVector(double[] array) {
		if (array.length <= 3) {
			for (int i=0; i<array.length; i++) 
				components[i] = array[i];

			for (int i=array.length; i<components.length; i++)
				components[i] = 0;
		} else {
			for (int i=0; i<components.length; i++)
				components[i] = array[i];
		}
	}

	/**
	 * Purpose: Sets x=x.
	 *
	 * @param x Variable for x-component. Must be of type double.
	 */
	public void setX(double x) {
		this.setVector(x);
	}

	/**
	 * Purpose: Sets y=y.
	 * 
	 * @param y Variable for y-component. Must be of type double.
	 */
	public void setY(double y) {
		components[1] = y;
	}

	/**
	 * Purpose: Sets z=z.
	 * 
	 * @param z Variable for z-component. Must be of type double.
	 */
	public void setZ(double z) {
		components[2] = z;
	}

    /**
     * Purpose: Retrives x-component.
	 * 
	 * @return x-component. Type: double.
     */
    public double getX() {
		return components[0];
    }

    /**
     * Purpose: Retrives y-component.
	 * 
	 * @return y-component. Type: double.
     */
    public double getY() {
		return components[1];
    }
	
    /**
     * Purpose: Retrives z-component.
	 * 
	 * @return z-component. Type: double.
     */
    public double getZ() {
		return components[2];
    }

    /**
     * Purpose: Adds 2 vectors together.
	 * 
	 * @param u First Vector.
     * @param v Second Vector.
     * @return Summed Vector. Type: Vector.
     */
    public static Vector add(Vector u, Vector v) {
    	Vector add = new Vector();

    	for (int i=0; i<add.components.length; i++)
    		add.components[i] = u.components[i] + v.components[i];
    	
    	return add;
    }

    /**
     * Purpose: Subtracts one Vetor from another.
	 * 
	 * @param u Working Vector.
     * @param v Vector to subtract from u.
     * @return Resultant Vector. Type: VEctor.
     */
    public static Vector subtract(Vector u, Vector v) {
    	Vector subtract = new Vector();

    	for (int i=0; i<subtract.components.length; i++)
    		subtract.components[i] = u.components[i] + v.components[i];
    	
    	return subtract;
    }

    /**
     * Purpose: Scale a vector by a multiplier.
	 * 
	 * @param vector Vector to be scaled
     * @param scalar Multiplier to scale vector by.
     * @return Scaled Vector. Type: Vector
     */
    public static Vector scalar(Vector vector, double scalar) {
    	for (int i=0; i<vector.components.length; i++)
    		vector.components[i] *= scalar;

    	return vector;
    }

    /**
     * Purpose: Find the dot product of two vectors.
	 * 
	 * @param u First Vector.
     * @param v Second Vector.
     * @return Dot product. Type: double.
     */
    public static double dot(Vector u, Vector v) {
    	double dot = 0;

    	if (u.components.length == v.components.length) {
	    	for (int i=0; i<u.components.length; i++) 
	    		dot += u.components[i] * v.components[i];
	    } else {
	    	System.out.println("Error: Vectors are not equal lengths");
	    	System.exit(0);
	    }

	    return dot;
    }

    /**
     * Purpose: Find the cross product of two vectors.
	 * 
	 * @param u First Vector.
     * @param v Second Vector
     * @return The cross product. Type: Vector.
     */
    public static Vector cross(Vector u, Vector v) {
    	Vector cross = new Vector();

    	cross.components[0] = ((u.components[1]*v.components[2]) - (u.components[2]-v.components[1])); 
		cross.components[1] = ((u.components[2]*v.components[0]) - (u.components[0]-v.components[2]));
		cross.components[2] = ((u.components[0]*v.components[1]) - (u.components[1]-v.components[0]));

		return cross;
    }

    /**
     * Purpose: Return the magnitude of a Vector.
	 * 
	 * @param vector The vector of which to find the magnitude.
     * @return The magnitude of vector. Type: Vector.
     */
    public static double mag(Vector vector){
		double mag = dot(vector, vector);
		mag = Math.sqrt(mag);
		return mag;
    }

    /**
     * Purpose: Return the unit vector of a Vector.
	 * 
	 * @param vector The Vector of which to find the unit vector.
     * @return The unit vector of vector. Type: Vector.
     */
    public static Vector unitVector(Vector vector) {
		double mag = 1/vector.getMag();
		Vector unit = vector.scalar(mag);
		return unit;
	}

    /**
     * Purpose: Add a vector to the current Vector instance
	 * 
	 * @param vector Vector to add
     * @return Summed Vector. Type: Vector.
     */
    public Vector add(Vector vector) {
		return add(this, vector);
    }

	/**
	 * Purpose: Subtract a Vector from the current Vector instance.
	 * 
	 * @param vector Vector to subtract.
	 * @return Resultant Vector. Type: Vector.
	 */
	public Vector subtract(Vector vector) {
		return subtract(this, vector);
    }

    /**
     * Purpose: Scale current Vector instance by a given multiplier.
	 * 
	 * @param scalar Multiplier to scale by
     * @return Scaled Vector. Type: Vector
     */
    public Vector scalar(double scalar) {
    	return scalar(this, scalar);
    }

    /**
     * Purpose: Find the dot product of the current Vector instance and another Vector.
	 * 
	 * @param vector Vector to dot with the current instance.
     * @return The dot product. Type: double.
     */
    public double dot(Vector vector) {
    	return dot(this, vector);
    }

    /**
     * Purpose: Find the cross product of the current Vector instance and another Vector.
	 * 
	 * @param vector Vector to cross with the current instance.
     * @return The cross product. Type: Vector.
     */
    public Vector cross(Vector vector) {
    	return cross(this, vector);
    }

	/**
	 * Purpose: Get the magnitude of the current Vector instance.
	 * 
	 * @return The magnitude of the current Vector. Type: double.
	 */
	public double getMag() {
		return mag(this);
	}

	/**
	 * Purpose:	Get the unit vector of the current Vector instance. 
	 * 
	 * @return The unit vector of the current Vector instance. Type: Vector.
	 */
	public Vector getUnit() {
		return unitVector(this);
	}
}
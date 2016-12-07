/**
 * Purpose: Simulate the major bodies in the solar system over given time steps using a Euler method.
 *
 * @author James Smith
 * @version 1.0
 */


import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SolarSystem {
	public static boolean tFlag = false;
	public static boolean fnFlag = false;
	public static String filename = "output.dat";
	public static boolean hFlag = false;
	public static boolean tsFlag = false;
	public static double t;
	public static boolean tfFlag = false;
	public static double timeLimit;
	public static boolean vFlag = false;

	/**
	 * Purpose: Parse command-line arguments for expected arguments, and act appropriately.
	 * <p>
	 * Generally, acting on the arguments means setting a global boolean for that argument to true, so that other methods can act on it. Some arguments such as -h will perform other actions, such as returning a help dialogue or setting a variable.
	 * @param args Array of command-line arguments
	 */
	public static void argsChecker(String[] args) {
		for (int i=0; i<args.length; i++) {
			String arg = args[i];
			if (arg.equals("-t")) {
				System.out.println("Printing results to terminal");
				tFlag = true;
			} else if (arg.equals("-fn")) {
				filename = args[i+1];
				fnFlag = true;
				System.out.println("Output file set to " + filename);
			} else if (arg.equals("-h")) {
				hFlag = true;
				System.out.println("Solar System Help Dialogue");
				System.out.println("--------------------------");
				System.out.println("");
				System.out.println("Usage: java SolarSystem [-args]");
				System.out.println("Example: java SolarSystem -fn results.txt -ts 1e-3 -tf 100");
				System.out.println("");
				System.out.println("Args:");
				System.out.println("-h \t Produces this dialogue");
				System.out.println("-fn \t Next item used as output filename, extension must be included. Defaults to output.dat");
				System.out.println("-t \t Prints results to terminal.");
				System.out.println("-ts \t Next item used as time step. Otherwise, will prompt user. Must be a valid double.");
				System.out.println("-tf \t Next item used as time limit. Otherwise, will prompt user. Must be a valid double.");
				System.out.println("-v \t Prints bulk data to a file");
				System.exit(0);
			} else if (arg.equals("-ts")) {
				tsFlag = true;
				t = Double.parseDouble(args[i+1]);
			} else if (arg.equals("-tf")) {
				tfFlag = true;
				timeLimit = Double.parseDouble(args[i+1]);
			} else if (arg.equals("-v")) {
				vFlag = true;
			}
		}
	}

	/**
	 * Main Method. Purpose: Calculate changes to system based on user inputs, then either write to a file or to command line.
	 * <p>
	 * First, command line arguments are parsed. The data file is then read. The contents are extracted, and used to create an array of particles. If not specified in CL arguments, the time interval and limit is prompted for. The total energy of the sstem is then computed. The acceleration of each body is calculated, and its velocity and position is updated. Care is taken not to include the body itself in these calculations, and to calculate all changes before updating any one body. The results are then either printed to file or terminal.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		argsChecker(args);

		Scanner sc = new Scanner(System.in);
		String[][] data = fileReader("Data/planets.dat");

		Particle[] objects = new Particle[data.length - 1];

		for (int i=1; i<data.length; i++) {
			String name = data[i][0];
			double mass = Double.parseDouble(data[i][1]);
			double xPos = Double.parseDouble(data[i][3])*1000;
			double yPos = Double.parseDouble(data[i][4])*1000;
			double zPos = Double.parseDouble(data[i][5])*1000;
			double xVel = Double.parseDouble(data[i][6])*1000;
			double yVel = Double.parseDouble(data[i][7])*1000;
			double zVel = Double.parseDouble(data[i][8])*1000;

			Vector position = new Vector(xPos, yPos, zPos);
			Vector velocity = new Vector(xVel, yVel, zVel);

			objects[i-1] = new Particle(position, velocity, mass, name);
		}


		if (tsFlag == false) {
			System.out.println("Enter time step: ");
			t = sc.nextDouble();
		}
		
		if (tfFlag == false) {
			System.out.println("Enter time limit: ");
			timeLimit = sc.nextDouble();
		}
		

		double time = 0;

		double totalEnergy = 0;
		double totalEnergy2 = 0;

		String names = "Time \t";

		for (int i=0; i<objects.length; i++) {
			String thisName = objects[i].getName();
			names += thisName + "-X-Pos \t" + thisName + "-Y-Pos \t" + thisName + "-Z-Pos \t" + thisName + "-X-Vel \t" + thisName + "-Y-Vel \t" + thisName + "-Z-Vel \t";

			int k=0;

			for (int j=0; i!=j; j++) {
				objects[i].energyFrom(objects[j]);
				k++;
			}

			k++;

			for (int a=k; a<objects.length; a++) 
				objects[i].energyFrom(objects[a]);

			totalEnergy += objects[i].getEnergy();
		}

		if (vFlag == true) {
			names += System.lineSeparator();

			write(names);
		}
		

		while (time<=timeLimit) {
			for (int i=0; i<objects.length; i++) {
				int k=0;

				for (int j=0; i!=j ; j++) {
					objects[i].accelFrom(objects[j]);
					k ++;
				}

				k++;

				for (int a=k; a<objects.length; a++)
					objects[i].accelFrom(objects[a]);

				objects[i].newVars(t);
			}

			for (int i=0; i<objects.length; i++)
				objects[i].updateVars();

			time += t;

			if (tFlag == true)
				System.out.println("Time: " + time);

			if (vFlag == true) {
				String s = time + "\t";
				for (int i=0; i<objects.length; i++) {
					s += objects[i].getPositionX() + "\t" + objects[i].getPositionY() + "\t" + objects[i].getPositionZ() + "\t" + objects[i].getVelocityX() + "\t" + objects[i].getVelocityY() + "\t" + objects[i].getVelocityZ() + "\t";
				}

				s += System.lineSeparator();



				write(s);
			}
		}

		for (int i=0; i<objects.length; i++) {
			if (tFlag == true) {
				System.out.println("Object: " + objects[i].getName() );
				objects[i].print();	
			}

			int k=0;
			
			for (int j=0; i!=j; j++) {
				objects[i].energyFrom(objects[j]);
				k++;
			}

			k++;

			for (int a=k; a<objects.length; a++) 
				objects[i].energyFrom(objects[a]);

			totalEnergy2 += objects[i].getEnergy();
		}

		double energyDiff = totalEnergy2 -	totalEnergy;

		if (tFlag == true)
			System.out.println("The energy difference is: " + energyDiff);
		if (vFlag == true) {
			write("Energy delta: " + energyDiff + System.lineSeparator());
		}

		if (tFlag == false && vFlag == false) {
			for (int i=0; i<objects.length; i++) {
				write("Object: " + objects[i].getName() + System.lineSeparator());
				write("Position: " + objects[i].getPosition().returnSimpleString() + System.lineSeparator());
				write("Velocity: " + objects[i].getVelocity().returnSimpleString() + System.lineSeparator());
				write(System.lineSeparator());
			}

			write("Time: " + time + System.lineSeparator());
			write("Energy delta: " + energyDiff + System.lineSeparator());
		}
	}

	/**
	 * Purpose: Open and read a given file, and return its contents in a 2-Dimensional array of strings, using whitespace as a delimiter.
	 * 
	 * @param filename Path of file to be read
	 * @return 2D array of contents as strings
	 */
	public static String[][] fileReader(String filename) {
		String[][] contents;
		int fileLength = 0;
		int lineLength = 0;
		int maxLineLength = 0;
		String lineContents = "";
		
		File file = new File(filename);

		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				lineContents = sc.nextLine();
				Scanner sc2 = new Scanner(lineContents);

				while (sc2.hasNext()) {
					lineLength ++;
					String foo = sc2.next();
				}

				if (lineLength>maxLineLength) 
					maxLineLength = lineLength; 
				
				fileLength ++;
				sc2.close();
				lineLength = 0; 
			}

			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
			System.exit(0);
		}

		contents = new String[fileLength][maxLineLength];

		try {
			Scanner sc = new Scanner(file);
			for (int i=0; i<fileLength; i++) {
				for (int j=0; j<maxLineLength; j++)
					contents[i][j] = sc.next();
			}
		} catch(FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
			System.exit(0);
		}

		return contents;	
	}

	/**
	 * Purpose: Append a string to a text file. String filename must be set earlier in the program.
	 * 
	 * @param s String to be written.
	 */
	public static void write(String s) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(filename, true);
			bw = new BufferedWriter(fw);
			bw.write(s);
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
			System.exit(0);
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				System.err.println("IOException: " + ex.getMessage());
				System.exit(0);
			}
		}
	}
}
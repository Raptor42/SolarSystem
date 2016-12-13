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
	// Argument booleans and vars
	public static boolean tFlag = false; // Use terminal flag
	public static boolean fnFlag = false; // Given output path flag
	public static String filename = "Results/output.dat"; // Output Path
	public static boolean hFlag = false; // Use help page flag
	public static boolean tsFlag = false; // Given time interval flag
	public static double t; // Time interval
	public static boolean tfFlag = false; // Given end-time flag
	public static double timeLimit;	// End time
	public static boolean dFlag = false; // Write bulk data
	public static boolean cFlag = false; // Use Euler-Cramer flag
	public static boolean iFlag = false; // Given input path flag
	public static String inputName = "Data/planets.dat"; // Input Path

	/**
	 * Purpose: Parse command-line arguments for expected arguments, and act appropriately.
	 * <p>
	 * Generally, acting on the arguments means setting a global boolean for that argument to true, so that other methods can act on it. Some arguments such as -h will perform other actions, such as returning a help dialogue or setting a variable.
	 * @param args Array of command-line arguments. 
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
				System.out.println("Usage: java SolarSystem -i [input path] -fn [output path] [-args]");
				System.out.println("Example: java SolarSystem -i Data/input.dat -fn Results/results.dat -c -d -ts 1e-3 -tf 100");
				System.out.println("");
				System.out.println("Args:");
				System.out.println("-h \t Produces this dialogue");
				System.out.println("-fn \t Next item used as output filename, extension must be included. Defaults to Results/output.dat");
				System.out.println("-t \t Prints results to terminal.");
				System.out.println("-ts \t Next item used as time step. Otherwise, will prompt user. Must be a valid double.");
				System.out.println("-tf \t Next item used as time limit. Otherwise, will prompt user. Must be a valid double.");
				System.out.println("-d \t Prints bulk data to a file");				
				System.out.println("-c \t Uses Euler-Cramer method. Euler method used otherwise.");
				System.out.println("-i \t Specifies input file as next argument. Defaults to Data/planets.dat");
				System.exit(0);
			} else if (arg.equals("-ts")) { // set time interval
				tsFlag = true;
				t = Double.parseDouble(args[i+1]);
			} else if (arg.equals("-tf")) { // set end time
				tfFlag = true;
				timeLimit = Double.parseDouble(args[i+1]);
			} else if (arg.equals("-d")) { // big data output
				dFlag = true;
			} else if (arg.equals("-c")) { // use euler-cramer
				cFlag = true;
			} else if (arg.equals("-i")) { // set input file
				iFlag = true;
				inputName = args[i+1];
			}
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

		// Finding the dimensions of the 2D array
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				lineContents = sc.nextLine();
				Scanner sc2 = new Scanner(lineContents);

				while (sc2.hasNext()) { // find how long this line is
					lineLength ++;
					String foo = sc2.next();
				}

				if (lineLength>maxLineLength) // if it's the longest yet, update the max line length
					maxLineLength = lineLength; 
				
				fileLength ++; // increment the file length counter
				sc2.close();
				lineLength = 0; 
			}

			sc.close();
		} catch (FileNotFoundException e) { // catch exceptions
			System.err.println("FileNotFoundException: " + e.getMessage());
			System.exit(0);
		}

		// create 2D array for the file size
		contents = new String[fileLength][maxLineLength];

		// Fill array with data
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

		// return array
		return contents;	
	}

	/**
	 * Purpose: Append a string to a text file. String filename must be set earlier in the program.
	 * <p>
	 * Adapted from https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
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

	/**
	 * Purpose: Main method. First, processes command line arguments (CLA). Then, gets input data from file and creates an array of particles, one for each object. Any missing program parameters are prompted for, and an output file is prepared. The acceleration calculation for the current time step is executed, and the new positions and velocities found for each particle. This is written to file, and then the process begins for the next time step, looping until the end time is reached. The change in system momentum and energy is then found, and appended to the file. Finally, the program execution time is recorded.	
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis(); // Time at program start

		argsChecker(args); // Process Arguments

		///////////////////////////////////////
		// Getting data and creating objects //
		///////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		String[][] data = fileReader(inputName); // Get input file's contents as an array

		Particle[] objects = new Particle[data.length - 1]; // make my particle array

		for (int i=1; i<data.length; i++) { // fill array with data
			String name = data[i][0]; 
			double mass = Double.parseDouble(data[i][1]);
			double xPos = Double.parseDouble(data[i][3])*1000; // data in km and km/s - need m and m/s
			double yPos = Double.parseDouble(data[i][4])*1000;
			double zPos = Double.parseDouble(data[i][5])*1000;
			double xVel = Double.parseDouble(data[i][6])*1000;
			double yVel = Double.parseDouble(data[i][7])*1000;
			double zVel = Double.parseDouble(data[i][8])*1000;

			PhysicsVector position = new PhysicsVector(xPos, yPos, zPos);
			PhysicsVector velocity = new PhysicsVector(xVel, yVel, zVel);

			objects[i-1] = new Particle(position, velocity, mass, name);
		}

		//////////////////////////////////
		// Getting experiment variables //
		//////////////////////////////////

		if (tsFlag == false) { // if no interval is specified, prompt for one
			System.out.println("Enter time step: ");
			t = sc.nextDouble();
		}
		
		if (tfFlag == false) { // if no end time is specified, prompt for one
			System.out.println("Enter time limit: ");
			timeLimit = sc.nextDouble();
		}

		////////////////////////////////////////////////////////////////
		// Preparing and writing human-readable content for data file //
		////////////////////////////////////////////////////////////////

		String names = "Time \t"; // make file header

		for (int i=0; i<objects.length; i++) {
			// make file header
			String thisName = objects[i].getName(); // more efficient to call once and store as String
			names += thisName + "-X-Pos \t" + thisName + "-Y-Pos \t"; 

		}

		if (dFlag == true) { // if bulk data mode is on
			names += System.lineSeparator(); 
			write(names); // write header to file
		}

		//////////////////////////
		// Calculating Momentum //
		//////////////////////////
		
		double momentum1 = 0;

		for (int i=0; i<objects.length; i++) {
				objects[i].updateMomentum();
				momentum1 += objects[i].getMomentum();
		}

		
		////////////////////////
		// Calculaing Energy  //
		////////////////////////
		
		double totalEnergy = 0;

		for (int i=0; i<objects.length; i++) {
			double thisEnergy = objects[i].getEnergy();

			thisEnergy += objects[i].calcKE();

			for (int j=0; j<objects.length; j++) {
				if (i!=j) 
					thisEnergy += objects[i].calcGPE(objects[j]);
			}

			totalEnergy += thisEnergy;
			objects[i].setEnergy(0);
		}

		double time = 0;

		String s = "";
		while (time<=timeLimit) { // while time limit has not been reached

			//////////////////////////////////////////////////////////
			// Finding and computing acceleration and new variables //
			//////////////////////////////////////////////////////////

			for (int i=0; i<objects.length; i++) { // for each object, update its acceleration from each other object, ignoring i=j
				for (int j=0; j<objects.length; j++) {
					if (i != j) { // ignore case where i=j
						GravField grav = new GravField(objects[j]); // get the gravitational field for some planet j
						PhysicsVector a = new PhysicsVector(grav.getAccelAt(objects[i])); // find the acceleration of i due to j's field
						objects[i].setAcceleration( PhysicsVector.add(objects[i].getAcceleration(), a) ); // asdd to it's current acceleration
					}
				}
				
				// calculate new variables
				if (cFlag == true) {
					// System.out.println("Using Euler-Cramer");
					objects[i].newVarsC(t); // Use Euler-Cramer to find x,v_(n+1)
				}
				else {
					// System.out.println("Using Euler");
					objects[i].newVars(t); // Default to Euler to find x,v_(n+1)
				}
			}
			
			// apply new variables after the change for all objects has been calculated
			for (int i=0; i<objects.length; i++)
				objects[i].updateVars(); 
			
			time += t;

			///////////////////////////////////////
			// Prepping and writing data to file //
			///////////////////////////////////////

			if (tFlag == true) // if terminal mode is on
				System.out.println("Time: " + time); // print current time to terminal output

			if (dFlag == true) { // if bulk data mode is on
				s += time + "\t"; // add time to print string
				for (int i=0; i<objects.length; i++) { // for each object
					s += objects[i].getPositionX() + "\t" + objects[i].getPositionY() + "\t"; // add its x and y position to the print string   /*+  objects[i].getPositionZ() + "\t" + objects[i].getVelocityX() + "\t" + objects[i].getVelocityY() + "\t" + objects[i].getVelocityZ() + "\t" */;
				}

				s += System.lineSeparator(); // move to new line	
			}
		}
		if (dFlag == true) // if bulk data mode is on
			write(s); // write out print string		

		//////////////////////////
		// Calculating Momentum //
		//////////////////////////
		
		double momentum2 = 0;

		for (int i=0; i<objects.length; i++) {
				objects[i].updateMomentum();
				momentum2 += objects[i].getMomentum();
		}

		double momentumDiff = momentum2 - momentum1;
		write("Momentum delta: " + String.valueOf(momentumDiff) + System.lineSeparator());

		////////////////////////
		// Calculaing Energy  //
		////////////////////////
		
		double totalEnergy2 = 0;

		for (int i=0; i<objects.length; i++) {
			double thisEnergy = objects[i].getEnergy();

			thisEnergy += objects[i].calcKE();

			for (int j=0; j<objects.length; j++) {
				if (i!=j) 
					thisEnergy += objects[i].calcGPE(objects[j]);
			}
			
			totalEnergy2 += thisEnergy;
			objects[i].setEnergy(0);
		}

		double energyDiff = totalEnergy2 - totalEnergy;
		write("Energy delta: " + String.valueOf(energyDiff) + System.lineSeparator());

		//////////////////////////////
		// Finding program run time //
		//////////////////////////////
		
		long t2 = System.currentTimeMillis() - t1;
		write("Execution time: " + String.valueOf(t2) + System.lineSeparator());

	}
}
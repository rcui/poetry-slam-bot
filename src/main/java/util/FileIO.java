package util;

import java.io.*;

public class FileIO {

	public static String readInput(File in) {
		String s = null;
		String line = null;
		try {
			FileReader fileReader = new FileReader(in);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("[^a-zA-Z0-9\\s$]", "");
				line = line.toLowerCase();
				s = s + line + "\n";
			}

			bufferedReader.close();
		} catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							in + "'");                
		} catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ in + "'");   
		}
		return s;
	}

	public static void writeOutput(File out, String s) {
		try {
			FileWriter fileWriter = new FileWriter(out);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(s);

			bufferedWriter.close();
		} catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							out + "'");                
		} catch(IOException ex) {
			System.out.println(
					"Error writing file '" 
							+ out + "'");   
		}
	}

}

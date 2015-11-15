package main;

import java.io.*;
import java.util.Scanner;

import util.*;

public class PoetrySlamBot {

	public static void main(String[] args) {

		File in = null;
		File out = null;
		File f = new File("src/main/resources/words.txt");

		if (args.length == 2) {
			in = new File(args[0]);
			out = new File(args[1]);
		} else {
			System.out.println("PoetrySlamBot takes 2 arguments: an input file and an output file");
			return;
		}

		try {
			FileReader fileReader = new FileReader(in);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter(out);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			String line = null;
			int lineNum = 1;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim().replaceAll("[^a-zA-Z0-9\\s]", "");
				line = line.toLowerCase();
				if (line.equals("")) {
					bufferedWriter.write("\n");
					System.out.println(lineNum);
				}
				else {
					String s = MakeString.makeString(line, f);
					bufferedWriter.write(s + "\n");
					System.out.println(lineNum + " " + s);
				}
				lineNum++;
			}
			bufferedWriter.close();
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
	}
}

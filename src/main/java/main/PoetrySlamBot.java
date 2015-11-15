package main;

import java.io.*;
import java.util.Scanner;

import util.*;

public class PoetrySlamBot {

	public static void main(String[] args) {

		//		Scanner kb = new Scanner(System.in);
		//		System.out.print("Enter a line: ");
		//		
		//		String line = kb.nextLine();
		
		File in = null;
		File f = new File("src/main/resources/words.txt");

		if (args.length > 0) {
			in = new File(args[0]);
		} else {
			System.out.println("PoetrySlamBot needs an input file, ya doofus!");
			return;
		}

		try {
			FileReader fileReader = new FileReader(in);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			int lineNum = 1;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim().replaceAll("[^a-zA-Z0-9\\s]", "");
				line = line.toLowerCase();
				if (line.equals("")) System.out.println(lineNum);
				else System.out.println(lineNum + " " + MakeString.makeString(line, f));
				lineNum++;
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

//				String line = "my my all all"; //"The quick brown fox jumped over the pig.";
//				
//				String out = MakeString.makeString(line, f);
//				System.out.println(out);
	}
}

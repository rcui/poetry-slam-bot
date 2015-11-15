package main;

import java.io.*;
import java.util.*;

import util.*;
import words.*;

public class MakeWords {

	private static String makeWordList(String s) {
		WordList list = new WordList();

		String[] words = Parse.tagArray(s);
		for (int i = 0; i < words.length; i++) {
			list.addWord(words[i]);
		}
		String str = list.toString();
		String[] sort = str.split("\\r?\\n");
		String ret = "";
		List<String> rowList = new ArrayList<String>(Arrays.asList(sort));
		Collections.sort(rowList, new CompareLines());
		for (String string : rowList) {
		     ret = ret + string + "\n";
		}   
		
		return ret;
	}

	public static void main(String[] args) {
		File in = null;
		File out = null;
		if (args.length == 2) {
			in = new File(args[0]);
			out = new File(args[1]);
		} else {
			System.out.println("MakeWords takes 2 arguments: an input file and an output file");
			return;
		}

		String s = FileIO.readInput(in);
		String list = makeWordList(s);

		FileIO.writeOutput(out, list);
	}


}


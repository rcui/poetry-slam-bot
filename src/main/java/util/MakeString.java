package util;

import java.io.File;

public class MakeString {
	
	private static String[] words;
	
	private static String generateWord(String tag) {
		
		String[][] WordList = new String[words.length][1];
		
		for (int i = 0; i < words.length; i++) {
			String[] line = words[i].split("\\s+");
			WordList[i] = line;
		}
		
		WeightedList<String> gen = new WeightedList<String>();
		for (int i = 0; i < words.length; i++) {
			if (WordList[i][1].equals(tag)) gen.add(Double.parseDouble(WordList[i][2]), WordList[i][0]);
		}
		return gen.next();
	}
	
	public static String makeString(String s, File f) {
		
		String[] in = Parse.tagArray(s);
		String read = FileIO.readInput(f);
		words = read.split("\\n");
		String ret = "";
		for (int i = 0; i < in.length; i++) {
			String[] tags = in[i].split("_");
			if (tags[1].equals("PDT")) tags[1] = "DT";
//			System.out.println(tags[0] + " " + tags[1]);
			ret = ret + generateWord(tags[1].toLowerCase()) + " ";
		}
		ret = ret.substring(0, 1).toUpperCase() + ret.substring(1);
		return ret;
	}
}

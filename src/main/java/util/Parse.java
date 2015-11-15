package util;

import java.io.*;

import opennlp.tools.postag.*;

public class Parse {
	
	public static String[] tagArray(String s) {
		
		InputStream modelIn = null;
		String[] in = s.split("\\s+");
		String[] ret = new String[in.length];
		
		try {
		  modelIn = new FileInputStream("src/main/resources/en-pos-maxent.bin");
		  POSModel model = new POSModel(modelIn);
		  POSTaggerME tagger = new POSTaggerME(model);
		  
		  String[] tags = tagger.tag(in);
		  
		  for (int i = 0; i < ret.length; i++) {
			  ret[i] = in[i] + "_" + tags[i];
		  }
		}
		catch (IOException e) {
		  // Model loading failed, handle the error
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		return ret;
	}

	public static String tagString(String s) {

		InputStream modelIn = null;
		String ret = "";
		
		try {
		  modelIn = new FileInputStream("src/main/resources/en-pos-maxent.bin");
		  POSModel model = new POSModel(modelIn);
		  POSTaggerME tagger = new POSTaggerME(model);
		  
		  String[] in = s.split("\\s+");
		  String[] tags = tagger.tag(in);
		  
		  for (int i = 0; i < tags.length; i++) {
			  ret = ret + in[i] + "_" + tags[i] + " ";
		  }
		}
		catch (IOException e) {
		  // Model loading failed, handle the error
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		return ret;
	}
	
	public static String untagString(String s) {
		
		String[] tags = s.split("\\s+");
		String ret = "";
		
		for (int i = 0; i < tags.length; i++) {
			String[] base = tags[i].split("_");
			ret = ret + base[0] + " ";
		}
		
		return ret;
	}
	
//	public static void main(String[] args) {
//		String testTag = "Pierre Vinken , 61 years old , will join the board as a nonexecutive director Nov. 29 . Mr. Vinken is chairman of Elsevier N.V. , the Dutch publishing group ";
//		String testUntag = "Pierre_NNP Vinken_NNP ,_, 61_CD years_NNS old_JJ ,_, will_MD join_VB the_DT board_NN as_IN \na_DT nonexecutive_JJ director_NN Nov._NNP 29_CD ._.\nMr._NNP Vinken_NNP is_VBZ chairman_NN of_IN Elsevier_NNP N.V._NNP ,_, the_DT Dutch_NNP publishing_VBG group_NN";
//		//System.out.println(untag(tag(testTag)));
//	}
}

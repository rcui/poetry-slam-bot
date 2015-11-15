package util;
import java.util.Comparator;

public class CompareLines implements Comparator<String> {
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		String[] a1 = o1.split(" ");
		String[] a2 = o2.split(" ");

		int i = a1[1].compareTo(a2[1]);
		if (i != 0) return i;
		return Integer.compare(Integer.parseInt(a1[2]), Integer.parseInt(a2[2]));
	}
}
package words;

public class Word implements Comparable<Word>{
	
	private int freq;
	private String word;
	private String tag;
	
	private Word next;
	
	public Word(String word, int freq, String tag) {
		this.freq = freq;
		this.word = word;
		this.tag = tag;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getFreq() {
		return freq;
	}
	
	public String getTag() {
		return tag;
	}
	
	public Word getNext() {
		return next;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public void setNext(Word next) {
		this.next = next;
	}
	
	public String toString() {
		return word + " " + tag + " " + freq + "\n";
	}

	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		return this.tag.compareTo(o.tag);
	}
}

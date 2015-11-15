package words;

public class WordList {

	private Word head;
	private Word tail;
	
	public Word addWord(String in) {
		String[] tag = in.split("_");
		if (head == null) {
			Word word = new Word(tag[0], 1, tag[1]);
			head = word;
			tail = word;
		} else {
			Word word = find(tag[0]);
			if (word != null) {
				word.setFreq(word.getFreq() + 1);
			} else {
				tail.setNext(new Word(tag[0], 1, tag[1]));
				tail = tail.getNext();
			}
		}
		return tail;
	}
	
	public Word find(String word) {
		Word ret = head;
		while (ret != null) {
			if (ret.getWord().equals(word)) return ret;
			ret = ret.getNext();
		}
		return null;
	}
	
	public String toString() {
		String ret = "";
		Word w = head;
		while (w != null) {
			ret = ret + w.toString();
			w = w.getNext();
		}
		return ret;
	}
}

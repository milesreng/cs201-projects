/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author YOUR NAME HERE
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;

		for (int i = 0; i < size; i++) {
			myWords[i] = source[i + start];
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param other
	 * @return
	 */
	@Override
	public boolean equals(Object other) {
		if (! (other instanceof WordGram) || other == null){
			return false;
		}
		
		WordGram wg = (WordGram) other;
		if (this.length() != wg.length()) {
			return false;
		}
		
		for (int i = 0; i < this.myWords.length; i++) {
			if (!wg.myWords[i].equals(this.myWords[i])) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode(){
		if (myHash == 0) {
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		String[] newWords = new String[this.length()];
		for (int i = 0; i < this.length(); i++) {
			if (i == this.length() - 1) {
				newWords[i] = last;
			} else {
				newWords[i] = this.myWords[i + 1];
			}
		}
		WordGram ws = new WordGram(newWords, 0, newWords.length);
		return ws;
	}

	@Override
	public String toString(){
		if (myToString == null) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}

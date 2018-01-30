import java.util.ArrayList;

public class Dict {

	/**
	 * Searches through the dictionary ArrayList and compares the words within correctVariations to
	 * each instance within
	 * 
	 * @param dictionaryWords
	 * @param word
	 * @param prefix
	 * @param min
	 * @param max
	 * 
	 * recursive method, returns own method
	 */
	
	public int binarySearch(ArrayList<String> dictionaryWords, String word, String prefix, int min, int max) {
		// base case
		if (min > max) {
			return -1;
		}
		// split the list in two
		else {
			int mid = (max + min) / 2;
			// make an instance where the two words are equal
			if(dictionaryWords.get(mid).length() == word.length() && dictionaryWords.get(mid).startsWith(prefix) 
					&& dictionaryWords.get(mid).equals(word)){
					return 1;
				}
			else if (dictionaryWords.get(mid).compareTo(word) > 0) {
				return binarySearch(dictionaryWords, word, prefix, min, mid - 1);
			}
			else {
				return binarySearch(dictionaryWords, word, prefix, mid + 1, max);
			}
		}
	}
}

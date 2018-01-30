import java.util.ArrayList;
import java.util.Collections;

public class WordGenerator {
	
	// initialize an ArrayList of the correct variations
	public ArrayList<String> correctVariations = new ArrayList<String>();
	
	/**
	 * creates a permutation method, pass through beginning and end variables
	 * create a variable that allows the creation of an ArrayList
	 * @param start
	 * @param end
	 * @param variations
	 */
	private void permutation(String start, String end, ArrayList<String> variations) {
		
		// initialize j, the beginning variable
		int j = end.length();
			// base case, use beginning letter
			if(j == 0)
				variations.add(start);
			else
				// loop through length of input
				for(int i = 0; i < j; i++)
					 // using first letter, create other groups
					permutation(start + end.charAt(i), end.substring(0, i) + end.substring(i+1, j), variations);
	}
	
	/**
	 * creates a recursive, accessible method from FindWords
	 * @param end
	 * @param listOfLetters
	 */
	public void permutations(String end, ArrayList<String> listOfLetters) {
		permutation("", end, listOfLetters);
	}
	
	/**
	 * removes the duplicates from the list
	 * @param listOfLetters
	 * returns sorted list of correctVariations
	 */
	public void removeDuplicates(ArrayList<String> listOfLetters) {
		// loop through list
		for(int i = 0; i < listOfLetters.size(); i++)
			// start adding new variations to correctVariations
			if(correctVariations.contains(listOfLetters.get(i)) == false)
				// add it to the new, blank list if it's not
				correctVariations.add(listOfLetters.get(i));
		Collections.sort(correctVariations.subList(0, correctVariations.size()));
	}
		
}

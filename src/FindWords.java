import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

	/**
	 * @user Demi Frechette
	 * @param input from user, driver, output
	 * @return list of words from file using letters from user in which a variation matches an instance within dictionary file
	 */

public class FindWords {
	
	
	public static void main(String[] args) {

		// initialize variables accessed across classes
		String letters;
		String prefix;
		ArrayList<String> lettersList = new ArrayList<String>();
		ArrayList<String> dictionaryWords = new ArrayList<String>();
		ArrayList<String> actualFinalWords = new ArrayList<String>();
		
		
		// prompt input from the user
		System.out.println("Enter from 2 to 10 random letters, not including numbers, symbols, or capital letters: ");

		// take in input
		Scanner input = new Scanner(System.in);
		letters = input.next();
		// check to make sure input is only letters and its size is less than 10
	    char[] chars = letters.toCharArray();
	    for (char c : chars)
	    	if(!Character.isLetter(c) || letters.length() > 10) {
	    	    System.out.println("The input is supposed to be a length of 2-10 lower case characters."); 
	    		System.exit(0);
	    	}
	    
	    // take in dictionary file
		try {
			// open up the file, store it in an arrayList
			Scanner scan = new Scanner(new File(args[0]));
			while(scan.hasNext())
				dictionaryWords.add(scan.nextLine());
			scan.close();
		
		// if file is not able to be opened or found, error printed out
		}catch(FileNotFoundException e) {
			System.out.println("This file was not found or could not be opened.");
			System.exit(0);
		}
		
		// create instances of classes in order to access methods
		WordGenerator a = new WordGenerator();
		Dict b = new Dict();
		a.permutations(letters, lettersList);
		a.removeDuplicates(lettersList);
		Collections.sort(a.correctVariations);

		// loop correct variations through dictionary file
		for(int i = 0; i < a.correctVariations.size(); i++) {
			// if length of word is long, use a longer prefix
			if(a.correctVariations.get(i).length() >= 4)
				prefix = a.correctVariations.get(i).substring(0, 3);
			else if(a.correctVariations.get(i).length() < 4 && a.correctVariations.get(i).length() != 1)
				prefix = a.correctVariations.get(i).substring(0, 1);
			else
				prefix = a.correctVariations.get(i).substring(0);
			// loop through with binary search
			if(b.binarySearch(dictionaryWords, a.correctVariations.get(i), prefix, 0, dictionaryWords.size() - 1) == 1)
				actualFinalWords.add(a.correctVariations.get(i));
		}
		
		// print out the final words that match the dictionary file
		System.out.println("These are the words that match the dictionary file from your input:");
		for(int i = 0; i < actualFinalWords.size(); i++) {
			System.out.println(actualFinalWords.get(i));
		}
	}
}

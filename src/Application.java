import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Example application for dictionary implementation
 * @author Will Brown
 * @version 1.0
 * Fall 2021
 */
public class Application {

	/**
	 * Load half the dictionary CSV unsorted, print it, sort it,
	 * and load the next half of the file, sorted.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Dictionary myDictionary = new Dictionary();
		Scanner dictionaryFileScanner = null;
		
		try {
			/* This file is hardcoded. No other textfile will work with this program,
			 * unless it is also 436 lines. */
			dictionaryFileScanner = new Scanner(new File("DictionaryWordValuePairs.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the test file.");
			System.exit(1);
		}
		
		// Add first half of dictionary file (unsorted)
		for (int lineIndex = 0; lineIndex < 218; lineIndex++) {
			String[] entry = dictionaryFileScanner.nextLine().split("\",\"");
			entry[0] = entry[0].substring(1, entry[0].length());
			entry[1] = entry[1].substring(0, entry[1].length() - 1);
			myDictionary.addUnsorted(entry[0], entry[1]);
		}
		
		System.out.println("First half of dictionary (unsorted):");
		System.out.println(myDictionary.toString());
		
		myDictionary.sort();
		
		// Add second half of dictionary file (sorted)
		for (int lineIndex = 0; lineIndex < 218; lineIndex++) {
			String[] entry = dictionaryFileScanner.nextLine().split("\",\"");
			entry[0] = entry[0].substring(1, entry[0].length());
			entry[1] = entry[1].substring(0, entry[1].length() - 1);
			myDictionary.add(entry[0], entry[1]);
		}
		
		// the duplicate entry of 'portion' will be removed, so the result is 435 lines.
		System.out.println("Complete dictionary (sorted):");
		System.out.println(myDictionary.toString());
		
	}

}

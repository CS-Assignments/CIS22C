
/**
 * CardApp.java
 * @author Akhil Sukhthankar
 * @author Jasmine Chahal
 * CIS 22C, Lab 3
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
//import java.util.Scanner;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Scanner;

public class CardApp {

	private static final List<Card> L = new List<>();

	public static void main(String[] args) {
		System.out.println("Welcome!");
		readFile();
		shuffle();
		writeFile("shuffled.txt");
		sort();
		writeFile("sorted.txt");
		System.out.println("Please open shuffled.txt and sorted.txt.\nGoodbye!");
		return;
	}

	public static void swap(int a, int b) throws NoSuchElementException {
		if (a > b) { // make sure that a comes before b, if not swap them
			int temp = a;
			a = b;
			b = temp;
		} else if (a == b) { // if a and b are the same, then no need to swap
			return;
		}
		if (b >= L.getLength()) {// if an index is out of bounds, throw exception
			throw new NoSuchElementException("swap(), index to be swapped is greater than length of list");
		}

		Card dataA = null, dataB = null;

		// Get the values from nodes at index a
		L.placeIterator();
		int i = 0;
		while (i++ != a) {
			L.advanceIterator();
		}
		dataA = L.getIterator();

		// Get the values from nodes at index b
		do {
			L.advanceIterator();
		} while (i++ != b);
		dataB = L.getIterator();

		// reset the iterator to first
		L.placeIterator();
		i = 0;
		while (i++ != a) {
			L.advanceIterator();
		}

		// add card b into node thats replacing card a
		L.addIterator(dataB);
		L.reverseIterator();
		L.removeIterator();

		// reset the iterator to first again
		L.placeIterator();
		i = 0;
		while (i++ != b) {
			L.advanceIterator();
		}
		;

		// add card a into node thats replacing card b
		L.addIterator(dataA);
		L.reverseIterator();
		L.removeIterator();
	}

	/**
	 * Shuffles cards following this algorithm: First swaps first and last card
	 * Next, swaps every even card with the card 3 nodes away from that card. Stops
	 * when it reaches the 3rd to last card Then, swaps ALL cards with the card that
	 * is 3 cards away from it, beginning at second card, and stopping at the 3rd to
	 * last card
	 */
	public static void shuffle() {
		// Swap first and last
		swap(0, L.getLength() - 1);

		// swap cards at even index with card 3 nodes away until 3rd to last card
		for (int i = 1; i < L.getLength() - 3; i += 2) {
			swap(i, i + 3);
		}

		// swap all cards with card 3 nodes away until 3rd to last card
		for (int i = 1; i < L.getLength() - 3; i++) {
			swap(i, i + 3);
		}
		return;
	}

	/**
	 * Implements the bubble sort algorithm to sort L into sorted order, first by
	 * suit (alphabetical order) then by rank from 2 to A
	 */
	public static void sort() {
		for (int i = 0; i <= (L.getLength() - 2); i++) {
			L.placeIterator();
			Card prevCard = L.getIterator();
			for (int j = 0; j <= (L.getLength() - i - 2); j++) {
				L.advanceIterator();
				if (prevCard.compareTo(L.getIterator()) > 0) {
					swap(j, j + 1);
					// bring iterator back to the position if it was set to null in some case (all
					// cases)
					if (L.offEnd()) {
						L.placeIterator();
						for (int k = 0; k <= j; k++) {
							L.advanceIterator();
						}
					}
				}
				prevCard = L.getIterator();
			}
		}
		return;
	}

	/**** ADDITIONAL FUNCTIONS ****/
	/**
	 * Gets user input and reads the text file
	 * 
	 * @precondition ArrayList type is of List type
	 */
	private static void readFile() {
		Boolean foundFile = false;
		Scanner sc = new Scanner(System.in);

		while (!foundFile) {
			System.out.print("\nPlease enter a file name: ");
			String userTextFileName = sc.nextLine();
			File myObj = new File(userTextFileName);

			try {
				Scanner fileReader = new Scanner(myObj);
				while (fileReader.hasNextLine()) {
					String data = fileReader.nextLine();
					String rank = data.substring(0, data.length() - 1);
					String suit = String.valueOf(data.charAt(data.length() - 1));
					Card newCard = new Card(rank, suit);
					L.addLast(newCard);
				}

				foundFile = true;
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Invalid file name!");
			}
		}
		sc.close();
	}

	public static void writeFile(String fileName) {
		try {
			// passing false so it overwrites initial text file with same name
			FileWriter writer = new FileWriter(fileName, false);
			L.placeIterator();
			for (int i = 0; i < L.getLength(); i++) {
				writer.write(L.getIterator().toString() + "\n");
				L.advanceIterator();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
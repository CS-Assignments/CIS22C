/**
 * Class to test List.java
 * 
 * @author Akhil Sukhthankar
 * @author Jasmine Chahal
 */
import java.util.NoSuchElementException;

public class ListTest {
	public static void main(String[] args) {
		// Tests constructor
		List<Integer> L = new List<>();
		System.out.println("Should print nothing (an empty list): " + L);

		// Tests addFirst
		System.out.println("**Testing addFirst**");
		L.addFirst(2);
		System.out.println("Should print after adding 2 to the front (2): " + L);
		L.addFirst(1);
		System.out.println("Should print after adding 1 to the front (1 2): " + L);

		// Code to test addLast goes here!
		System.out.println("**Testing addLast**");
		L.addLast(3);
		System.out.print("Should print after adding 3 to the end (1 2 3): " + L);
		L.addLast(4);
		System.out.println("Should print after adding 4 to the end(1 2 3 4): " + L);

		// Code to test for getLength the first time
		System.out.println("**Testing getLength**");
		System.out.println("Should return size as 4: " + L.getLength());

		System.out.println("\n**Testing copy constructor**");
		// Tests copy constructor for the first time
		List<Integer> M = new List<>(L);
		System.out.println("Should return all elements in L (1 2 3 4): " + M);
		// Test list equals method
		System.out.println("**Testing equals**");
		System.out.println("Should return if L equals M (true): " + L.equals(M));
		System.out.println("Should return if M equals L (true): " + M.equals(L));

		// Code to test removeFirst
		System.out.println("\n**Testing removeFirst**");
		L.removeFirst();
		System.out.print("Should print contents of list (2 3 4): " + L);
		L.removeFirst();
		System.out.println("Should print contents of list (3 4): " + L);

		// Code to test for getLength the second time
		System.out.println("**Testing getLength again**");
		System.out.println("Should return size (2): " + L.getLength());

		// Tests copy constructor for the second time
		System.out.println("**Testing copy constructor again**");
		List<Integer> N = new List<>(L);
		System.out.println("Should return all elements in L (3 4): " + N);

		// Tests for iterator methods
		L.placeIterator();
		System.out.println("**Testing placeIterator/getIterator/advanceIterator**");
		System.out.println("Should return first in L (3): " + L.getIterator());
		L.advanceIterator();
		System.out.println("Should return 4: " + L.getIterator());

		// Tests for more iterator methods
		System.out.println("\n**Testing addIterator/removeIterator/offEnd**");
		System.out.println("Should return false for offEnd: " + L.offEnd());
		L.advanceIterator();
		System.out.println("Should return true for offEnd: " + L.offEnd());
		L.placeIterator();
		L.addIterator(9);
		System.out.print("Should return List with added node (3 9 4): " + L);
		L.removeIterator();
		System.out.println("Should return List with removed node (3 4): " + L);

		// Tests for removeLast go here!
		System.out.println("**Testing removeLast**");
		L.removeLast();
		System.out.print("Should print 3: " + L);
		L.removeLast();
		System.out.println("Should print an empty list: " + L);
		System.out.println("Should throw error message for removing from empty List: ");
		try {
			L.removeFirst();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Tests for isEmpty
		System.out.println("**Testing isEmpty**");
		// Tests constructor a second time
		List L2 = new List();
		System.out.println("Should print true: " + L2.isEmpty());
		// add another test for isEmpty() here!
		System.out.println("List L from previous tests should return true for isEmpty: " + L.isEmpty());
		
		//Test new methods
		System.out.println("\n**Testing linearSearch**");
		List<Integer> O = new List<>();
		O.addLast(2);
		O.addLast(3);
		O.addLast(4);
		O.addLast(5);
		System.out.println("Should return 3 for searching 4: " + O.linearSearch(4));
		

	}

}
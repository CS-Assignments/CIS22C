
/**
 * Queue.java
 * @author Akhil Sukhthankar 
 * @author Jasmine Chahal
 */

import java.util.NoSuchElementException;

public class Queue<T extends Comparable<T>> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node front;
	private Node end;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Queue class
	 * 
	 * @postcondition a new Queue object with all fields assigned default values
	 */
	public Queue() {
		front = end = null;
		length = 0;
	}

	/**
	 * Copy constructor for the Queue class
	 * 
	 * @param original the Queue to copy
	 * @postcondition a new Queue object which is an identical, but distinct, copy
	 *                of original
	 */
	public Queue(Queue<T> original) {
		if (original == null) {
			return;
		} else if (original.length == 0) {
			length = 0;
			front = end = null;
		} else {
			Node temp = original.front;
			while (temp != null) {
				enqueue(temp.data);
				temp = temp.next;
			}
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored at the front of the Queue
	 * 
	 * @return the value at the front of the queue
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T getFront() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("getFront(): Can not access an empty Queue!");
		}
		return front.data;
	}

	/**
	 * Returns the length of the Queue
	 * 
	 * @return the length from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Determines whether a Queue is empty
	 * 
	 * @return whether the Queue is emtpy
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Determines whether two Queues contain the same values in the same order
	 * 
	 * @param o the Object to compare to this
	 * @return whether o and this are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Queue)) {
			return false;
		} else {
			Queue<T> L = (Queue<T>) o;
			if (this.length != L.length) {
				return false;
			} else {
				Node temp1 = this.front;
				Node temp2 = L.front;
				while (temp1 != null) { // Lists are same length
					if (!(temp1.data.equals(temp2.data))) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
				return true;
			}
		}
	}

	/**
	 * Determines whether data is sorted in ascending order by calling its recursive
	 * helper method isSorted() Note: when length == 0 data is (trivially) sorted
	 * 
	 * @return whether the data is sorted
	 */
	public boolean isSorted() {
		return isSorted(front);
	}

	/**
	 * Helper method to isSorted Recursively determines whether data is sorted
	 * 
	 * @param node the current node
	 * @return whether the data is sorted
	 */
	private boolean isSorted(Node node) {
		if (node == null)
			return true;
		if (node.next != null)
			return (node.data.compareTo(node.next.data) < 0) && isSorted(node.next);
		else
			return isSorted(node.next);

	}

	/**
	 * Uses the iterative linear search algorithm to locate a specific element and
	 * return its position
	 * 
	 * @param element the value to search for
	 * @return the location of value from 1 to length Note that in the case
	 *         length==0 the element is considered not found
	 */
	public int linearSearch(T element) {
		Node temp = front;
		for (int i = 0; i < length; i++) {
			if (temp.data.equals(element))
				return i + 1;
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * Returns the location from 1 to length where value is located by calling the
	 * private helper method binarySearch
	 * 
	 * @param value the value to search for
	 * @return the location where value is stored from 1 to length, or -1 to
	 *         indicate not found
	 * @precondition isSorted()
	 * @throws IllegalStateException when the precondition is violated.
	 */
	public int binarySearch(T value) throws IllegalStateException {
		if (!isSorted()) {
			throw new IllegalStateException("binarySearch(): Cannot search through binary search.");
		} else
			return binarySearch(0, length - 1, value);
	}

	/**
	 * Searches for the specified value in by implementing the recursive
	 * binarySearch algorithm
	 * 
	 * @param low   the lowest bounds of the search
	 * @param high  the highest bounds of the search
	 * @param value the value to search for
	 * @return the location at which value is located from 1 to length or -1 to
	 *         indicate not found
	 */
	private int binarySearch(int low, int high, T value) {
		if (high < low) {
			return -1;
		}
		int mid = low + (high - low) / 2; // midpoint formula

		// get the value from the midpoint node
		Node temp = front;
		for (int i = 0; i < mid; i++) {
			temp = temp.next;
		}
		T midValue = temp.data;

		if (midValue.equals(value)) {
			return mid + 1;
		} else if (value.compareTo(midValue) < 0) {
			return binarySearch(low, mid - 1, value);
		} else {
			return binarySearch(mid + 1, high, value);
		}
	}

	/**** MUTATORS ****/

	/**
	 * Inserts a new value at the end of the Queue
	 * 
	 * @param data the new data to insert
	 * @postcondition a new node at the end of the Queue
	 */
	public void enqueue(T data) {
		if (front == null) {
			front = end = new Node(data);
		} else {
			Node N = new Node(data);
			end.next = N;
			end = end.next;
		}
		length++;
	}

	/**
	 * Removes the front element in the Queue
	 * 
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 * @postcondition the front element has been removed
	 */
	public void dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("dequeue(): Cannot remove from an empty Stack!");
		} else if (length == 1) {
			front = end = null;
		} else {
			front = front.next;
		}
		length--;
	}

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Queue as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Queue values
	 */
	@Override
	public String toString() {
		Node temp = front;
		String stackString = "";
		for (int i = 0; i < length; i++) {
			stackString += (String.valueOf(temp.data) + " ");
			temp = temp.next;
		}
		return stackString;
	}

	/**
	 * Prints in reverse order to the console, followed by a new line by calling the
	 * recursive helper method printReverse
	 */
	public void printReverse() {
		printReverse(front);
		System.out.println();
	}

	/**
	 * Recursively prints to the console the data in reverse order (no loops)
	 * 
	 * @param node the current node
	 */

	private void printReverse(Node node) {
		if (node.next == null) {
			System.out.print(node.data);
			return;
		}
		printReverse(node.next);
		System.out.print(" " + node.data);
	}

}
/**
 * Tests the Queue methods
 * 
 * @author Akhil Sukhthankar
 * @author Jasmine Chahal
 */

public class QueueTest {
	public static void main(String[] args) {
		// Tests constructor
		Queue<Integer> testQueue = new Queue<Integer>();

		// Tests enqueue method
		testQueue.enqueue(10);
		testQueue.enqueue(20);
		testQueue.enqueue(30);
		testQueue.enqueue(40);

		// Tests reversePrint method
		System.out.println("Should print out 40 30 20 10");
		testQueue.printReverse();

		// Tests sorted method
		System.out.println("\nShould print out true for sorted.\n" + testQueue.isSorted());

		// Tests search method
		System.out.println(
				"\nShould print out position for 20 as index 2 using binary search\n" + testQueue.binarySearch(20));

		// Tests linear search
		System.out.println(
				"\nShould print out position for 20 as index 2 using linear search\n" + testQueue.linearSearch(20));

		// Tests dequeue method
		testQueue.dequeue();
		testQueue.dequeue();

		// Tests reversePrint method
		System.out.println("\nShould print out 40 30");
		testQueue.printReverse();

		// Tests search method
		System.out.println(
				"\nShould return -1 for position search not found using binary search\n" + testQueue.binarySearch(20));

		// Tests linear search
		System.out
				.println("\nShould return -1 for postion not found using linear search\n" + testQueue.linearSearch(20));

		// Tests toString
		System.out.println("\nShould print out the queue using toString and iteration\n" + testQueue);
	}

}

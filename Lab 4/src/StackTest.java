/**
 * Tests the Stack methods
 * 
 * @author Akhil Sukhthankar
 * @author Jasmine Chahal
 */

public class StackTest {
	public static void main(String[] args) {
		// Tests constructor
		Stack<Character> testStack = new Stack<Character>();

		// Tests enqueue method
		testStack.push('L');
		testStack.push('K');
		testStack.push('J');
		testStack.push('I');
		testStack.push('H');
		testStack.push('G');
		testStack.push('F');
		testStack.push('E');
		testStack.push('D');
		testStack.push('C');
		testStack.push('B');
		testStack.push('A');

		// Tests reversePrint method
		System.out.println("Should print out 40 30 20 10");
		testStack.printReverse();

		// Tests sorted method
		System.out.println("\nShould print out true for sorted.\n" + testStack.isSorted());

		// Tests search method
		System.out.println(
				"\nShould print out position for 20 as index 2 using binary search\n" + testStack.binarySearch('L'));

		// Tests linear search
		System.out.println(
				"\nShould print out position for 20 as index 2 using linear search\n" + testStack.linearSearch('A'));

		// Tests dequeue method
		testStack.pop();
		testStack.pop();

		// Tests reversePrint method
		System.out.println("\nShould print out 40 30");
		testStack.printReverse();

		// Tests search method
		System.out.println(
				"\nShould return -1 for position search not found using binary search\n" + testStack.binarySearch('Z'));

		// Tests linear search
		System.out
				.println("\nShould return -1 for postion not found using linear search\n" + testStack.linearSearch('C'));

		// Tests toString
		System.out.println("\nShould print out the stack using toString and iteration\n" + testStack);
	}
}

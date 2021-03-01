/**
* BSTTest.java
* @author Akhil Sukhthankar
* @author Jasmine Chahal
* CIS 22C Lab 5
*/


import java.util.Comparator;

public class BSTTest {
	public static void main(String[] args) {
		BST<Integer> mybsd = new BST<Integer>();
		Comparator<Integer> c = Integer::compare;

		mybsd.insert(5, c);
		mybsd.inOrderPrint();
		mybsd.insert(6, c);
		mybsd.inOrderPrint();
		mybsd.insert(4, c);
		mybsd.inOrderPrint();
		mybsd.insert(3, c);
		mybsd.inOrderPrint();
		mybsd.insert(2, c);
		mybsd.inOrderPrint();
		
		System.out.print("inOrderPrint(): ");
		mybsd.inOrderPrint();
		System.out.print("preOrderPrint(): ");
		mybsd.preOrderPrint();
		System.out.print("postOrderPrint(): ");
		mybsd.postOrderPrint();
		System.out.println();
		
		System.out.println("min: " + mybsd.findMin());
		System.out.println("max: " + mybsd.findMax());
		System.out.println("height: " + mybsd.getHeight());
		System.out.println("size: " + mybsd.getSize());
		System.out.println();
		
		System.out.println("search for 7: " + mybsd.search(7, c));
		System.out.println("search for 5: " + mybsd.search(5, c));
		System.out.println();
	
		System.out.println("using copy constructor");
		BST<Integer> newbsd = new BST<Integer>(mybsd, c);
		System.out.print("inOrderPrint(): ");
		newbsd.inOrderPrint();
		System.out.println();
			
		mybsd.remove(5, c);
		mybsd.inOrderPrint();

		mybsd.remove(6, c);
		mybsd.inOrderPrint();
	}
}

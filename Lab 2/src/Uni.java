/**
 * Defines our test program Uni
 * @author Akhil Sukhthankar 
 * @author Jasmine Chahal
 */
 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Uni {
    /****ADDITIONAL FUNCTIONS****/
    /**
     * Prints the data stored in the array
     * @param List list object which must be printed
     * @precondition that the list object has been created 
     */
	private static void printListData(List list) {
		System.out.println("The length of the list: " + list.getLength());
		System.out.println("The list is empty: : " + list.isEmpty());
		System.out.println("The first value in the list: " + list.getFirst());
		System.out.println("The last value in the list: " + list.getLast());
		System.out.println("The contents of the list: " + list);
	}
	
    /****ADDITIONAL FUNCTIONS****/
    /**
     * Gets user input and reads the text file
     * @param Empty ArrayList arrayOfLists to add the nodes to
     * @precondition ArrayList type is of List type
     */	
	private static void readFile(ArrayList arrayOfLists) {
		Boolean foundFile = false;
		Scanner sc = new Scanner(System.in);

		while(!foundFile) {
			System.out.print("\nPlease enter a file name: ");
			String userTextFileName = sc.nextLine();
			File myObj = new File(userTextFileName);

			try {
			      Scanner fileReader = new Scanner(myObj);
		          int counter = 1;
		          
			      while (fileReader.hasNextLine()) {
			          String data = fileReader.nextLine();
			          List<Integer> newList = new List<>();
			          
			          //prints out the header
			          System.out.println("\nList #" + counter++ + ": " + data);

			          for(int i = 0; i < data.length(); i++) {
			        	  newList.addLast((int) data.charAt(i));
			          }
			          arrayOfLists.add(newList);
			          printListData(newList);
			      }
			      
			      foundFile = true;
			      fileReader.close();
		      }
			catch (FileNotFoundException e) {
				System.out.println("Invalid file name!");
		    }
		}
		sc.close();
	}

	
	public static void main(String[] args) {
		ArrayList<List> arrayOfLists = new ArrayList<List>();
		readFile(arrayOfLists);
		System.out.println("Goodbye!");
	}
}

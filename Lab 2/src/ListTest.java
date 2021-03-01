import java.util.NoSuchElementException;

/**
 * Class to test List.java
 * @author Akhil Sukhthankar 
 * @author Jasmine Chahal
 */
public class ListTest {
    public static void main(String[] args) {
    	//Tests constructor
        List<Integer> L = new List<>();
        System.out.println("Should print nothing (an empty list): " + L);
   
        System.out.println("**Testing addFirst**");
        L.addFirst(2);
        System.out.println("Should print 2: " + L);
        L.addFirst(1);
        System.out.println("Should print 1 2: " + L);
       
        //Code to test addLast goes here!
        System.out.println("**Testing addLast**");
        L.addLast(3);
        System.out.println("Should print 1 2 3: " + L);
        L.addLast(4);
        System.out.println("Should print 1 2 3 4: " + L);
     
        //Code to test for getLength the first time
        System.out.println("Should return size as 4: " + L.getLength());
       
        //Code to test removeFirst
        System.out.println("**Testing removeFirst**");
        L.removeFirst();
        System.out.println("Should print 2 3 4: " + L);
        L.removeFirst();
        System.out.println("Should print 3 4: " + L);
        
        //Code to test for getLength the second time
        System.out.println("Should return size as 2: " + L.getLength());
        
        //Tests for removeLast go here!
        L.removeLast();
        System.out.println("Should print 3: " + L);
        L.removeLast();
        System.out.println("Should print an empty list: " + L);
        System.out.println("Should an error message for an empty List: ");
        try {
            L.removeFirst();
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        //Tests for isEmpty
        System.out.println("**Testing isEmpty**");
        //Tests constructor a second time
        List L2 = new List();
        System.out.println("Should print true: " + L2.isEmpty());
        //add another test for isEmpty() here!
        System.out.println("List L from previous tests should return true for isEmpty: " + L.isEmpty());
       
    }

}
/**
 * CardTest.java
 * @author
 * @author
 * PLS DO NOT SUBMIT THIS FILE
 */

public class CardTest {
    public static void main(String[] args) {
        Card c1 = new Card("3", "C"); //update here
        Card c2 = new Card("3", "C"); //update here
        if (c1.equals(c2)) {
            System.out.println(c1 + " is the same as " + c2);
            System.out.println(c1.compareTo(c2));
        } else if(c1.compareTo(c2) < 0) {
            System.out.println(c1 + " comes before " + c2);
            System.out.println(c1.compareTo(c2));
        } else {
            System.out.println(c2 + " comes before " + c1);
            System.out.println(c1.compareTo(c2));
        }
    	
    }
}
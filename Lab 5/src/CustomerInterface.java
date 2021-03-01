
/**
* CustomerInterface.java
* @author Akhil Sukhthankar
* @author Jasmine Chahal
* CIS 22C, Lab 5
*/
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CustomerInterface {
	
	static BST<MutualFundAccount> account_value = new BST<>();
	static BST<MutualFundAccount> account_name = new BST<>();
	static List<MutualFund> funds = new List<>();
	
	static ValueComparator vc = new ValueComparator(); 
	static NameComparator nc = new NameComparator(); 
	
	static Scanner input;
	
	public static void getMFs(List<MutualFund> funds) {
		File file = new File("mutual_funds");
		Scanner fileInput = null;
		try {
			fileInput = new Scanner(file);

			while (fileInput.hasNextLine()) {
				String mutualName = fileInput.nextLine();
				String ticker = fileInput.nextLine();
				double sharePrice = Double.parseDouble(fileInput.nextLine());
				
				MutualFund mf = new MutualFund(mutualName, ticker, sharePrice);
				funds.addLast(mf);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		fileInput.close();
	}
	
	public static void makeTransaction(int mfChoice, int mfShares) {
		funds.iteratorToIndex(mfChoice);
		MutualFund mfTemp = funds.getIterator();
		
		//searches if that position already exists within the trees
		MutualFundAccount mfPositionAN = account_name.search(new MutualFundAccount(mfTemp), nc);
				
		//this creates a new mfa if non existant in node
		if(mfPositionAN == null) {
			 mfPositionAN = new MutualFundAccount(mfTemp, mfShares);
			account_value.insert(mfPositionAN, vc);
			account_name.insert(mfPositionAN, nc);
		}
		else {
			if(mfShares == 0 || mfPositionAN.getNumShares() == -1*mfShares) {
				account_value.remove(mfPositionAN, vc);
				account_name.remove(mfPositionAN, nc);
			}
			else {
				//removes existing node from the value tree
				account_value.remove(mfPositionAN, vc);
				
				//updates the position in account tree
				mfPositionAN.updateShares(mfShares*1.0);
				
				//updates the position in value tree
				MutualFundAccount mfPositionAV = new MutualFundAccount(mfTemp);
				mfPositionAV.updateShares(mfPositionAN.getNumShares());
				account_value.insert(mfPositionAV, vc);
			}
		}
	}
	
	public static void purchaseFund() {
		System.out.println("\nPlease select from the options below:");
		funds.printNumberedList();
		
		System.out.print("Enter your choice: (1-7): ");
		int mfChoice = Integer.valueOf(input.nextLine());
		if(mfChoice < 1 || mfChoice > 7) {
			//TODO error message here
			System.out.println("Incorrect choice - out of bounds");
			return;
		}
		
		System.out.print("\nEnter the number of shares to purchase: ");
		int mfShares = Integer.valueOf(input.nextLine());
		
		makeTransaction(mfChoice, mfShares);	
	}
	
	public static void sellFund() {
		if(account_value.isEmpty()) {
			System.out.print("\nYou don't have any funds to display at this time.\n");
			return;
		}
		
		System.out.println("You own the following mutual funds:");
		displayFunds(1);
		
		System.out.print("Enter the name of the fund to sell: ");
		String mfSale = input.nextLine();
		
		System.out.print("Enter the number of shares to sell or \"all\" to sell everything: ");
		String mfSharesString = input.nextLine();
		
		//search tree if user actually has shares		
		MutualFundAccount mfTemp = account_value.search(new MutualFundAccount(new MutualFund(mfSale)), nc);
		
		int mfShares = 0;
		if(!mfSharesString.equals("all")) {
			mfShares = Integer.valueOf(mfSharesString);
		}
		
		//this means they don't have shares
		if(mfTemp == null) {
			//TODO usually would do a error check but don't have to
		}
		else {
			int mfIndex = funds.linearSearch(mfTemp.getMf());
			makeTransaction(mfIndex, -1*mfShares);
		}
	}
	
	public static void displayFunds(int displayChoice) {
		if(account_value.isEmpty()) {
			System.out.print("\nYou don't have any funds to display at this time.\n");
			return;
		}
		
		if(displayChoice == 0) {
			
			System.out.print("\nView Your Mutual Funds By:\n\n"
					+ "1. Name\n"
					+ "2. Value\n"
					+ "\nEnter your choice (1 or 2): ");
			
			displayChoice = Integer.valueOf(input.nextLine());
			
			if(displayChoice != 1 && displayChoice != 2) {
				System.out.print("\nInvalid Choice!\n");
				return;
			}
		}	
		
		if(displayChoice == 1)
			account_name.inOrderPrint();
		else 
			account_value.inOrderPrint();
	}
	
	public static boolean getUserInput() {
		System.out.println("\nPlease select from the following options:\n");
		System.out.println("A. Purchase a Fund");
		System.out.println("B. Sell a Fund");
		System.out.println("C. Display Your Current Funds");
		System.out.println("X. Exit\n");
		
		System.out.print("Enter your choice: ");
		String choice = input.nextLine();
		
		char selection = Character.toUpperCase(choice.charAt(0));
		
		switch(selection) {
			case 'A': 
				purchaseFund();
				break;
			case 'B':
				sellFund();
				break;
			case 'C':
				displayFunds(0);
				break;
			case 'X':
				return false;
			default:
				System.out.println("\nInvalid menu option. Please enter A-C or X to exit.\n");
		}
			return true;
	}
	
	public static void main(String[] args) {
		getMFs(funds);
		System.out.println("Welcome to Mutual Fund InvestorTrack (TM)!");
		input = new Scanner(System.in);
		
		boolean contin = true;
		while(contin) {
			contin = getUserInput();
		}
		
		input.close();
		System.out.println("Goodbye!\n");
	}
}
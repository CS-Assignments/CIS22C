/**
 * Card.java
 * @author Akhil Sukhthankar
 * @author Jasmine Chahal CIS 22C, Lab 3
 */

public class Card implements Comparable<Card> {
	private String rank;
	private String suit;

	/**
	 * Constructor for the Card class
	 * 
	 * @param rank the rank of card from 2 to A
	 * @param suit the suit of card C, D, H, or S
	 */
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns the card's rank
	 * 
	 * @return rank a rank from 2 (low) to A (high)
	 */
	public String getRank() {
		return this.rank;
	}

	/**
	 * Returns the card's suit
	 * 
	 * @return C, D, H, or S
	 */
	public String getSuit() {
		return this.suit;
	}

	/**
	 * Updates the card's rank
	 * 
	 * @param rank a new rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Updates the card's suit
	 * 
	 * @param suit the new suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Concatenates rank and suit
	 */
	@Override
	public String toString() {
		return rank + suit;
	}

	/**
	 * Overrides the equals method for Card Compares rank and suit and follows the
	 * equals formula given in Lesson 4 and also in Joshua Block's text
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Card)) {
			return false;
		} else {
			Card C = (Card) o;
			return (this.rank == C.rank && this.suit == C.suit);
		}
	}

	/**
	 * Orders two cards first by suit (alphabetically) Next by rank. "A" is
	 * considered the high card Order goes 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	 * 
	 * @return a negative number if this comes before c and a positive number if c
	 *         comes before this and 0 if this and c are equal according to the
	 *         above equals method
	 */
	@Override
	public int compareTo(Card c) {
		int rankedC, rankedT;
		switch (c.rank) {
		case "A":
			rankedC = 14;
			break;
		case "K":
			rankedC = 13;
			break;
		case "Q":
			rankedC = 12;
			break;
		case "J":
			rankedC = 11;
			break;
		default:
			rankedC = Integer.parseInt(c.rank);
		}

		switch (this.rank) {
		case "A":
			rankedT = 14;
			break;
		case "K":
			rankedT = 13;
			break;
		case "Q":
			rankedT = 12;
			break;
		case "J":
			rankedT = 11;
			break;
		default:
			rankedT = Integer.parseInt(this.rank);
		}

		// if they are the same card
		if (this.equals(c)) {
			return 0;
		}
		// if this.card has a greater suit, return positive
		else if (this.suit.compareTo(c.suit) > 0) {
			return 1;
		}
		// if this.card has a smaller suit, return negative
		else if (this.suit.compareTo(c.suit) < 0) {
			return -1;
		}
		// if they have the same suit, compare ranks
		else {
			// if this.rank has a greater rank, return positive
			if (rankedC < rankedT) {
				return 1;
			}
			// else return negative
			else {
				return -1;
			}
		}
	}
}
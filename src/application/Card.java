/* Card.java [completed]
 * Author: Mike Mathews 2020
 * Card.java will be implemented into an array called Deck
 * It has two attributes, a rank and a suit.
 */

package application;

public class Card {
	private char RANK;	// 1,2,3,4,J,K,A, let 10 be represented as T
	private char SUIT;	// D(iamonds), H(earts), C(lub), S(pade)
	public String errMsg = "src/application/Card can only accept valid cards not including jokers"
			+ "\nNumbers will be converted to Char and Suit should be the first Character only"
			+ "\ne.g. Card('1','D')"
			+ "\nYou may need to setRank(char) or setSuit(char) if you are instantiating with Card()";
	public static String validRanks = "A23456789TJQK";
	public static String validSuits = "CDHS";
	
	/*
	 * Constructor for easy instance
	 * @param rank: char, character for the rank A23456789TJQK
	 * @param suit: char, character for suit CDHS
	 */
	public Card(char rank, char suit)
	{
		// If there are illegal characters: only accepting valid characters
		if(!validRanks.contains(Character.toString(rank)) 
			&& !validSuits.contains(Character.toString(suit)))
				throw new IllegalArgumentException(errMsg);
				
		RANK = rank;
		SUIT = suit;
	}
	
	/*
	 * In the case that it needs to be null
	 * and instanced before 
	 */
	public Card()
	{
		RANK = 0;	// char ascii null is 0
		SUIT = 0;	// char ascii null is 0
	}
	
	/****************************
	 * Accessor
	 ****************************/
	public char getRank() {return RANK;}
	public char getSuit() {return SUIT;}
	
	/****************************
	 * Mutators
	 ****************************/
	public void setRank(char rank) 
	{
		if(!validRanks.contains(Character.toString(rank)))
			throw new IllegalArgumentException(errMsg);
		RANK=rank;
	}
	public void setSuit(char suit) 
	{
		if(!validRanks.contains(Character.toString(suit)))
			throw new IllegalArgumentException(errMsg);
		SUIT=suit;
	}
	
	public String toString()
	{
		return String.format("Card:\tRank: %c\tSuit: %c\n", getRank(),getSuit());
	}
	
	/* Card Check
	public static void main(String[] args)
	{
		Card card = new Card('A', 'H');
		System.out.print(card);
	}
	*/
}

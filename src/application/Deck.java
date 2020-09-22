/* Deck.java [completed]
 * Author: Mike Mathews 2020
 * Deck is an array of Cards
 * Used in several games
 * should be able to shuffle and deal cards
 */

package application;

import java.util.ArrayList;
import java.util.Collections;

import exceptions.InvalidLogicException;

public class Deck {
	private ArrayList<Card> deck;
	
	/*
	 * Deck is an array of Cards(char, char) with rank, suit respectively
	 */
	public Deck()
	{
		deck = new ArrayList<Card>();
		
		// add all the cards to the deck
		for(int i=0;i<13;i++)
		{
			for(int j=0;j<4;j++)
			{
				// utilizing static variables from Card to be reduce hardcoded Strings
				deck.add(new Card(Card.validRanks.charAt(i), Card.validSuits.charAt(j)));
			}
		}
	}
	
	/*
	 * Shuffle the deck
	 * rearrange the order of Cards in deck at random
	 * ONLY SHUFFLE WHEN DECK IS 52 CARDS, else throw Exception
	 */
	public void shuffle() throws InvalidLogicException
	{
		// only shuffle when its a full deck
		if(this.deck.size() != 52)
		{
			throw new InvalidLogicException("Only can shuffle with a full deck (52), current size is: " + this.deck.size() + "\n");
		}
		// shuffle the deck, could be substituted with Collections shuffle
		// but made it a local method instead. either way
		for(int i=0;i<4;i++)
			Collections.shuffle(deck); 	
	}
	
	/*
	 * + getTopCard(): Card
	 * remove card from Deck
	 * @return Card: card on top of the deck == first card in the deck
	 */
	public Card getTopCard()
	{
		Card topCard = deck.get(0);
		deck.remove(0);
		return topCard;
	}
	
	/*
	 * + deal(int int): void
	 * Remove all cards dealt from deck.
	 * @param numOfCards: int, number of Cards to deal out to the players at the table
	 * @param numOfPeople: int, number of people to deal cards to at the table
	 */
	public void deal(int numOfCards, ArrayList<Gambler> players)
	{
		
	}
	
	/*
	 * + toString(): String
	 * print count of cards in deck
	 */
	public String toString()
	{
		return String.format("Deck:\tCount: %d\n", this.deck.size()) + this.deck;
	}
	
	/* Deck Check
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.shuffle();
		System.out.print(deck.getTopCard());
		System.out.print(deck);
	}
	 */
}

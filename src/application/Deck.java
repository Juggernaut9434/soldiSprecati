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
	 * @return ArrayList<ArrayList<Card>>: a 2D array of cards, each row is a single player's cards
	 */
	public ArrayList<ArrayList<Card>> deal(int numOfCards, int numOfPeople)
	{
		// 2D Array
		ArrayList<ArrayList<Card>> dealtHands = new ArrayList<ArrayList<Card>>();
		// Nested For loop to reach into the 2D Array
		for(int i=0;i<numOfPeople;i++)
		{
			ArrayList<Card> hand = new ArrayList<Card>();	// blank array
			for(int j=0;j<numOfCards;j++)
			{
				hand.add(this.getTopCard());				// build the blank array
			}
			dealtHands.add(hand);							// add blank array to 2D array
		}
		return dealtHands;
	}
	
	/*
	 * + toString(): String
	 * print count of cards in deck
	 */
	public String toString()
	{
		return String.format("Deck:\tCount: %d\n", this.deck.size()) + this.deck;
	}
	
}

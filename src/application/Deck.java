package application;

import java.util.ArrayList;
import java.util.Collections;

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
	 */
	public void shuffle()
	{
		// shuffle the deck, could be substituted with Collections shuffle
		// but made it a local method instead. either way
		Collections.shuffle(deck); 	
	}
}

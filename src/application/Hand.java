package application;

import java.util.ArrayList;

public class Hand {
	private int playerIndex;
	private ArrayList<Card> cardsInHand;
	
	public Hand(int playerIndex, ArrayList<Card> cardsDealt)
	{
		this.playerIndex = playerIndex;
		this.cardsInHand = cardsDealt;
	}
	
	public int getPlayerIndex() {return this.playerIndex;}
	public ArrayList<Card> getHand() {return this.cardsInHand;}
	
	public String toString()
	{
		return String.format("Index: %d\tHand: " + this.cardsInHand, this.playerIndex);
	}
}

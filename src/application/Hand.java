package application;

public class Hand {
	private int playerIndex;
	private Card[] cardsInHand;
	
	public Hand(int playerIndex, Card[] cardsDealt)
	{
		this.playerIndex = playerIndex;
		this.cardsInHand = cardsDealt;
	}
	
	public int getPlayerIndex() {return this.playerIndex;}
	public Card[] getHand() {return this.cardsInHand;}
	
	public String toString()
	{
		return String.format("Index: %d\tHand: " + this.cardsInHand, this.playerIndex);
	}
}

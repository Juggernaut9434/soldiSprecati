/* BlackJack.java
 * Author: Mike Mathews 2020
 * All the logic for Black Jack
 * not including GUI
 */

package application;

import java.util.ArrayList;

import exceptions.InvalidLogicException;

public class BlackJack extends Table {
	
	private Deck deck;
	private ArrayList<ArrayList<Card>> playerHands;
	private int[] scores;

	public BlackJack(int maxPlayers, int ante, String dealer) 
	{
		// BlackJack gameIndex = 1
		super(1, maxPlayers, ante, dealer);
		
		// make a deck and shuffle it
		setDeck(new Deck());
		try {
			getDeck().shuffle();
			this.addPlayer(new Gambler(dealer));	// have dealer always be index 0
		} catch(InvalidLogicException e)
		{
			setDeck(new Deck());
		}
		setPlayerHands(new ArrayList<ArrayList<Card>>());
		setScores(new int[2]);		// for now, there wil only be two players, dealer and player.
	}
	
	public void scoreHands()
	{
		getScores()[0] = 0; getScores()[1] = 0;	// reset the scores
		
		// access the player then access card within player
		int i=0;	// for the playerScores index iteration
		for(ArrayList<Card> player: getPlayerHands())
		{
			for(Card card: player)
			{
				try {
					// Set the playerScores
					this.getScores()[i] += this.getScoreVal(card);
					
				} catch (InvalidLogicException e) {
					e.printStackTrace();
				}	// get total score of player and add to hand
			}
			i++;	// go to next player
		}
	}
	
	public int getScoreVal(Card card) throws InvalidLogicException
	{
		char r = card.getRank();
		// r is a royal or ten
		
		if("23456789".indexOf(r) != -1)
		{
			int r0 = Integer.parseInt(String.valueOf(r));
			return r0;
		}
		else if(("TJQK".indexOf(r) != -1))
			return 10;
		else if("A".indexOf(r) != -1)
			return 11;
		else
			throw new InvalidLogicException("BlackJack.java: Only ranks A23456789TJQK are allowed\n");
	}
	
	/* + hit(int): void
	* @param playerIndex: int, the row / player from playerHands
	*/
	public void hit(int playerIndex)
	{
		getPlayerHands().get(playerIndex).add(this.getDeck().getTopCard());
		this.scoreHands();
		return;
	}
	
	/* + stay(int): boolean
	 * Does not allow to add more cards to players hand and ends player's turn.
	 * @param playerIndex: int, the row/player from playerHands
	 * @return boolean: does player want to stay
	 */
	public int stay(int playerIndex)
	{
		return 1;
	}
	/* +split(int): void - maybe not dev right away
	 * checks if both cards are the same rank
	 * then splits their hand into two.
	 */
	/* + bust(int): boolean
	 * if player has a rank 'A' and over 21, make it 11 to 1.
	 * @param playerIndex: int - the row/player from playerHands
	 * @return: boolean, if score is over 21, bust
	 */
	public boolean isBust(int playerIndex)
	{
		this.scoreHands();
		if(getScores()[playerIndex] > 21)
		{
			ArrayList<Card> hand = getPlayerHands().get(playerIndex);
			for(Card c: hand)
			{
				if(c.getRank() == 'A')
					// make the value of A from 11 to 1
					getScores()[playerIndex] -= 10;
			}
		}
		if(getScores()[playerIndex] > 21)
		{
			return true;
		}
		return false;
	}
	/* + bet(int): int, int - index of player, return be
	 * Sets a bet for the game.
	 * @param playerIndex: int - the row/player from playerHands
	 * @return bet: int - the bet value
	 */
	
	public String toString() 
	{
		String s = "";
		for(ArrayList<Card> hand: this.getPlayerHands())
		{
			s += "*********\n";
			for(Card c: hand)
				s += c;
		}
		return s;
	}
	
	/*************GETTER AND SETTER FUNCTIONS***********/
	public ArrayList<ArrayList<Card>> getPlayerHands() {
		return playerHands;
	}

	public void setPlayerHands(ArrayList<ArrayList<Card>> playerHands) {
		this.playerHands = playerHands;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public int[] getScores() {
		return scores;
	}
	
	public void setAnte(int ante) {this.ante = ante;}
	
	public int getAnte() {return this.ante;}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
}

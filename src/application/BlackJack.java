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

	public BlackJack(int maxPlayers, int ante, String dealer) 
	{
		// BlackJack gameIndex = 1
		super(1, maxPlayers, ante, dealer);
		
		// make a deck and shuffle it
		deck = new Deck();
		try {
			deck.shuffle();
			this.addPlayer(new Gambler(dealer));	// have dealer always be index 0
		} catch(InvalidLogicException e)
		{
			deck = new Deck();
		}
	}
	
	/***
	 * + mainPlay(): void
	 * where black jack is played with each hand
	 * @throws InvalidLogicException 
	 */
	public void mainPlay() throws InvalidLogicException
	{
		int numOfPlayers = super.players.size();
		int[] playerScores = new int[numOfPlayers];		// instance with ints with the size of players
		// catch if no other players besides dealer are in
		if(numOfPlayers<=1)
			throw new InvalidLogicException("BlackJack.mainPlay():\tNo players to play"
					+ "\nplayers:" + players);
		// deal 2 cards to every player and evaluate their round's cards value
		// the row will be equivalent to the player's index
		playerHands = deck.deal(2, numOfPlayers);
		
		// access the player then access card within player
		int i=0;	// for the playerScores index iteration
		for(ArrayList<Card> player: playerHands)
		{
			for(Card card: player)
			{
				playerScores[i] += this.getScoreVal(card);	// get total score of player and add to hand
			}
			i++;	// go to next player
		}
		
		// ask player to place a bet	
		// player Actions
	}
	
	public int getScoreVal(Card card) throws InvalidLogicException
	{
		char r = card.getRank();
		// r is a royal or ten
		if(("TJQK".indexOf(r) != -1))
			return 10;
		else if("23456789".indexOf(r) != -1)
			return (int) r;
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
		playerHands.get(playerIndex).add(this.deck.getTopCard());
	}
	
	/* + stay(int): boolean
	 * Does not allow to add more cards to players hand and ends player's turn.
	 * @param playerIndex: int, the row/player from playerHands
	 * @return boolean: does player want to stay
	 */
	public boolean stay(int playerIndex)
	{
		// TODO a better way of doing this
		// possibly a value for each player
		return true;
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
	public boolean bust(int playerIndex, int[] scores)
	{
		if(scores[playerIndex] >= 21)
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
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack(5, 10, "John");
		try {
			game.addPlayer(new Gambler(10, "Henry"));
			game.mainPlay();
		} catch (InvalidLogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

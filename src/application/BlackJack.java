/* BlackJack.java
 * Author: Mike Mathews 2020
 * All the logic for Black Jack
 * not including GUI
 */

package application;

import exceptions.InvalidLogicException;

public class BlackJack extends Table {
	
	private Deck deck;

	public BlackJack(int gameIndex, int maxPlayers, int ante, String dealer) throws InvalidLogicException 
	{
		super(gameIndex, maxPlayers, ante, dealer);
		// make a deck and shuffle it
		deck = new Deck();
		deck.shuffle();
	}
	
	/***
	 * + mainPlay(): void
	 * where black jack is played with each hand
	 * @throws InvalidLogicException 
	 */
	public void mainPlay() throws InvalidLogicException
	{
		int numOfPlayers = super.players.size();
		// catch if
		if(numOfPlayers<1)
			throw new InvalidLogicException("BlackJack.mainPlay():\tNo players to play"
					+ "\nplayers:" + players);
		
	}
	
}

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

	public BlackJack(int gameIndex, int maxPlayers, int ante, String dealer) 
	{
		super(gameIndex, maxPlayers, ante, dealer);
		// make a deck and shuffle it
		deck = new Deck();
		try {
			deck.shuffle();
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
		// catch if
		if(numOfPlayers<1)
			throw new InvalidLogicException("BlackJack.mainPlay():\tNo players to play"
					+ "\nplayers:" + players);
		// deal 2 cards to every player and evaluate their round's cards value
		// ask player to place a bet
		// ask player to hit stay, split, etc
	}
	
}

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
		// catch if no other players besides dealer are in
		if(numOfPlayers<=1)
			throw new InvalidLogicException("BlackJack.mainPlay():\tNo players to play"
					+ "\nplayers:" + players);
		// deal 2 cards to every player and evaluate their round's cards value
		// the row will be equivalent to the player's index
		playerHands = deck.deal(2, numOfPlayers);
		
		// access the player then access card within player
		for(ArrayList<Card> player: playerHands)
		{
			for(Card card: player)
			{
				System.out.print(card);
			}
			System.out.print("---\n");
		}
		// ask player to place a bet
		// ask player to hit stay, split, etc
		
	}
	
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

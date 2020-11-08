package application;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.InvalidLogicException;

class Test_BlackJack {

	private BlackJack getGameSetup()
	{
		BlackJack game = new BlackJack(5, 10, "John");
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('K', 'D');
		Card c3 = new Card('5', 'H');
		Card c4 = new Card('J', 'S');
		
		ArrayList<Card> hand1 = new ArrayList<Card>();
		ArrayList<Card> hand2 = new ArrayList<Card>();

		hand1.add(c1); hand1.add(c2);
		hand2.add(c3); hand2.add(c4);
		
		game.getPlayerHands().add(hand1);
		game.getPlayerHands().add(hand2);
		return game;
	}
	@Test
	void basic_score_test() {
		BlackJack game = this.getGameSetup();
		
		game.scoreHands();
		
		assertEquals("Test 1", 12, game.getScores()[0]);
		assertEquals("Test 2", 15, game.getScores()[1]);
	}
	
	@Test
	void hit_test() {
		BlackJack game = this.getGameSetup();
		
		Card c5 = new Card('7', 'D');
		game.getPlayerHands().get(1).add(c5);
		assertEquals("Card Size grew by 1", game.getPlayerHands().get(1).size(), 3);
	}
	
	@Test
	void bust_test() {
		BlackJack game = this.getGameSetup();
		
		Card c5 = new Card('7', 'D');
		game.getPlayerHands().get(1).add(c5);
		game.scoreHands();
		assertEquals("Score below 21", game.isBust(0), false);
		assertEquals("Score above 21", game.isBust(1), true);
	}
	@Test
	void ace_test() {
		BlackJack game = this.getGameSetup();
		Card c5 = new Card('A', 'H');
		game.getPlayerHands().get(1).add(c5);
		game.scoreHands();	// now should be 16 NOT 26
		assertEquals("Ace doesn't bust player", game.isBust(1), false);
		assertEquals("Ace is converted to 1, score 16", game.getScores()[1], 16);
	}

}

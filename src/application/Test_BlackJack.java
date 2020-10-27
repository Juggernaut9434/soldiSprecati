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
		Card c4 = new Card('A', 'S');
		
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
		
		int[] playerScores = new int[2];
		game.scoreHands(playerScores);
		
		assertEquals("Test 1", 12, playerScores[0]);
		assertEquals("Test 2", 16, playerScores[1]);
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
		int[] playerScores = new int[2];
		game.scoreHands(playerScores);
		assertEquals("Score above 21", game.isBust(1, playerScores), -1);
		assertEquals("Score below 21", game.isBust(0, playerScores), 0);
	}

}

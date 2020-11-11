// Main file
// to take input from scene etc.

package application;

import java.util.Scanner;

import exceptions.InvalidLogicException;

public class SoldiSprecati {
	
	public static void main(String[] args)
	{
		// get user input for action in main play
		char input;
		Scanner console = new Scanner(System.in);
		// do/while for replay logic
		do {
			/******BlackJack Logic********/
			BlackJack bj = new BlackJack(2, 10, "Jerry");
			
			try {
				bj.addPlayer(new Gambler("Mike"));
			} catch (InvalidLogicException e) {
				e.printStackTrace();
			}
			// store the player size, eventual DLC expansion
			int numOfPlayers = bj.players.size();		
			
			// deal 2 cards to every player and evaluate their round's cards value
			// the row will be equivalent to the player's index
			bj.setPlayerHands(bj.getDeck().deal(2, numOfPlayers));
			bj.scoreHands();
			
			// deal 2 cards to each player
			// player Actions
			/**
			 * state 0: get another action
			 * state -1: User Busted
			 * state 1: User stayed
			 * state 2: Dealer busted
			 */
			int state = 0;
			do {
				// Prompt user for current score.
				if(bj.isBust(1))
				{
					state = -1;
					System.out.println("You busted at: " + bj.getScores()[1]);
					break;
				}
				System.out.println("(H) hit or (S) stay at " + bj.getScores()[1]);
				
				// score hands after dealt 2 to each.
				bj.scoreHands();
				int score = bj.getScores()[1];
				
				// character select from console
				input = console.next().charAt(0);				
					
				//TODO ask for user input on action
				switch(input) {
					// hit or add another card to player
					case 'H': 
						bj.hit(1);
						System.out.println("You're cards are:\n" + bj.getPlayerHands().get(1).toString());
						bj.scoreHands();
						if(bj.isBust(1)) break;	// change A to 1 if needed.
						System.out.println("Your score is now: " + bj.getScores()[1]);
						
						break;
					// stay or not adding any more cards to hand
					case 'S':
						state = bj.stay(1);
						System.out.println("You stayed at: " + score);
						break;
					default:
						break;
				}  
			} while(state == 0);
			
			// user's turn to hit/stay and user not busted.
			while(bj.getScores()[0] < 16 && state != -1)
				bj.hit(0);
			// if dealer busted, user won.
			if(bj.isBust(0))
				state = 2;
			
			System.out.println(bj);		// after it is all done
			
			// BUSTED find a thing to show that they lost
			if(state == -1) 
				System.out.println("You lost!");
			
			// COMPARE find a thing to show that they stayed and then compared to dealer.
			else if(state == 1)
			{
				// if WIN: the user has higher or equal to dealer
				if(bj.getScores()[1] >= bj.getScores()[0])
					System.out.println("You won!");
				// else LOST
				else
					System.out.println("You lost!");
			}
			else if(state == 2)
				System.out.println("Dealer busted, you won!");
			// REPLAY? 
			System.out.println("(Q) Quit?, (R) Replay?");
			input = console.next().charAt(0);
		} while(input == 'R');
		console.close();
	}
}

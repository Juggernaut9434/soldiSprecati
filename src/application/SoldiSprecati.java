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
		
		
		/******BlackJack Logic********/
		BlackJack bj = new BlackJack(2, 10, "Jerry");
		
		try {
			bj.addPlayer(new Gambler("Mike"));
		} catch (InvalidLogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numOfPlayers = bj.players.size();		
		
		// deal 2 cards to every player and evaluate their round's cards value
		// the row will be equivalent to the player's index
		bj.setPlayerHands(bj.getDeck().deal(2, numOfPlayers));
		bj.scoreHands();
		
		System.out.println("(H) hit or (S) stay at " + bj.getScores()[1]);
		
		// deal 2 cards to each player
		// player Actions
		int state = 0;
		do {
			bj.scoreHands();
			int score = bj.getScores()[1];
			input = console.next().charAt(0);	// character select
			System.out.println("Your score is: " + score);
			if(bj.isBust(1))
			{
				state = -1;
				System.out.println("You busted at: " + score);
				break;
			}
				
			//TODO ask for user input on action
			switch(input) {
				// hit or add another card to player
				case 'H': 
					bj.hit(1);
					System.out.println(bj.getPlayerHands().get(1).toString());
					System.out.println("Your score is now: " + score);
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
		System.out.println(bj);		// after it is all done
		
		// state is no longer 0 and have to either lose or compare
		if(state == -1) return;	//TODO find a thing to show that they lost
		if(state == 1) return;	//TODO find a thing to show that they stayed and then compared to dealer.
	
		console.close();
	}
}

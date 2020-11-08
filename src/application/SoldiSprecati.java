// Main file
// to take input from scene etc.

package application;

import java.util.Scanner;

public class SoldiSprecati {
	
	public static void main(String[] args)
	{
		// get user input for action in main play
		char input;
		Scanner console = new Scanner(System.in);
		input = console.next().charAt(0);	// character select
		
		/******BlackJack Logic********/
		BlackJack bj = new BlackJack(2, 10, "Jerry");
		int numOfPlayers = bj.players.size();		
		
		// deal 2 cards to every player and evaluate their round's cards value
		// the row will be equivalent to the player's index
		bj.setPlayerHands(bj.getDeck().deal(2, numOfPlayers));
		bj.scoreHands();
		
		// ask player to place a bet	
		// player Actions
		int state = 0;
		do {
			if(bj.isBust(1))
				state = -1;
				
			//TODO ask for user input on action
			switch(input) {
				// hit or add another card to player
				case 'H': 
					bj.hit(1);
				// stay or not adding any more cards to hand
				case 'S':
					state = bj.stay(1);
				
			}  
		} while(state == 0);
		
		// state is no longer 0 and have to either lose or compare
		if(state == -1) return;	//TODO find a thing to show that they lost
		if(state == 1) return;	//TODO find a thing to show that they stayed and then compared to dealer.
	}
}

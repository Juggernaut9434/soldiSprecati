// Michael Mathews 2020
// Controller for the application
// interacts with the fxml file
// where all the logic of the Soldi Sprecati is.

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.BlackJack;
import application.Gambler;
import exceptions.InvalidLogicException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BlackJackController {

	
	// fxml elements
	@FXML private Button HitBtn, StayBtn;
	@FXML private Button replayBtn;
	@FXML private Label MyScore, ResultLabel;
	@FXML private Label myMoney, gameOver;
	
	@FXML private HBox addCards, myCards, dealerCards;
	
	@FXML private RadioMenuItem smallBet, mediumBet, largeBet;
	@FXML private MenuItem about, rules;
	
	
	@FXML private URL location;
	@FXML private ResourceBundle resources;
	private ImageView backOfCard;

	
	public BlackJack bj;
	
	/**
	 * state 0: get another action
	 * state -2: Game OVER
	 * state -1: User Busted
	 * state 1: User stayed
	 * state 2: Dealer busted
	 * state 3: round is over
	 */
	public static int state;
	private static int amount = 10;
	
	private BlackJackGUI main;
	
	// connect main class to controller
	public void setGUI(BlackJackGUI main)
	{
		this.main = main;
		myMoney.setText(String.valueOf(amount));
		smallBet.setSelected(true);
	}
	
	public BlackJackController() {}
	
	@FXML
	private void initialize() 
	{
		state = 0;
		
		/********SOLDI SPRECATI*********/
		this.bj = new BlackJack(2, 10, "Jerry");
		try {
			bj.addPlayer(new Gambler("Stacy"));
		} catch (InvalidLogicException e) {
			e.printStackTrace();
		}
		// store the player size, eventual DLC expansion
		int numOfPlayers = bj.getPlayers().size();		
		
		// deal 2 cards to every player and evaluate their round's cards value
		// the row will be equivalent to the player's index
		bj.setPlayerHands(bj.getDeck().deal(2, numOfPlayers));
		bj.scoreHands();
		
		// change the gui label to show the total
		MyScore.setText(String.valueOf(bj.getScores()[1]));
		
		/**************GUI LOGIC*********************/
		
		// initially set result to nothing
		ResultLabel.setText("");
		// Add the cards to the table	
		myCards.getChildren().add(this.setImage(1,0));
		myCards.getChildren().add(this.setImage(1,1));
		dealerCards.getChildren().add(this.setImage(0, 0));
		// the back side card for card 
		backOfCard = new ImageView();
		backOfCard.setImage(new Image( (this.getClass().getResource("/Deck/BackOfCard.png").toString()), 50, 50, true, true));
		dealerCards.getChildren().add(backOfCard);
		
		// one bet radio button at a time
		ToggleGroup group = new ToggleGroup();
		smallBet.setToggleGroup(group);
		mediumBet.setToggleGroup(group);
		largeBet.setToggleGroup(group);
		
		// initially set bet to small
		if(smallBet.isSelected()) bj.setAnte(10);
		else if(mediumBet.isSelected()) bj.setAnte(100);
		else if(largeBet.isSelected()) bj.setAnte(1000);

	}
	
	/*
	 * @param int: player, the player index
	 * @param int: card, the card index in the player's hand.
	 * @return ImageView: an imageview with an image to add to the table
	 */
	private ImageView setImage(int player, int card)
	{
		// URL to the image in question
		URL s = this.getClass().getResource("/Deck/" 
				+ String.valueOf(bj.getPlayerHands().get(player).get(card).getRank()) 
				+ bj.getPlayerHands().get(player).get(card).getSuit() + ".png");
		// make an image of it, string form of url and resize the image.
		Image i = new Image(s.toExternalForm(), 50, 50, true, true);
		ImageView iv = new ImageView();
		iv.setImage(i);		
		return iv;
	}
	
	@FXML
    void hit() {
		// only works when not busted
		if(state == 0)
		{
			try {
				// pause user for a second
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// add card to the user
			bj.hit(1);
			if(bj.isBust(1)) {
				state = -1;
				ResultLabel.setText("You Busted!");
				this.changeMoney(false);
			}
			// update the score value label
			MyScore.setText(String.valueOf(bj.getScores()[1]));
			// add that newest card to the table GUI, last hand in arrayList
			myCards.getChildren().add(this.setImage(1, bj.getPlayerHands().get(1).size()-1));
		}
    }

    @FXML
    void stay() {
    	// press stay, change state
    	if(state == 0)
    	{
	    	state = 1;
    	}
    	// check to score hand
    	if(state == 1)
    	{
    		scoreGUI();
    		state = 3;
    	}
    }
    
    @FXML
    void replay() {
    	// restart. clear the table
		myCards.getChildren().clear();
		dealerCards.getChildren().clear();
		// if above 0, be able to restart.
		if(amount > 0) initialize();
		else
		{
			state = -2;
	    	gameOver.setText("GAME OVER!");
		}
    }
    
    /**
	 * state 0: get another action
	 * state -1: User Busted
	 * state 1: User stayed
	 * state 2: Dealer busted
	 * state 3: its over.
	 */
    void scoreGUI()
    {
    	// after it is done
		if(state != 0)
		{
			// user busted
			if(state == -1)
			{
				ResultLabel.setText("You Lost!");
				// remove 100 from money total, start with 10,000
				this.changeMoney(false);
			}
			// compare and maybe dealer bust,
			else 
			{
				
				// dealer's other card
				dealerCards.getChildren().remove(backOfCard);	// remove back of card
				dealerCards.getChildren().add(this.setImage(0, 1));
				
				// dealer adds cards if necessary
				while(bj.getScores()[0] < 17 && state != -1)
				{
					// wait a few seconds before adding another card
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// add a card if dealer is under 16
					bj.hit(0);
					// show the card on the table
					dealerCards.getChildren().add(this.setImage(0, bj.getPlayerHands().get(0).size()-1));
				}
				// if dealer busted, user won.
				if(bj.isBust(0))
				{
					state = 2;
					ResultLabel.setText("You Won!");
					//  add 100 to the money total
					this.changeMoney(true);
				}
				// dealer did not bust and must compare hands
				else
				{
					// if WIN: the user has higher or equal to dealer
					if(bj.getScores()[1] >= bj.getScores()[0])
					{
						ResultLabel.setText("You Won!");
						// add 100 to the money total
						this.changeMoney(true);
					}
					// else LOST
					else
					{
						ResultLabel.setText("You Lost!");
						// remove 100 from money total
						this.changeMoney(false);
					}
				}
			}
		}
    }
    
    private void changeMoney(boolean earnMoney)
    {
    	// earn money
    	if(earnMoney)
    	{
    		amount += bj.getAnte();
    	} 
    	else 
    	{
    		amount -= bj.getAnte();
    	}
    	// change the label
		myMoney.setText(String.valueOf(amount));
    }
}

// Michael Mathews 2020
// Controller for the application

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.BlackJack;
import application.Gambler;
import exceptions.InvalidLogicException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BlackJackController {

	
	// fxml elements
	@FXML private Button HitBtn;
	@FXML private Button StayBtn;
	@FXML private Label MyScore, ResultLabel;
	
	@FXML private HBox addCards, myCards, dealerCards;
	
	@FXML private URL location;
	@FXML private ResourceBundle resources;

	
	public BlackJack bj;
	public static int state;
	
	private BlackJackGUI main;
	
	// connect main class to controller
	public void setGUI(BlackJackGUI main)
	{
		this.main = main;
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
		
		/******Add the cards to the table*********/		
		myCards.getChildren().add(this.setImage(1,0));
		myCards.getChildren().add(this.setImage(1,1));
		dealerCards.getChildren().add(this.setImage(0, 0));
		//dealerCards.getChildren().add(this.setImage(0, 1));
		// the backside card for card 
		
		
	}
	
	private ImageView setImage(int player, int card)
	{
		URL s = this.getClass().getResource("/Deck/" 
				+ String.valueOf(bj.getPlayerHands().get(player).get(card).getRank()) 
				+ bj.getPlayerHands().get(player).get(card).getSuit() + ".png");
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
			System.out.println("hit");
			bj.hit(1);
			if(bj.isBust(1)) {
				state = -1;
				ResultLabel.setText("You Busted!");
			}
			// update the score value label
			MyScore.setText(String.valueOf(bj.getScores()[1]));
			// add that newest card to the table GUI, last hand in arrayList
			myCards.getChildren().add(this.setImage(1, bj.getPlayerHands().get(1).size()-1));
		}
    }

    @FXML
    void stay() {
    	if(state == 0)
    	{
	    	System.out.println("stay");
	    	state = 1;
    	}
    	if(state == 1)
    	{
    		scoreGUI();
    	}
    }
    
    void scoreGUI()
    {
    	// after it is done
		if(state != 0)
		{
			System.out.println("You have made it to the here!");
			// TODO fill in the pseudo code
			// dealer adds cards if necessary
			// compare hands
			// declare winner, change label text
		}
		// restart. clear the table
		myCards.getChildren().clear();
		dealerCards.getChildren().clear();
		initialize();
    }
}

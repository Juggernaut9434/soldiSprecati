// Michael Mathews 2020
// Controller for the application

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.BlackJack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlackJackController {

	
	// fxml elements
	@FXML private Button HitBtn;
	@FXML private Button StayBtn;
	@FXML private Label MyScore, ResultLabel;
	@FXML private ImageView card1, card2;
	@FXML private ImageView card3, card4, card5, card6;
	@FXML private ImageView dealer1, dealer2;
	
	@FXML private URL location;
	@FXML private ResourceBundle resources;

	
	private BlackJack bj;
	
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
		/*
		this.bj = new BlackJack(2, 10, "Jerry");
		try {
			bj.addPlayer(new Gambler("Stacy"));
		} catch (InvalidLogicException e) {
			e.printStackTrace();
		}
		*/
	}
	
	@FXML
    void hit(ActionEvent event) {
		System.out.println("hit");
    }

    @FXML
    void stay(ActionEvent event) {
    	System.out.println("stay");
    }
}

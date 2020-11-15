// Michael Mathews, 2020
// BlackJack GUI, main function
// interacts with the fxml file

package gui;

import application.BlackJack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * How controllers work:
 * https://stackoverflow.com/questions/33881046/how-to-connect-fx-controller-with-main-app
 * https://examples.javacodegeeks.com/desktop-java/javafx/fxml/javafx-fxml-controller-example/
 */
public class BlackJackGUI extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// Create the FXML Loader
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BlackJackGUI.class.getResource("BlackJackModel.fxml"));
		// Create the Pane and all Details
		BorderPane root = loader.load();
		
		// Controller
		BlackJack bj = new BlackJack(2, 10, "Jerry");
		
		BlackJackController bjc = loader.getController();
		bjc.setGUI(this);
		
		// Create the Scene
		Scene scene = new Scene(root);
		// Set the Scene to Stage
		stage.setScene(scene);
		// Set Title to the Stage
		stage.setTitle("Soldi Sprecati");
		// display the stage
		stage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}

package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Foobar extends Application {
	public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) throws IOException
    {
        // Create the FXMLLoader 
    	FXMLLoader loader = new FXMLLoader();
    	// relative path from the current class location
    	loader.setLocation(getClass().getResource("../gui/PokerUI.fxml"));
    	Parent root = loader.load(); 
 
        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A simple FXML Example");
        // Display the Stage
        stage.show();
    }
}
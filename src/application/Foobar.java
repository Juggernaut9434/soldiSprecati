// Foobar.java
// Author: Mike Mathews 2020
// a testing class for applications


package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/* 
 * ONE AND DONE:
 * *************************************************
 * Installed JavaFX using openjfx.io
 * Extract to location well known
 * Added E(fx)clipse via Window > Eclipse Marketplace
 * Added JavaFX Lib to Window > Preferences > User Libraries
 * 		> add only the jars in javafxSDK/lib
 * Created Project > JavaFX > JavaFX Project
 * **************************************************
 * HAVE TO DO EACH TIME WHEN ADDED TO A NEW PROJECT
 * **************************************************
 *  * Project > Properties > Build Path > Class Path
 * 		> Add Library > User Library > JavaFX (user lib)
 * ** Run Configs **
 * Run Configuration > Arguments Tab > VM Arguments
 * 		--module-path="path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml
 * For my computer use
 * --module-path="C:\Program Files\Java\JavaFX\javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml
 * Add an application.css to the file location as well
 */
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
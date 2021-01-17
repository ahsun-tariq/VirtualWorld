package assignment2.pack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;


//Class implements the user interface
public class VirtualWorld extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Create an object of Action Handler to communicate with the interface
		ActionHandler handler = new ActionHandler();

		// The design is separate from Action Handler
		// Load the FXML design created in Scene Builder
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"interface.fxml"));
		// Bind the interface with Action Handler
		loader.setController(handler);
		Parent root = loader.load();
		Scene mainScene = new Scene(root);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Virtual World");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// Launch the application
		launch(args);
	}

}

package assignment2.pack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox  {

	
	
	public static void displayMsg(String title, String errorMessage){

		
		Stage msg = new Stage();
		Button button = new Button("OK");
		button.setOnAction(e -> msg.close());
		msg.initModality(Modality.APPLICATION_MODAL);
		msg.setTitle(title);
		msg.setMinWidth(250);
		
		Label message = new Label(errorMessage);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(message,button);
		vbox.setAlignment(Pos.CENTER);
		
		Scene messageScene = new Scene(vbox);
		msg.setScene(messageScene);
		msg.showAndWait();
		msg.setResizable(false);
		
		
		
		
	
		
	}
	
	
	
	
}

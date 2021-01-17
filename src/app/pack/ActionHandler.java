package assignment2.pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
//Author: Ahsun Tariq
//Version: 8.0
//Date: 15/11/2017
//Class implements event handling based on user action
//Implements the Initializable Interface

public class ActionHandler implements Initializable {

	// Keeps track of current location,
	// Initialized to some location
	private String position = "RoomSouth1";

	private String nextPosition;

	// Create a controller object to interact with Action Handler
	Controller myController = new Controller(position);

	private Image picture;

	// Keep track of portable item by name and image
	private Image inventory;
	private String itemName;

	@FXML
	private AnchorPane window;
	@FXML
	private ImageView imageView1;
	@FXML
	private ImageView imageView2;
	@FXML
	private ImageView imageView3;
	@FXML
	private ChoiceBox itemBox = new ChoiceBox<String>();

	@FXML
	private ChoiceBox listBox = new ChoiceBox<String>();

	// ActionHandler::moveForward()
	// Post-condition: ON BUTTON CLICK Moves to the next forward position and
	// displays
	// the location view and portable objects(if present)
	// How: Passes the current position as String value to
	// Controller::moveForward()
	// to get the forward position for this location
	// if there is no forward position, an empty String value is returned
	// and a message box appears blocking further movement
	// If there is a portable Item at this location, it is stacked on the
	// imageView
	// arguments: n/a
	// returns: n/a
	public void moveForward() {

		nextPosition = position;
		position = myController.moveForward(position);
		if (position.equals("")) {
			System.out.println("you can not go this way");
			position = nextPosition;
			MessageBox.displayMsg("Can't go there.",
					"You can not go forward from here. Try turning around");
		}
		picture = myController.getCurrentView(position);
		imageView1.setImage(picture);
		this.setImage();
		System.out.println("you are at " + position);

	}

	// ActionHandler::turnRight
	// Post-condition: ON BUTTON CLICK Moves to the right position from the
	// current position and displays
	// the location view and portable objects(if present)
	// How: Passes the current position as String value to
	// myConroller::turnRight()
	// to get the right position for this location
	// If there is a portable Item at this location, it is stacked on imageView
	// arguments: n/a
	// returns: n/a
	public void turnRight() {
		position = myController.turnRight(position);
		picture = myController.getCurrentView(position);
		imageView1.setImage(picture);
		this.setImage();
		System.out.println("you are at " + position);
	}

	// ActionHandler::turnLeft
	// Post-condition: ON BUTTON CLICK Moves to the left position from the
	// current position
	// and displays the location view and portable objects(if present)
	// How: Passes the current position as String value to
	// myController::turnLeft()
	// to get the left position for this location
	// If there is a portable Item at this location, it is stacked on the image
	// view
	// arguments: n/a
	// returns: n/a
	public void turnLeft() {

		position = myController.turnLeft(position);
		picture = myController.getCurrentView(position);
		imageView1.setImage(picture);
		this.setImage();
		System.out.println("you are at " + position);
	}

	// ActionHandler::initialize()
	// Post-condition: The interface has been initialized
	// How: Sets the images for initial location by invoking
	// ActionHandler::setImage()
	// Sets items in the choiceBox for picking portable items
	// Sets the initial background for the scene.
	// returns: n/a
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		imageView1.setImage(myController.getCurrentView(position));
		itemBox.getItems().add("Pick");
		itemBox.getItems().add("Drop");
		listBox.getItems().add("iphone");
		listBox.getItems().add("laptop");
		listBox.setValue("iphone");
		itemBox.setValue("Drop");
		itemBox.setOnAction(e -> selectItem(itemBox));
		listBox.setOnAction(e -> getItem(listBox));

		BackgroundImage back = new BackgroundImage(new Image(
				"pictures/wood.png", 1000, 1000, false, false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		window.setBackground(new Background(back));
		this.setImage();
	}

	// ActionHandler::selectItem()
	// Post-condition: Select a portable item and perform an action(pick or
	// drop)
	// How: Obtains the String value from ChoiceBox and invokes
	// ActionHandler::portable(Item) for the corresponding imageView
	// arguments: the user action ChoiceBox (ChoiceBox<String>))
	// returns: n/a
	private void selectItem(ChoiceBox<String> itemBox) {
		this.getItem(listBox);
		String item = itemBox.getValue();
		if (itemName.equals("iphone"))
			this.portableItem(imageView2, item);
		else if (itemName.equals("laptop"))
			this.portableItem(imageView3, item);

	}

	// ActionHandler::getItem()
	// Post-condition: Get the selected portable item
	// How: get value from List
	// arguments: the item list ChoiceBox (ChoiceBox<String>))
	// returns: n/a
	private void getItem(ChoiceBox<String> List) {

		itemName = List.getValue();
	}

	// ActionHandler::portableItem()
	// Post-condition: Determines the location of a portable item
	// How: Receives action value from ComboBox
	// If "pick" is selected and the portable item is present at
	// that location (not null)
	// the item is removed from its ImageView and also removed from the current
	// location by calling Controller::setImage(position, null, itemName)

	// If "drop" is selected and item exists in inventory (inventory!=null)
	// the item is added to the current location by invoking
	// Controller::setImage(position, null, itemName)
	// the item is then removed from user's inventory (inventory = null)

	// If item is not present at current location, display a message
	// arguments: action(String), ImageView(javafx.scene.image.ImageView)
	// returns: n/a
	private void portableItem(ImageView imageView, String action) {

		if (action == "Pick" && action != "Drop"
				&& myController.getImage(position, itemName) != null) {
			System.out.println(action);
			listBox.setDisable(true);
			inventory = myController.getImage(position, itemName);
			myController.setImage(position, null, itemName);
			imageView.setImage(null);
		} else if (action == "Drop" && action != "Pick" && inventory != null) {
			Image img = inventory;
			listBox.setDisable(false);
			myController.setImage(position, img, itemName);
			imageView.setImage(img);
			inventory = null;

		} else {
			itemBox.setValue("Drop");
			if (action != "Drop")
				MessageBox.displayMsg("Invalid Action",
						"Item does not exist here."
								+ " Try finding it somewhere else!");

		}

	}

	// ActionHandler::setImage()
	// Post-condition: Sets the images for portable objects
	// How: Invokes Controller::getImage() to check if item exists at current
	// location.
	// if the item exists at current location, the ImageView is set to the
	// corresponding item.
	// (Considering two portable items here)
	// arguments: n/a
	// returns: n/a
	private void setImage() {

		this.getItem(listBox);
		imageView2.setImage(null);
		imageView3.setImage(null);
		if (myController.getImage(position, "iphone") != null)
			imageView2.setImage(myController.getImage(position, "iphone"));
		if (myController.getImage(position, "laptop") != null)
			imageView3.setImage(myController.getImage(position, "laptop"));

	}
}

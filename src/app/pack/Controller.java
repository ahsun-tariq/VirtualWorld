package assignment2.pack;

import com.ijp.json.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


//Class for interaction with the ActionHandler
//Use for determining the right,left,forward directions
//Author: Ahsun Tariq
//Version: 8.0
//Date: 15/11/2017
public class Controller {

	// holds current location name
	private String location;

	// holds the current location
	private Location current_location;

	// Create a Map
	private WorldMap world = new WorldMap();

	// Controller::Constructor
	// Post-condition: Sets the initial location.
	// How: sets location name to the string parameter and invokes
	// WorldMap::getLocation()
	public Controller(String loc) {
		location = loc;
		current_location = world.getLocation(location);

	}

	// Controller::moveForward()
	// Post-condition: The forward direction of the current location is
	// obtained.
	// How: Receives the location name as argument. Looks up the location by
	// invoking WorldMap::getLocation()
	// arguments: The name of the location (String)
	// returns: the forward location for current location (Location)
	public String moveForward(String loc) {
		location = loc;
		current_location = world.getLocation(location);
		location = current_location.getForward();
		return location;

	}

	// Controller::turnLeft()
	// Post-condition: The left direction of the current location is obtained.
	// How: Receives the location name as argument. Looks up the location by
	// invoking WorldMap::getLocation()
	// arguments: The name of the location (String)
	// returns: the left location for current location (Location)
	public String turnLeft(String loc) {
		location = loc;
		current_location = world.getLocation(location);
		location = current_location.getLeft();
		return location;

	}

	// Controller::turnRight()
	// Post-condition: The right direction of the current location is obtained.
	// How: Receives the location name as argument. Looks up the location by
	// invoking WorldMap::getLocation()
	// arguments: The name of the location (String)
	// returns: the right location for current location (Location)
	public String turnRight(String loc) {
		location = loc;
		current_location = world.getLocation(location);
		location = current_location.getRight();
		return location;

	}

	// Controller::getImage()
	// Post-condition: The portable item at the current location is obtained
	// How: Receives the location and item names as arguments.
	// Looks up the location by invoking WorldMap::getLocation()
	// and finds the portable in HashMap by its name at that location
	// arguments: The name of the location (String), name of item(String)
	// returns: The image of the portable object(javafx.scene.image.Image)
	public Image getImage(String loc, String ItemName) {
		current_location = world.getLocation(loc);
		Image img = current_location.getItem(ItemName);
		return img;
	}

	// Controller::setImage()
	// Post-condition: Puts the portable object at a location
	// How: Receives the location name, image and item name as arguments,
	// looks up the location by invoking WorldMap::getLocation() and sets the
	// image for
	// the respective portable item
	// arguments: location name(String), item name(String), item
	// image(javafx.scene.image.Image)
	// returns: n/a
	public void setImage(String loc, Image img, String ItemName) {
		current_location = world.getLocation(loc);
		current_location.setItem(img, ItemName);

	}

	// Controller::getCurrentView()
	// Post-condition: Obtain the image for the current location
	// How: Receives the location name as argument,
	// looks up the location by invoking WorldMap::getLocation() and find the
	// image for
	// the respective location
	// arguments: location name(String)
	// returns: Image(javafx.scene.image.Image)
	public Image getCurrentView(String loc) {
		current_location = world.getLocation(loc);
		return current_location.getView();
	}

}

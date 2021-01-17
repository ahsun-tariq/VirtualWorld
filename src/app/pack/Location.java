package assignment2.pack;

import java.util.HashMap;

import org.json.JSONObject;

import com.ijp.json.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Author: Ahsun Tariq
//Version: 8.0
//Date: 15/11/2017
public class Location {

	// pointer to current view (e.g RoomNorth1)
	private String current;

	// pointer to the left direction from this location
	private String left;

	// pointer to the right direction from this location
	private String right;

	// pointer to the forward direction
	private String forward;

	// The dictionary of Portable Objects at this location as String:Object
	private HashMap<String, PortableObject> Items = new HashMap<String, PortableObject>();

	JSONObject json_obj = utils.getObject("assets/pictures.json");

	// The view of this location
	private Image locationView;

	// Location::constructor
	// Post-condition: Creates a location object by the name passed as argument
	// arguments; the name of the location (String: e.g RoomEast1)
	public Location(String place) {

		current = place;
		locationView = new Image(json_obj.getString(place));
	}

	// Location::setDirections
	// Post-condition: The directions from the current location are set
	// How: Assigns location names which are pointers to left, right and forward
	// arguments: the location names for right, left and forward directions
	// (String)
	// returns: n/a
	public void setDirections(String rht, String lft, String fwd) {
		right = rht;
		left = lft;
		forward = fwd;
	}

	// Location::getLeft()
	// Post-condition: Obtain the left location from this location
	// How: return the string value of left
	// arguments: n/a
	// returns: left(String)
	public String getLeft() {

		return left;
	}

	// Location::getRight()
	// Post-condition: Obtain the right location from this location
	// How: return the string value of right
	// arguments: n/a
	// returns: right(String)
	public String getRight() {

		return right;
	}

	// Location::getForward()
	// Post-condition: Obtain the forward location from this location
	// How: return the string value of forward
	// arguments: n/a
	// returns: forward(String)
	public String getForward() {

		return forward;
	}

	// Location::getCurrent()
	// Post-condition: Obtain the current location
	// How: return the current view pointer
	// arguments: n/a
	// returns: current(String)
	public String getCurrent() {
		return current;
	}

	// Location::getItem()
	// Post-condition: Obtain the portable item at this location by its name
	// How: Lookup the Portable Item in HashMap. Return the image of item if
	// found
	// arguments: Item name (String)
	// returns: Image of the portable item (javafx.scene.image.Image)
	public Image getItem(String Name) {
		if (Items.containsKey(Name))
			return Items.get(Name).getImage();
		else
			return null;
	}

	// Location::setItem()
	// Post-condition: Set the image for portable item at this location
	// How: Find the item in HashMap. Set the image for item using
	// PorableObject::setImage()
	// arguments: Image object for the portable item (javafx.scene.image.Image),
	// Name of Object(String)
	// returns: n/a
	public void setItem(Image img, String Name) {

		if (Items.containsKey(Name))
			Items.get(Name).setImage(img);
		else {

			PortableObject obj = new PortableObject(Name, null);
			obj.setImage(img);
			Items.put(Name, obj);
		}

	}

	// Location::setPortableItem()
	// Post-condition: Put a portable object at this location
	// How: put object name and object as key:value in HashMap
	// arguments: item name(String), object(PortableObject)
	// returns: n/a
	public void setPortableItem(String itemName, PortableObject obj) {

		Items.put(itemName, obj);

	}

	// Location::getView()
	// Post-condition: Obtain the image for this location
	// How: return the image
	// arguments: n/a
	// returns: locationView(javafx.scene.image.Image)
	public Image getView() {
		return locationView;
	}
}

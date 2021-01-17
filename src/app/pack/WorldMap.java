package assignment2.pack;


import java.util.ArrayList;
import java.util.HashMap;



import com.ijp.json.utils;

import javafx.scene.image.Image;

//A World Map based on the logical relations between the locations
//Author: Ahsun Tariq
//Version: 8.0
//Date: 15/11/2017
public class WorldMap {

	// Store the location object and location name as Key-Value pairs in a
	// dictionary.
	// (look up the location from its name in the HashMap)
	HashMap<String, Location> LocationDictionary = new HashMap<String, Location>();

	

	//Create portable objects
	PortableObject phone = new PortableObject("iphone", new Image(
			"pictures/iphone.jpg"));
	PortableObject laptop = new PortableObject("laptop", new Image(
			"pictures/laptop.png"));
	
	
	
	//Create different locations and assign them names
	Location RoomNorth1 = new Location("RoomNorth1");
	Location RoomEast1 = new Location("RoomEast1");
	Location RoomWest1 = new Location("RoomWest1");
	Location RoomSouth1 = new Location("RoomSouth1");
	Location RoomNorth2 = new Location("RoomNorth2");
	Location RoomEast2 = new Location("RoomEast2");
	Location RoomWest2 = new Location("RoomWest2");
	Location RoomSouth2 = new Location("RoomSouth2");
	Location RoomNorth3 = new Location("RoomNorth3");
	Location RoomEast3 = new Location("RoomEast3");
	Location RoomWest3 = new Location("RoomWest3");
	Location RoomSouth3 = new Location("RoomSouth3");
	Location LoungeNorth1 = new Location("LoungeNorth1");
	Location LoungeEast1 = new Location("LoungeEast1");
	Location LoungeWest1 = new Location("LoungeWest1");
	Location LoungeSouth1 = new Location("LoungeSouth1");
	Location KitchenNorth1 = new Location("KitchenNorth1");
	Location KitchenEast1 = new Location("KitchenEast1");
	Location KitchenWest1 = new Location("KitchenWest1");
	Location KitchenSouth1 = new Location("KitchenSouth1");
	Location KitchenNorth2 = new Location("KitchenNorth2");
	Location KitchenEast2 = new Location("KitchenEast2");
	Location KitchenWest2 = new Location("KitchenWest2");
	Location KitchenSouth2 = new Location("KitchenSouth2");
	Location KitchenNorth3 = new Location("KitchenNorth3");
	Location KitchenEast3 = new Location("KitchenEast3");
	Location KitchenWest3 = new Location("KitchenWest3");
	Location KitchenSouth3 = new Location("KitchenSouth3");

	
	
	
	//WorldMap::Constructor
	// Post-condition: The constructor creates a dictionary of Location objects
	// as name(String): location(Location) pair
	// Also set the directions for Location object and put portable objects
	WorldMap() {

		LocationDictionary.put("RoomNorth1", RoomNorth1);
		LocationDictionary.put("RoomEast1", RoomEast1);
		LocationDictionary.put("RoomWest1", RoomWest1);
		LocationDictionary.put("RoomSouth1", RoomSouth1);
		LocationDictionary.put("RoomNorth2", RoomNorth2);
		LocationDictionary.put("RoomEast2", RoomEast2);
		LocationDictionary.put("RoomWest2", RoomWest2);
		LocationDictionary.put("RoomSouth2", RoomSouth2);
		LocationDictionary.put("RoomNorth3", RoomNorth3);
		LocationDictionary.put("RoomEast3", RoomEast3);
		LocationDictionary.put("RoomWest3", RoomWest3);
		LocationDictionary.put("RoomSouth3", RoomSouth3);

		LocationDictionary.put(LoungeNorth1.getCurrent(), LoungeNorth1);
		LocationDictionary.put(LoungeEast1.getCurrent(), LoungeEast1);
		LocationDictionary.put(LoungeWest1.getCurrent(), LoungeWest1);
		LocationDictionary.put(LoungeSouth1.getCurrent(), LoungeSouth1);
		LocationDictionary.put(KitchenNorth1.getCurrent(), KitchenNorth1);
		LocationDictionary.put(KitchenEast1.getCurrent(), KitchenEast1);
		LocationDictionary.put(KitchenWest1.getCurrent(), KitchenWest1);
		LocationDictionary.put(KitchenSouth1.getCurrent(), KitchenSouth1);
		LocationDictionary.put(KitchenNorth2.getCurrent(), KitchenNorth2);
		LocationDictionary.put(KitchenEast2.getCurrent(), KitchenEast2);
		LocationDictionary.put(KitchenWest2.getCurrent(), KitchenWest2);
		LocationDictionary.put(KitchenSouth2.getCurrent(), KitchenSouth2);
		LocationDictionary.put(KitchenNorth3.getCurrent(), KitchenNorth3);
		LocationDictionary.put(KitchenEast3.getCurrent(), KitchenEast3);
		LocationDictionary.put(KitchenWest3.getCurrent(), KitchenWest3);
		LocationDictionary.put(KitchenSouth3.getCurrent(), KitchenSouth3);

		RoomWest1.setPortableItem("laptop", laptop);
		RoomSouth1.setPortableItem("iphone", phone);
		
		
		
		// Post-condition: The Logical map has been created
		// Create directions to move between locations
		// How: Call Location::setDirection(Right, Left, Forward)for each location

		RoomNorth1.setDirections("RoomEast1", "RoomWest1", "RoomNorth2");
		RoomEast1.setDirections("RoomSouth1", "RoomNorth1", "");
		RoomWest1.setDirections("RoomNorth1", "RoomSouth1", "");
		RoomSouth1.setDirections("RoomWest1", "RoomEast1", "");
		RoomNorth2.setDirections("RoomEast2", "RoomWest2", "RoomNorth3");
		RoomEast2.setDirections("RoomSouth2", "RoomNorth2", "");
		RoomWest2.setDirections("RoomNorth2", "RoomSouth2", "");
		RoomSouth2.setDirections("RoomWest2", "RoomEast2", "RoomSouth1");
		RoomNorth3.setDirections("RoomEast3", "RoomWest3", "LoungeNorth1");
		RoomEast3.setDirections("RoomSouth3", "RoomNorth3", "");
		RoomWest3.setDirections("RoomNorth3", "RoomSouth3", "");
		RoomSouth3.setDirections("RoomWest3", "RoomEast3", "RoomSouth2");

		LoungeNorth1.setDirections("LoungeEast1", "LoungeWest1", "");
		LoungeEast1.setDirections("LoungeSouth1", "LoungeNorth1",
				"KitchenNorth1");
		LoungeWest1.setDirections("LoungeNorth1", "LoungeSouth1", "");
		LoungeSouth1.setDirections("LoungeWest1", "LoungeEast1", "RoomSouth3");

		KitchenNorth1.setDirections("KitchenEast1", "KitchenWest1",
				"KitchenNorth2");
		KitchenEast1.setDirections("KitchenSouth1", "KitchenNorth1", "");
		KitchenWest1.setDirections("KitchenNorth1", "KitchenSouth1", "");
		KitchenSouth1.setDirections("KitchenWest1", "KitchenEast1",
				"LoungeWest1");
		KitchenNorth2.setDirections("KitchenEast2", "KitchenWest2",
				"KitchenNorth3");
		KitchenEast2.setDirections("KitchenSouth2", "KitchenNorth2", "");
		KitchenWest2.setDirections("KitchenNorth2", "KitchenSouth2", "");
		KitchenSouth2.setDirections("KitchenWest2", "KitchenEast2",
				"KitchenSouth1");
		KitchenNorth3.setDirections("KitchenEast3", "KitchenWest3", "");
		KitchenEast3.setDirections("KitchenSouth3", "KicthenNorth3", "");
		KitchenWest3.setDirections("KitchenNorth3", "KitchenSouth3", "");
		KitchenSouth3.setDirections("KitchenWest3", "KitchenEast3",
				"KitchenSouth2");

	}

	// Post-condition: The location from the World Map has been obtained
	// How: Receives the location name as input and looks up the location for
	// that name in the Location Dictionary
	// arguments: The name of the location (String)
	// returns: The location (Location)
	public Location getLocation(String location) {

		return LocationDictionary.get(location);

	}

}

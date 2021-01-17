package assignment2.pack;

import javafx.scene.image.Image;


//Author: Ahsun Tariq
//Version: 8.0
//Date: 15/11/2017
public class PortableObject {

	String objName;
	Image objImage;

	// PortableObject:: Constructor
	// Post-condition: Creates a portable object assigning it a name and image
	// How: Sets name and image equal to the parameter
	PortableObject(String name, Image img) {
		objName = name;
		objImage = img;

	}

	// PortableObject:: getName()
	// Post-condition: Obtain the name of this object
	// How: return the object name
	// Returns: objName(String)
	public String getName() {
		return objName;
	}

	// PortableObject:: getImage()
	// Post-condition: Obtain the image of this object
	// How: return the image
	// Returns: objImage(javafx.scene.image.Image)
	public Image getImage() {
		return objImage;

	}

	// PortableObject:: setImage()
	// Post-condition: set the image of this object
	// How: set the image equal to the image received as argument
	// Returns: n/a
	public void setImage(Image img) {
		objImage = img;
	}

}

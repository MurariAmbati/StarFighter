import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.lang.Math;

// class creates a new alien enemy with a image change when hit by the bullet.
// ipmherits its properties and behaviors.
public class SuperAlien extends Alien {
	private boolean state; // Boolean variable to track the state of the super alien
	private Image image; // Image for the super alien

	// Constructor with x, y, width, height, and speed parameters
	public SuperAlien(int x, int y, int w, int h, int s) {
		super(x, y, w, h, s); // Call the superclass constructor with all parameters
		state = false; // Initialize the state of the super alien to false (not hit)
		try {
			// Load the super alien image
			URL url = getClass().getResource("superalien.jpg"); // Get the URL of the super alien image
			image = ImageIO.read(url); // Read the image from the URL
		} catch (Exception e) {
			// Handle exceptions if the image loading fails
			// Feel free to add error handling here
		}
	}

	// Method to update the state of the super alien when hit
	public void ifHit() {
		state = true; // Set the state of the super alien to true (hit)
		try {
			// Load the injured super alien image
			URL url = getClass().getResource("injured.jpg"); // Get the URL of the injured super alien image
			image = ImageIO.read(url); // Read the image from the URL
		} catch (Exception e) {
			// Handle exceptions if the image loading fails
			// Feel free to add error handling here
		}
	}

	// Method to get the type of alien (SuperAlien)
	public int type() {
		return 2; // Return 2 to indicate that it's a super alien
	}

	// Method to get the state of the super alien
	public boolean getState() {
		return state; // Return the state of the super alien
	}

	// Draw the super alien on the graphics window
	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null); // Draw the super alien image at its position
	}
}

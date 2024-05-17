import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.lang.Math;

public class Alien extends MovingThing {
	private int speed; // Speed of the alien
	private Image image; // Image representing the alien

	// Default constructor
	public Alien() {
		this(0, 0, 30, 30, 0); // Call parameterized constructor with default values
	}

	// Constructor with initial position
	public Alien(int x, int y) {
		super(x, y); // Call superclass constructor to set position
		speed = 0; // Default speed
	}

	// Constructor with initial position and speed
	public Alien(int x, int y, int s) {
		super(x, y); // Call superclass constructor to set position
		speed = s; // Set the speed
	}

	// Constructor with detailed parameters
	public Alien(int x, int y, int w, int h, int s) {
		super(x, y, w, h); // Call superclass constructor to set position and dimensions
		speed = s; // Set the speed
		try {
			URL url = getClass().getResource("alien.jpg"); // Get the resource URL for the alien image
			image = ImageIO.read(url); // Read the image from the URL
		} catch(Exception e) {
			// Handle any exceptions that occur while loading the image
			// Feel free to add specific error handling here
		}
	}

	// Setter method for speed
	public void setSpeed(int s) {
		speed = s;
	}

	// Getter method for speed
	public int getSpeed() {
		return speed;
	}

	// Method to handle if the alien is hit by a bullet
	public void ifHit() {
		// Add code to handle if the alien is hit by a bullet
	}

	// Method to move the alien
	public void move(String direction) {
		// Add code to move the alien
		// Check if the alien is within the bounds of the screen
		// If the alien is out of bounds, change its speed direction and move it down a row
		// Constantly change the x position of the alien by the speed
		if(direction.equals("DOWN")) {
			super.setX(super.getX() + speed); // Move the alien horizontally by its speed
		}
		if(super.getX() > 775 || super.getX() < 0) { // Check if the alien is out of bounds horizontally
			speed *= -1; // Reverse the direction of the alien's movement
			super.setY(super.getY() + 40); // Move the alien down a row (40 pixels)
		}
	}

	// Method to get the type of the alien
	public int type() {
		return 1; // Return the type of the alien (for example, 1 for a regular alien)
	}

	// Method to get the state of the alien
	public boolean getState() {
		return true; // Return the state of the alien (for example, true if it's alive)
	}

	/* The draw method is done for you.
    This method will move the alien and update its location on screen by constantly redrawing it.
    */
	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null); // Draw the image of the alien on the graphics window
	}

	// Override toString method to provide a string representation of the Alien object
	public String toString() {
		return super.toString() + getSpeed(); // Return string representation including speed
	}
}

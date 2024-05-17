import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
//defines a graphical representation of a life in the game.
// It inherits from a class named MovingThing (not shown),
// which likely provides common functionalities for movable objects in the game.
public class Heart1 extends MovingThing {
	private int speed; // Speed of the heart
	private Image image; // Image for the heart
	private boolean isLife; // Flag to indicate if the heart represents a life

	// Constructor without parameters
	public Heart1() {
		this(0, 0, 30, 30, 0); // Call the constructor with default parameters
	}

	// Constructor with x and y coordinates
	public Heart1(int x, int y) {
		super(x, y); // Call the constructor of the superclass
		speed = 0; // Set speed to 0
	}

	// Constructor with x and y coordinates and speed
	public Heart1(int x, int y, int s) {
		super(x, y); // Call the constructor of the superclass
		speed = s; // Set the speed
	}

	// Constructor with x and y coordinates, width, height, and speed
	public Heart1(int x, int y, int w, int h, int s) {
		super(x, y, w, h); // Call the constructor of the superclass
		speed = s; // Set the speed
		isLife = true; // Initialize isLife to true, indicating the heart represents a life
		try {
			URL url = getClass().getResource("heart.jpg"); // Get the URL of the image
			image = ImageIO.read(url); // Read the image from the URL
		} catch (Exception e) {
			// Handle any exceptions that may occur when loading the image
			// Feel free to add error handling code here
		}
	}

	// Setter method for speed
	public void setSpeed(int s) {
		speed = s; // Set the speed
	}

	// Method to indicate that the heart represents a lost life
	public void lostLife() {
		isLife = false; // Set isLife to false
		try {
			URL url = getClass().getResource("Broken.jpg"); // Get the URL of the broken heart image
			image = ImageIO.read(url); // Read the image from the URL
		} catch (Exception e) {
			// Handle any exceptions that may occur when loading the image
			// Feel free to add error handling code here
		}
	}

	// Method to restore the heart to represent a life
	public void restore() {
		isLife = true; // Set isLife to true
		try {
			URL url = getClass().getResource("heart.jpg"); // Get the URL of the heart image
			image = ImageIO.read(url); // Read the image from the URL
		} catch (Exception e) {
			// Handle any exceptions that may occur when loading the image
			// Feel free to add error handling code here
		}
	}

	// Method to check if the heart represents a life
	public boolean ifLife() {
		return isLife; // Return the value of isLife
	}

	// Getter method for speed
	public int getSpeed() {
		return speed; // Return the speed
	}

	// Move method to animate the heart
	public void move(String direction) {
		if (direction.equals("DOWN")) { // If the direction is down
			super.setX(super.getX() + speed); // Move the heart horizontally
		}
		// Check if the heart is out of bounds
		if (super.getX() > 770 || super.getX() < 0) {
			speed *= -1; // Change the speed direction
			super.setY(super.getY() + 40); // Move the heart down a row
		}
	}

	// Draw method to draw the heart on the screen
	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null); // Draw the image on the screen
	}

	// Override the toString method to return a string representation of the heart
	public String toString() {
		return super.toString() + getSpeed(); // Return the string representation
	}
}

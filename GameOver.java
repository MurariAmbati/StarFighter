import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.lang.Math;

public class GameOver extends MovingThing {
	private int speed; // Speed of the game over message
	private Image image; // Image for the game over message

	// Constructor without parameters
	public GameOver() {
		this(0, 0, 30, 30); // Call the constructor with default parameters
	}

	// Constructor with x and y coordinates
	public GameOver(int x, int y) {
		super(x, y); // Call the constructor of the superclass
		speed = 0; // Set speed to 0
	}

	// Constructor with x and y coordinates and speed
	public GameOver(int x, int y, int s) {
		super(x, y); // Call the constructor of the superclass
		speed = s; // Set the speed
	}

	// Constructor with x and y coordinates, width, and height
	public GameOver(int x, int y, int w, int h) {
		super(x, y, w, h); // Call the constructor of the superclass
		speed = 0; // Set speed to 0
		try {
			URL url = getClass().getResource("GameOver.jpg"); // Get the URL of the image
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

	// Getter method for speed
	public int getSpeed() {
		return speed; // Return the speed
	}

	// Move method to animate the game over message
	public void move(String direction) {
		if (direction.equals("DOWN")) { // If the direction is down
			super.setX(super.getX() + speed); // Move the game over message horizontally
		}
		// Check if the game over message is out of bounds
		if (super.getX() > 770 || super.getX() < 0) {
			speed *= -1; // Change the speed direction
			super.setY(super.getY() + 40); // Move the game over message down a row
		}
	}

	// Draw method to draw the game over message on the screen
	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null); // Draw the image on the screen
	}

	// Override the toString method to return a string representation of the game over message
	public String toString() {
		return super.toString() + getSpeed(); // Return the string representation
	}
}

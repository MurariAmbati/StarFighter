import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

// provides functionalities for moving objects on the screen. foundation for all powerups in the game
public class PowerUp extends MovingThing {
	// Declare instance variables
	private int speed;
	private Image image;

	// Default constructor for PowerUp
	public PowerUp() {
		// Call the parameterized constructor with default values
		this(10, 10, 10, 10, 0);
	}

	// Constructor with x and y coordinates
	public PowerUp(int x, int y) {
		// Call the superclass constructor with provided x and y coordinates
		super(x, y);
		// Set default speed
		speed = 0;
	}

	// Constructor with x, y coordinates, and speed
	public PowerUp(int x, int y, int s) {
		// Call the superclass constructor with provided x and y coordinates
		super(x, y);
		// Set the speed
		speed = s;
	}

	// Constructor with x, y coordinates, width, height, and speed
	public PowerUp(int x, int y, int w, int h, int s) {
		// Call the superclass constructor with provided parameters
		super(x, y, w, h);
		// Set the speed
		speed = s;
		try {
			// Load the image for the PowerUp
			URL url = getClass().getResource("star.jpg");
			image = ImageIO.read(url);
		} catch (Exception e) {
			// Handle exceptions if image loading fails
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

	// Method to return the type of PowerUp
	public int type() {
		return 1;
	}

	// Method to draw the PowerUp on the graphics window
	public void draw(Graphics window) {
		// Draw the image of the PowerUp
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	// Method to move the PowerUp
	public void move(String direction) {
		// Move the PowerUp upward
		super.setY(super.getY() + speed);
	}

	// Method to represent the PowerUp as a string
	public String toString() {
		// Return a string representation of the PowerUp
		return super.toString() + getSpeed();
	}
}

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

// class represents a star power-up in the game.
// It inherits properties  from the PowerUp class, loads its image, defines its movement (upward),
// and provides methods to identify its type and draw it on the screen.
public class Star extends PowerUp {
	private Image image; // Image for the star

	// Default constructor
	public Star() {
		this(10, 10, 10, 10, 0); // Call the parameterized constructor with default values
	}

	// Constructor with x and y parameters
	public Star(int x, int y) {
		super(x, y); // Call the superclass constructor with x and y coordinates
	}

	// Constructor with x, y, and speed parameters
	public Star(int x, int y, int s) {
		super(x, y, s); // Call the superclass constructor with x, y, and speed parameters
	}

	// Constructor with x, y, width, height, and speed parameters
	public Star(int x, int y, int w, int h, int s) {
		super(x, y, w, h, s); // Call the superclass constructor with all parameters
		try {
			// Load the star image
			URL url = getClass().getResource("star.jpg"); // Get the URL of the star image
			image = ImageIO.read(url); // Read the image from the URL
		} catch (Exception e) {
			// Handle exceptions if the image loading fails
			e.printStackTrace();
		}
	}

	// Get the speed of the star
	public int getSpeed() {
		return super.getSpeed(); // Call the superclass method to get the speed
	}

	// Draw the star on the graphics window
	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null); // Draw the star image at its position
	}

	// Get the type of power-up (Star)
	public int type() {
		return 2; // Return 2 to indicate that it's a star power-up
	}

	// Move the star
	public void move(String direction) {
		super.setY(super.getY() + super.getSpeed()); // Move the star up (vertically) based on its speed
	}

	// Override the toString method to include information about the star
	public String toString() {
		return super.toString() + super.getSpeed(); // Return the string representation of the star including its speed
	}
}

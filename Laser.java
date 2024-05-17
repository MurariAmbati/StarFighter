import java.awt.Color; // Importing Color class from java.awt package for setting color
import java.awt.Graphics; // Importing Graphics class from java.awt package for drawing graphics
import java.awt.Image; // Importing Image class from java.awt package for working with images
import java.io.File; // Importing File class from java.io package for working with files
import javax.imageio.ImageIO; // Importing ImageIO class from javax.imageio package for reading and writing images

// Define the Laser class which extends MovingThing
public class Laser extends MovingThing
{
	private int speed; // Declare an integer variable 'speed' to store the speed of the laser

	// Constructors
	// Default constructor
	public Laser()
	{
		// Call the four-argument constructor with default values
		this(10, 10, 10, 10, 0);
	}

	// Constructor with x and y coordinates
	public Laser(int x, int y)
	{
		// Call the two-argument constructor with the specified x and y coordinates and default values for width, height, and speed
		super(x, y);
		speed = 0; // Set the speed to 0
	}

	// Constructor with x and y coordinates and speed
	public Laser(int x, int y, int s)
	{
		// Call the two-argument constructor with the specified x and y coordinates and default values for width and height
		super(x, y);
		speed = s; // Set the speed to the specified value
	}

	// Constructor with x and y coordinates, width, height, and speed
	public Laser(int x, int y, int w, int h, int s)
	{
		// Call the four-argument constructor with the specified parameters
		super(x, y, w, h);
		speed = s; // Set the speed to the specified value
	}

	// Setter method for the speed
	public void setSpeed(int s)
	{
		speed = s; // Set the speed to the specified value
	}

	// Getter method for the speed
	public int getSpeed()
	{
		return speed; // Return the speed of the laser
	}

	// Method to draw the laser
	public void draw(Graphics window)
	{
		// Set the color of the laser to red
		window.setColor(Color.RED);
		// Draw a filled rectangle representing the laser at its current position and size
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	// Method to move the laser
	public void move(String direction)
	{
		// Move the laser vertically according to its speed
		super.setY(super.getY() + speed);
	}

	// Override the toString method to return a string representation of the laser
	public String toString()
	{
		return super.toString() + getSpeed(); // Return a string representation of the laser's position and speed
	}
}

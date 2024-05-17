import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed; // Speed of the ammunition

	// Default constructor initializes ammunition with default parameters
	public Ammo()
	{
		this(10, 10, 10, 10, 0); // Calls the parameterized constructor with default values
	}

	// Constructo initializes ammunition with specified position and default speed
	public Ammo(int x, int y)
	{
		super(x, y); // Calls the constructor of the superclass with specified position
		speed = 0; // Sets the speed to default value
	}

	// Constructor initializes ammunition with specified position and speed
	public Ammo(int x, int y, int s)
	{
		super(x, y); // Calls the constructor of the superclass with specified position
		speed = s; // Sets the speed to the specified value
	}

	// Constructor initializes ammunition with specified position, size, and speed
	public Ammo(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h); // Calls the constructor of the superclass with specified position and size
		speed = s; // Sets the speed to the specified value
	}

	// Setter method to set the speed of the ammunition
	public void setSpeed(int s)
	{
		speed = s; // Sets the speed to the specified value
	}

	// Getter method to get the speed of the ammunition
	public int getSpeed()
	{
		return speed; // Returns the speed of the ammunition
	}

	// Method to draw the ammunition on the screen
	public void draw(Graphics window)
	{
		// Sets the color of the ammunition to yellow
		window.setColor(Color.YELLOW);
		// Fills a rectangle representing the ammunition with the specified position and size
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	// Method to move the ammunition
	public void move(String direction)
	{
		// Moves the ammunition upwards based on its speed
		super.setY(super.getY() - speed);
	}

	// Method to provide a string representation of the ammunition object
	public String toString()
	{
		// Returns a string containing information about the ammunition and its speed
		return super.toString() + getSpeed();
	}
}

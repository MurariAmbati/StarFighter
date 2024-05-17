import java.awt.Color; // Importing Color class from java.awt package for setting color
import java.awt.Graphics; // Importing Graphics class from java.awt package for drawing graphics
import java.awt.Image; // Importing Image class from java.awt package for working with images
import java.io.File; // Importing File class from java.io package for working with files
import javax.imageio.ImageIO; // Importing ImageIO class from javax.imageio package for reading and writing images
import java.util.ArrayList; // Importing ArrayList class from java.util package for dynamic arrays
import java.util.List; // Importing List interface from java.util package for representing ordered collections

// Define the Lasers class
public class Lasers
{
	private List<Laser> Laser; // Declare a list of Laser objects

	// Constructor
	public Lasers()
	{
		Laser = new ArrayList<Laser>(); // Initialize the list of lasers as an ArrayList
	}

	// Method to add a laser to the list
	public void add(Laser al)
	{
		Laser.add(al); // Add the specified laser to the list
	}

	// Method to draw all lasers in the list
	public void drawEmAll(Graphics window)
	{
		// Iterate through each laser in the list
		for(Laser a : Laser){
			a.draw(window); // Draw the laser using the specified graphics context
		}
	}

	// Method to move all lasers in the list
	public void moveEmAll()
	{
		// Iterate through each laser in the list
		for(Laser a : Laser){
			a.move("DOWN"); // Move the laser downwards
		}
	}

	// Method to remove lasers that have moved off the screen
	public void cleanEmUp()
	{
		// Iterate through the list of lasers in reverse order
		for(int i = Laser.size()-1; i > -1; i--){
			// If the laser's y-coordinate is greater than 600 (off the screen)
			if(Laser.get(i).getY() > 600){
				Laser.remove(i); // Remove the laser from the list
			}
		}
	}

	// Method to get the list of lasers
	public List<Laser> getList()
	{
		return Laser; // Return the list of lasers
	}

	// Override the toString method to return a string representation of the list of lasers
	public String toString()
	{
		return "" + Laser; // Return a string representation of the list of lasers
	}
}

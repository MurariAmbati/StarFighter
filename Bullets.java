import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo; // List to store ammunition objects

	// Constructor initializes the list of ammunition
	public Bullets()
	{
		ammo = new ArrayList<Ammo>(); // Creates a new ArrayList to store ammunition objects
	}

	// Method to add ammunition to the list
	public void add(Ammo al)
	{
		ammo.add(al); // Adds the specified ammunition object to the list
	}

	// Method to draw all ammunition objects in the list
	public void drawEmAll(Graphics window)
	{
		// Iterates through each ammunition object in the list
		for (Ammo a : ammo) {
			a.draw(window); // Draws the current ammunition object on the graphics window
		}
	}

	// Method to move all ammunition objects in the list
	public void moveEmAll()
	{
		// Iterates through each ammunition object in the list
		for (Ammo a : ammo) {
			a.move("UP"); // Moves the current ammunition object upwards
		}
	}

	// Method to remove ammunition objects that have moved off the screen
	public void cleanEmUp()
	{
		// Iterates through the list of ammunition objects in reverse order
		for (int i = ammo.size() - 1; i >= 0; i--) {
			// Checks if the current ammunition object's Y-coordinate is less than 0 (off the screen)
			if (ammo.get(i).getY() < 0) {
				ammo.remove(i); // Removes the current ammunition object from the list
			}
		}
	}

	// Method to get the list of ammunition objects
	public List<Ammo> getList()
	{
		return ammo; // Returns the list of ammunition objects
	}

	// Method to provide a string representation of the list of ammunition objects
	public String toString()
	{
		return "" + ammo; // Returns a string representation of the list of ammunition objects
	}
}

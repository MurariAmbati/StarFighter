import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Heart2
{
    private List<Heart1> Hearts; // List to store hearts
    private int lives; // Total number of lives
    private int hits; // Number of hits taken

    // Constructor to initialize hearts with a given size
    public Heart2(int size)
    {
        lives = size; // Set total lives
        hits = 0; // Initialize hits taken
        Hearts = new ArrayList<Heart1>(); // Initialize the list of hearts
        // Create and add hearts to the list
        for (int i = 0; i < size; i++) {
            Hearts.add(new Heart1(80 * i + 20, 10, 40, 40, 0));
        }
    }

    // Method to add a heart to the list
    public void add(Heart1 al)
    {
        Hearts.add(al);
    }

    // Method to restore a heart if it's lost
    public void restore()
    {
        boolean isAll = true; // Flag to check if all hearts are lost
        // Iterate through the hearts
        for (Heart1 ht : Hearts) {
            // If a heart is lost, restore it and set the flag to false
            if (!ht.ifLife()) {
                ht.restore();
                isAll = false;
                break;
            }
        }
        // If all hearts are lost, add a new heart
        if (isAll) {
            Heart1 al = Hearts.get(Hearts.size() - 1);
            Hearts.add(new Heart1(al.getX() + 80, 10, 40, 40, 0));
        }
        lives++; // Increment total lives
    }

    // Method to find the last broken heart
    public Heart1 findLastBroken()
    {
        // Iterate through hearts in reverse order
        for (int i = Hearts.size() - 1; i > -1; i--) {
            Heart1 ht = Hearts.get(i);
            // If a heart is not lost, return it
            if (ht.ifLife()) {
                return ht;
            }
        }
        return null; // Return null if no broken heart is found
    }

    // Method to draw all hearts
    public void drawEmAll(Graphics window)
    {
        // Draw all hearts in the list
        for (Heart1 al : Hearts) {
            al.draw(window);
        }
    }

    // Method to get the remaining lives
    public int getLives()
    {
        return lives - hits; // Calculate remaining lives by subtracting hits
    }

    // Method to remove a life
    public void removeLife()
    {
        hits++; // Increment hits
        findLastBroken().lostLife(); // Lose a life by marking the last broken heart
    }

    // Override the toString method to return a string representation of the list of hearts
    public String toString()
    {
        return "" + Hearts;
    }
}

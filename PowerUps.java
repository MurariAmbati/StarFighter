import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

//manager for all power-up objects in the game.
//  keeps track of them, updates their positions,
// and handles interactions with the ship.
public class PowerUps {
    // Declare a list to store PowerUp objects
    private List<PowerUp> PowerUps;

    // Constructor for PowerUps class
    public PowerUps() {
        // Initialize the list of PowerUps
        PowerUps = new ArrayList<PowerUp>();
    }

    // Method to add a PowerUp to the list
    public void add(PowerUp al) {
        PowerUps.add(al);
    }

    // Method to draw all PowerUps in the list
    public void drawEmAll(Graphics window) {
        for (PowerUp al : PowerUps) {
            al.draw(window);
        }
    }

    // Method to randomly select a PowerUp from the list
    public PowerUp getAl() {
        int i = (int) (Math.random() * PowerUps.size());
        return PowerUps.get(i);
    }

    // Method to move all PowerUps downward
    public void moveEmAll() {
        for (PowerUp al : PowerUps) {
            al.move("DOWN");
        }
    }

    // Method to remove PowerUps that have gone out of bounds
    public void cleanEmUp() {
        for (int i = PowerUps.size() - 1; i > -1; i--) {
            if (PowerUps.get(i).getY() > 600) {
                PowerUps.remove(i);
            }
        }
    }

    // Method to check if a ship has collected any PowerUps
    public int collect(Ship ship) {
        // Loop through each PowerUp in the list
        for (int i = PowerUps.size() - 1; i > -1; i--) {
            PowerUp al = PowerUps.get(i);
            // Check if the ship's coordinates are close to the PowerUp's coordinates
            if (Math.abs(al.getX() - ship.getX()) < 50 && Math.abs(al.getY() - ship.getY()) < 50) {
                // If the ship collects the PowerUp, remove it from the list and return its type
                return PowerUps.remove(i).type();
            }
        }
        // Return 0 if no PowerUp is collected
        return 0;
    }

    // Method to represent the PowerUps list as a string
    public String toString() {
        return "" + PowerUps;
    }
}

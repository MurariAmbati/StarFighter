import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde {
    private List<Alien> aliens; // List to store the aliens

    // Default constructor initializes the list of aliens
    public AlienHorde(){
        aliens = new ArrayList<Alien>();
    }

    // Constructor that generates a horde of aliens with specified size
    public AlienHorde(int size) {
        // Create the first alien and add it to the list
        // Loop to create and add more aliens with specified spacing
        aliens = new ArrayList<Alien>();
        for (int i = 0; i < size; i++){
            int R = 0;
            int X = i*75;
            // Adds a new row if greater than 725 (So aliens go down)
            while (X > 725) {
                R++;
                X -= 725;
            }
            int Y = 50+(R*75);

            aliens.add(new Alien(X,Y,30,30,1));
        }
    }
    public List<Alien> ifWon(){
        return aliens;
    }

    // Method to add an alien to the list
    public void add(Alien al) {
        System.out.println(al.getX() + "," + al.getY()); // Print the position of the alien
        aliens.add(al); // Add the alien to the list
    }

    // Method to check if any aliens have invaded the player's territory
    public boolean ifInvaded() {
        for (Alien al : aliens) {
            if (al.getY() > 600) { // If any alien has crossed the lower boundary
                return true; // Return true indicating invasion
            }
        }
        return false; // Return false if no alien has invaded
    }

    // Method to draw all aliens in the horde
    public void drawEmAll(Graphics window) {
        for (Alien al : aliens) {
            al.draw(window); // Draw each alien on the graphics window
        }
    }

    // Method to randomly select an alien from the horde
    public Alien getAl() {
        int i = (int) (Math.random() * aliens.size()); // Generate a random index within the range of the list
        return aliens.get(i); // Return the randomly selected alien
    }

    // Method to move all aliens in the horde downwards
    public void moveEmAll() {
        for (Alien al : aliens) {
            al.move("DOWN"); // Move each alien downwards
        }
    }

    // Method to remove aliens that have been hit by bullets
    public void removeDeadOnes(List<Ammo> shots) {
        boolean Status = false; // Flag to indicate if an alien is hit
        // Loop through all shots in the list
        for (int i = shots.size() - 1; i >= 0; i--) {
            // Loop through all aliens in the horde
            for (int j = 0; j < aliens.size(); j++) {
                // Check if the coordinates of the shot fall within the boundaries of the alien
                if (Math.abs(shots.get(i).getX() - aliens.get(j).getX()) < 50 &&
                        Math.abs(shots.get(i).getY() - aliens.get(j).getY()) < 50) {
                    Status = true; // Set the flag to true indicating the alien is hit
                    aliens.remove(j); // Remove the hit alien from the list
                    break; // Break out of the inner loop
                }
            }
            if (Status==true) {
                Status = false; // Reset the flag
                shots.remove(i); // Remove the shot from the list
            }
        }
    }

    // Method to check if the player has lost a life due to collision with aliens
    public int loseLife(Ship ship) {
        // Loop through all aliens in the horde
        for (int i = aliens.size() - 1; i >= 0; i--) {
            Alien al = aliens.get(i);
            // Check if the coordinates of the ship fall within the boundaries of any alien
            if (Math.abs(al.getX() - ship.getX()) < 50 && Math.abs(al.getY() - ship.getY()) < 50) {
                return -1; // Return -1 indicating the player has lost a life
            }
        }
        return 0; // Return 0 indicating no life lost
    }

    // Override toString method to provide a string representation of the AlienHorde object
    public String toString() {
        return "" + aliens; // Return a string representation of the list of aliens
    }
}

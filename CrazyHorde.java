import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class CrazyHorde extends AlienHorde {
  private List<Alien> aliens; // List to store aliens in the horde

  // Constructor to create a horde of aliens with a specified size
  public CrazyHorde(int size) {
    aliens = new ArrayList<Alien>(); // Initialize the list of aliens
    int col = 25; // Initial x-coordinate of the first alien
    int row = 50; // Initial y-coordinate of the first alien
    int speed = 3; // Speed of the aliens
    int j = 0; // Variable to determine the type of alien to create
    Alien al; // Temporary variable to hold created aliens
    al = new Alien(col, row, 30, 30, speed); // Create the first alien
    add(al); // Add the first alien to the horde
    for (int i = 1; i < size; i++) {
      // Check if the column is at the right edge of the screen, if so, move to the next row
      if (col == 775) {
        col = 25;
        row += 75;
      } else {
        col += 75; // Move to the next column
      }
      j = (int) (Math.random() * 2); // Randomly select 0 or 1 to determine the type of alien
      if (j == 0) {
        al = new Alien(col, row, 30, 30, speed); // Create a regular alien
        add(al); // Add the regular alien to the horde
      } else {
        al = new SuperAlien(col, row, 35, 35, speed+1); // Create a super alien
        add(al); // Add the super alien to the horde
      }
    }
  }

  // Check if the aliens have reached the bottom of the screen
  public boolean ifInvaded() {
    for (Alien al : aliens) {
      if (al.getY() > 600) { // Check if the y-coordinate of the alien is beyond the bottom of the screen
        return true; // Return true if at least one alien has reached the bottom
      }
    }
    return false; // Return false if no alien has reached the bottom
  }

  // Add an alien to the horde
  public void add(Alien al) {
    System.out.println(al.getX() + "," + al.getY()); // Print the coordinates of the added alien
    aliens.add(al); // Add the alien to the horde
  }

  // Get the list of aliens if the player wins
  public List<Alien> ifWon() {
    return aliens; // Return the list of aliens
  }

  // Draw all aliens in the horde
  public void drawEmAll(Graphics window) {
    for (Alien al : aliens) { // Iterate through each alien in the horde
      al.draw(window); // Draw the alien on the graphics window
    }
  }

  // Get a random alien from the horde
  public Alien getAl() {
    int i = (int) (Math.random() * aliens.size()); // Generate a random index within the size of the alien list
    return aliens.get(i); // Return the alien at the random index
  }

  // Move all aliens in the horde
  public void moveEmAll() {
    for (Alien al : aliens) { // Iterate through each alien in the horde
      al.move("DOWN"); // Move the alien downwards
    }
  }

  // Remove dead aliens that have been hit by shots
  public void removeDeadOnes(List<Ammo> shots) {
    boolean status = false; // Flag to indicate whether an alien has been hit
    for (int i = shots.size() - 1; i >= 0; i--) { // Iterate through each shot in reverse order
      for (int j = 0; j < aliens.size(); j++) { // Iterate through each alien
        // Check if the shot has hit the current alien
        if (Math.abs(shots.get(i).getX() - aliens.get(j).getX()) < 50
                && Math.abs(shots.get(i).getY() - aliens.get(j).getY()) < 50) {
          // Check if the alien is a special type (SuperAlien)
          if (aliens.get(j).type() == 1) {
            status = true; // Set the status flag to true
            aliens.remove(j); // Remove the alien from the horde
            break; // Exit the loop
          } else {
            // Check if the alien can take multiple hits
            if (aliens.get(j).getState()) {
              status = true; // Set the status flag to true
              aliens.remove(j); // Remove the alien from the horde
              break; // Exit the loop
            } else {
              // Alien can't be destroyed with a single shot, so just indicate that it has been hit
              aliens.get(j).ifHit(); // Indicate that the alien has been hit
              status = true; // Set the status flag to true
            }
          }
        }
      }
      // Remove the shot if it has hit an alien
      if (status) {
        status = false; // Reset the status flag
        shots.remove(i); // Remove the shot from the list of shots
      }
    }
  }

  // Check if the player's ship has been hit by an alien
  public int loseLife(Ship ship) {
    for (int i = aliens.size() - 1; i > -1; i--) { // Iterate through each alien in reverse order
      Alien al = aliens.get(i); // Get the current alien
      // Check if the alien has collided with the player's ship
      if (Math.abs(al.getX() - ship.getX()) < 50 && Math.abs(al.getY() - ship.getY()) < 50) {
        aliens.remove(i); // Remove the alien from the horde
        return -1; // Indicate that the player has lost a life
      }
    }
    return 0; // Return 0 if no life is lost
  }

  // Provide a string representation of the list of aliens
  public String toString() {
    return "" + aliens; // Return the string representation of the list of aliens
  }
}

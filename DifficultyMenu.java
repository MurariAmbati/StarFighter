// Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Define the DifficultyMenu class, which extends JFrame and implements ActionListener
public class DifficultyMenu extends JFrame implements ActionListener {
    // Declare instance variables for buttons
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;

    // Constructor for DifficultyMenu
    public DifficultyMenu() {
        // Set the title and close operation of the JFrame
        setTitle("Difficulty Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLayout(new GridLayout(3, 1)); // Set the layout to a 3x1 grid

        // Initialize buttons
        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");

        // Add action listeners to buttons
        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);

        // Add buttons to the frame
        add(easyButton);
        add(mediumButton);
        add(hardButton);

        setVisible(true); // Set the frame to be visible
    }

    // ActionListener interface method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Define a variable to store the selected difficulty
        String difficulty = "";

        // Check which button was clicked and set the difficulty accordingly
        if (e.getSource() == easyButton) {
            difficulty = "Easy";
        } else if (e.getSource() == mediumButton) {
            difficulty = "Medium";
        } else if (e.getSource() == hardButton) {
            difficulty = "Hard";
        }

        // Create an instance of the OuterSpace game with the selected difficulty
        OuterSpace game = new OuterSpace(difficulty);
        game.setFocusable(true); // Set the game to be focusable
        game.requestFocusInWindow(); // Request focus for the game
        game.setIgnoreRepaint(true); // Ignore repaint requests

        // Create a JFrame to hold the game
        JFrame frame = new JFrame("StarFighter Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(game); // Add the game to the content pane of the frame
        frame.setVisible(true); // Set the frame to be visible

        // Start the game in a new thread
        new Thread(game).start();

        // Close the menu window
        dispose();
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to create and show the DifficultyMenu. It performs tasks related to Swing/Thread
        SwingUtilities.invokeLater(() -> new DifficultyMenu());
    }
}

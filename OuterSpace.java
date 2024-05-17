import javax.sound.sampled.*; // Import classes for sound handling
import java.awt.Color; // Import the Color class for handling colors
import java.awt.Graphics; // Import the Graphics class for drawing
import java.awt.Graphics2D; // Import the Graphics2D class for advanced graphics operations
import java.awt.Canvas; // Import the Canvas class for drawing on
import java.awt.event.KeyListener; // Import classes for handling keyboard input events
import java.awt.event.KeyEvent; // Import classes for handling key events
import java.awt.image.BufferedImage; // Import the BufferedImage class for handling images
import java.io.IOException; // Import the IOException class for handling input/output exceptions
import java.net.URL; // Import the URL class for handling URLs

// is the core game class that manages the overall game loop, graphics rendering, and user input handling.
public class OuterSpace extends Canvas implements KeyListener, Runnable {
    // Declare instance variables for the game objects and properties
    private Ship ship;
    private boolean[] keys;
    private BufferedImage back;
    private Bullets bullets;
    private int shots;
    private GameOver end;
    private Heart2 hearts;
    private Alien alien;
    private Lasers lasers;
    private AlienHorde horde1;
    private PowerUps powerups;
    private int anInt1;
    private String state;
    private boolean status;
    private int flick;
    private boolean speedstat;
    private int STime;
    private Runnable gunSound;
    private Clip music1;
    private int anInt;
    private boolean winner;

    // Constructor for the OuterSpace class
    public OuterSpace(String difficulty) {
        // Initialize game properties and objects
        speedstat = false;
        STime = 0;
        anInt1 = 0;
        hearts = new Heart2(5);
        ship = new Ship(250, 250, 50, 50, 5);
        horde1 = new AlienHorde(20);
        powerups = new PowerUps();
        bullets = new Bullets();
        lasers = new Lasers();
        anInt = 0;
        setBackground(Color.black);
        keys = new boolean[5];
        status = false;
        flick = 0;
        winner = false;


        // Add key listener and start a new thread for the game loop
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);

        // Set up sound effects
        gunSound = new Runnable() {
            public void run() {
                try {
                    playClip(this.getClass().getResource("starwars.wav"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // This code snippet plays background music in a Java application

        try {
            // Create a clip to hold the audio data
            Clip music1 = AudioSystem.getClip();

            // Specify the audio file to load (background.wav) which is assumed to be in the resources folder of the project
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("background.wav"));

            // Open the clip with the audio data from the input stream
            music1.open(inputStream);

            // Get the gain control to adjust the volume
            FloatControl gainControl = (FloatControl) music1.getControl(FloatControl.Type.MASTER_GAIN);

            // Reduce the volume by 20 decibels (logarithmic scale)
            gainControl.setValue(20f * (float) Math.log10(.2f));

            // Continuously loop the playback of the music
            music1.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            // Print any errors that occur while loading or playing the audio
            e.printStackTrace();
        }
    }

    // Constructor overload for the OuterSpace class
    public OuterSpace() {
        // Initialize game properties and objects
        speedstat = false;
        STime = 0;
        anInt1 = 0;
        hearts = new Heart2(5);
        ship = new Ship(250, 250, 50, 50, 5);
        horde1 = new AlienHorde(20);
        powerups = new PowerUps();
        bullets = new Bullets();
        lasers = new Lasers();
        anInt = 0;
        setBackground(Color.black);
        keys = new boolean[5];
        status = false;
        flick = 0;
        winner = false;
        //instantiate what you need as you need it (from global objects above)

        this.addKeyListener(this);
        new Thread(this).start();

        setVisible(true);
        gunSound = new Runnable() {
            public void run() {
                try {
                    playClip(this.getClass().getResource("starwars.wav"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        try {
            music1 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("background.wav"));
            music1.open(inputStream);
            FloatControl gainControl = (FloatControl) music1.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(.2f));
            music1.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update the graphics
    public void update(Graphics window) {
        paint(window);
    }

    // Paint method to render graphics
    public static void playClip(URL url) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    // Method to paint graphics
    // Method to paint graphics
    public void paint(Graphics window) {

        // Set up double buffering for smooth animation
        Graphics2D twoDGraph = (Graphics2D) window;

        // Take a snapshot of the current screen and save it as an image with the same width and height
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        // Create a graphics reference to the background image
        // Draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        // Set the background color of the graphics window
        graphToBack.setColor(Color.BLACK);
        // Fill the background with the set color
        graphToBack.fillRect(0, 0, getWidth(), getHeight());

        // Add code to move Ship, Alien, etc. (Part 1)
        if (hearts.getLives() > 0 || !(horde1.ifInvaded())) {
            // Move the ship left
            if (keys[0] == true) {
                ship.move("LEFT");
            }
            // Move the ship right
            if (keys[1] == true) {
                ship.move("RIGHT");
            }
            // Move the ship up
            if (keys[2] == true) {
                ship.move("UP");
            }
            // Move the ship down
            if (keys[3] == true) {
                ship.move("DOWN");
            }

            // Add code to fire a bullet (Part 3)
            if (keys[4] == true) {
                // Limit the firing rate of bullets
                if (shots % 40 == 0) {
                    // Create a new bullet and add it to the bullets list
                    bullets.add(new Ammo(ship.getX() + 25, ship.getY(), 10, 10, 5));
                    // Start a new thread to play the shooting sound
                    new Thread(gunSound).start();
                }
                // Increment the shots counter
                shots++;
            }
        } else {
            // Player has no lives left or aliens have invaded, so don't process movement or firing
        }

        // Add collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship (Part 3)
        horde1.removeDeadOnes(bullets.getList());
        // Check if the ship is hit by an alien
        if (horde1.loseLife(ship) == -1 && !(status) && !speedstat) {
            // Reduce ship's lives and set the status to true
            hearts.removeLife();
            status = true;
        }
        // Handle ship hit animation
        if (status) {
            flick++;
            if (flick % 2 == 0) {
                ship.change();
                ship.draw(graphToBack);
            } else {
                ship.change2();
                ship.draw(graphToBack);
            }
            // Reset ship's appearance after hit animation
            if (flick == 100) {
                status = false;
                flick = 0;
                ship.changeBack();
            }
        }
        // Handle power-up effects
        if (speedstat) {
            STime += 1;
            // Apply power-up effects (increased ship speed)
            if (STime == 0) {
                ship.upgrade();
            }
            // Reset power-up effects after duration
            if (STime == 500) {
                speedstat = false;
                STime = 0;
                ship.changeBack();
            }
        }
        // Collect power-ups
        anInt = powerups.collect(ship);
        if (anInt == 1) {
            hearts.restore();  // Restore lives
        }
        if (anInt == 2) {
            speedstat = true;   // Activate speed power-up
        }
        // Randomly generate alien lasers
        int check = (int) (Math.random() * 120);
        if (check == 10 && (hearts.getLives() > 0 || !(horde1.ifInvaded()))) {
            alien = horde1.getAl();
            lasers.add(new Laser(alien.getX(), alien.getY() - 10, 10, 10, 2));
        }
        // Randomly generate power
        // Randomly generate power-ups (continued)
        anInt1 = (int) (Math.random() * 500);
        if (anInt1 == 10 && (hearts.getLives() > 0 || !(horde1.ifInvaded()))) {
            alien = horde1.getAl();
            int ved = (int) (Math.random() * 2);
            if (ved == 0) {
                powerups.add(new PowerUp(alien.getX(), alien.getY() - 10, 30, 30, 2));  // Life power-up
            } else {
                powerups.add(new Star(alien.getX(), alien.getY() - 10, 30, 30, 4));  // Speed power-up
            }
        }
        // Perform ship collision detection with lasers if speed power-up is not active
        if (!speedstat) {
            if (ship.ifShot(lasers.getList(), hearts, graphToBack)) {
                status = true;  // Set ship hit status for animation
            }
        }
        // Draw game objects if the player has lives left and aliens have not invaded
        if (hearts.getLives() > 0 && !(horde1.ifInvaded())) {
            horde1.moveEmAll();  // Move all aliens
            bullets.moveEmAll();  // Move all bullets
            lasers.moveEmAll();   // Move all lasers
            powerups.drawEmAll(graphToBack);  // Draw all power-ups
            powerups.moveEmAll();  // Move all power-ups
        } else {
            // Display game over screen
            end = new GameOver(300, 200, 200, 200);
            end.draw(graphToBack);
        }
        hearts.drawEmAll(graphToBack);  // Draw all lives remaining
        bullets.cleanEmUp();  // Remove any unused bullets
        lasers.cleanEmUp();   // Remove any unused lasers
        bullets.drawEmAll(graphToBack);  // Draw all remaining bullets
        lasers.drawEmAll(graphToBack);   // Draw all remaining lasers
        horde1.drawEmAll(graphToBack);  // Draw all aliens
        ship.draw(graphToBack);       // Draw the ship

        // Draw the back buffer to the screen
        twoDGraph.drawImage(back, null, 0, 0);
        back = null;

        // Check if the player wins the game
        if (horde1.ifWon().size() == 0) {
            if (winner == false) {
                horde1 = new CrazyHorde(20);  // Create a new, harder horde
                winner = true;
            } else {
                // Display a message if the player wins the game
                System.out.println("You win!!!");
            }
        }
    }


    // Method to handle key press events
    public void keyPressed(KeyEvent e) {
        // Set corresponding key boolean to true when a key is pressed
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = true;
        }
        // Repaint the canvas to update graphics
        repaint();
    }

    // Method to handle key release events
    public void keyReleased(KeyEvent e) {
        // Set corresponding key boolean to false when a key is released
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Reset the shot counter when space key is released
            shots = 0;
            keys[4] = false;
        }
        // Repaint the canvas to update graphics
        repaint();
    }

    // Method to handle key typed events
    public void keyTyped(KeyEvent e) {
        // No code needed here
        // Method needs to be implemented because the class implements KeyListener
    }

    // Method to run the game loop
    public void run() {
        try {
            // Game loop
            while (true) {
                // Pause for a short time to control the game loop speed
                Thread.currentThread().sleep(5);
                // Repaint the canvas to update graphics
                repaint();
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}

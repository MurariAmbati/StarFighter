import java.awt.Color;
import java.awt.Graphics;

// Define the abstract class MovingThing which implements the Moveable interface
public abstract class MovingThing implements Moveable
{
    // Declare instance variables for x-coordinate, y-coordinate, width, and height
    private int x;
    private int y;
    private int w;
    private int h;

    // Constructor with no parameters
    public MovingThing()
    {
        // Call the four-parameter constructor with default values
        this(10, 10, 10, 10);
    }

    // Constructor with two parameters for initial x and y coordinates
    public MovingThing(int x, int y)
    {
        // Set the x and y coordinates and default values for width and height
        this.x = x;
        this.y = y;
        this.w = 50;
        this.h = 50;
    }

    // Constructor with four parameters for x, y, width, and height
    public MovingThing(int x, int y, int w, int h)
    {
        // Set the x, y, width, and height
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    // Implementation of the setPos method from the Moveable interface
    public void setPos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Implementation of the setX method from the Moveable interface
    public void setX(int x)
    {
        this.x = x;
    }

    // Implementation of the setY method from the Moveable interface
    public void setY(int y)
    {
        this.y = y;
    }

    // Implementation of the getX method from the Moveable interface
    public int getX()
    {
        return x;
    }

    // Implementation of the getY method from the Moveable interface
    public int getY()
    {
        return y;
    }

    // Implementation of the getWidth method from the Moveable interface
    public int getWidth()
    {
        return w;
    }

    // Implementation of the getHeight method from the Moveable interface
    public int getHeight()
    {
        return h;
    }

    // Implementation of the setWidth method from the Moveable interface
    public void setWidth(int w)
    {
        this.w = w;
    }

    // Implementation of the setHeight method from the Moveable interface
    public void setHeight(int h)
    {
        this.h = h;
    }

    // Abstract method for moving the object
    public abstract void move(String direction);

    // Abstract method for drawing the object using the Graphics object
    public abstract void draw(Graphics window);

    // Override the toString method to provide a string representation of the object's attributes
    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}

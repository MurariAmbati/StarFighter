import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.List;

//represents  ship in game
public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	public Ship()
	{
		this(0,0,50,50,0);
	}

	public Ship(int x, int y)
	{
		super(x,y);
	}

	public Ship(int x, int y, int s)
	{
		super(x,y);
		speed=s;
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x,y,w,h);
		speed=s;
		try
		{
			//this sets ship.jpg as the image for your ship
			//for this to work ship.jpg needs to be in the same folder as this .java file
			URL url = getClass().getResource("ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here or not
		}
	}

	public void change(){
		try
		{
			//this sets ship.jpg as the image for your ship
			//for this to work ship.jpg needs to be in the same folder as this .java file
			URL url = getClass().getResource("black.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here or not
		}
	}
	public void change2(){
		try
		{
			//this sets ship.jpg as the image for your ship
			//for this to work ship.jpg needs to be in the same folder as this .java file
			URL url = getClass().getResource("flicker.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here or not
		}
	}
	public void changeBack(){
		try
		{
			//this sets ship.jpg as the image for your ship
			//for this to work ship.jpg needs to be in the same folder as this .java file
			URL url = getClass().getResource("ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here or not
		}
	}
	public void upgrade(){
		try
		{
			//this sets ship.jpg as the image for your ship
			//for this to work ship.jpg needs to be in the same folder as this .java file
			URL url = getClass().getResource("injured.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here or not
		}
	}
	public void setSpeed(int s)
	{
		speed=s;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void move(String direction)
	{
		//add code here
		//think about ALL your global variables and how you can use them to "move"
		//keep your parameter in mind as well
		if(direction.equals("LEFT")&&getX()>speed){
			super.setX(super.getX()-speed);
		}
		if(direction.equals("RIGHT")&&getX()<(750-speed)){
			super.setX(super.getX()+speed);
		}
		if(direction.equals("UP")&&getY()>speed){
			super.setY(super.getY()-speed);
		}
		if(direction.equals("DOWN")&&getY()<(500-speed)){
			super.setY(super.getY()+speed);
		}
	}
	public boolean ifShot(List<Laser> lasers, Heart2 hearts, Graphics window)
	{
		//Part 3
		//for every shot in the list
		//check if you've hit any alien in the list
		//(do the coordinates of the shot fall between the boundarises of the alien)
		//if they do then remove the alien and the shot
		//make sure you break out of the loop if this happens
		for(int j = lasers.size()-1; j>-1;j--){
			if(Math.abs(getX()-lasers.get(j).getX())<50&&Math.abs(getY()-lasers.get(j).getY())<50){
				lasers.remove(j);
				hearts.removeLife();
				return true;
			}
		}
		return false;
	}
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + " " + getSpeed();
	}
}
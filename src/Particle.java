import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Particle extends ImageIcon {
	
	private int x; 
	private int y; 
	final int WIDTH = 200; 
	final int HEIGHT = 200; 
	
	Particle(int x, int y, String file)
	{
		super(file);
		this.x = x; 
		this.y = y; 
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y; 
	}
	
	
	public void setX(int x)
	{
		this.x = x; 
	}
	
	public void setY(int y)
	{
		this.y = y; 
	}
	
	

}

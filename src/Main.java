import java.awt.*; 
import javax.swing.*;
import java.util.Arrays; 
public class Main {
	
	public static void main(String[] args)
	{
		JPanel pan = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(1000,800);
		frame.setVisible(true);
		pan.setBackground(Color.CYAN);
		// frame.add(pan);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Panel panel = new Panel();
		frame.add(panel);
		int x1;
		int x2; 
		int y1;
		int y2;
		panel.shuffle();
		panel.equals();
		while(true)
		{
			
			/* x1 = 0;
			x2 = 0; 
			y1 = 0;
			y2 = 0; */
			
			panel.setStatus(true);
			try 
			{
			panel.wait();
			
			}
			catch (Exception e)
			{}
		
			x1 = panel.getRow(); 
			y1 = panel.getColumn();
			
			
			
			
			panel.setStatus(true);
			try 
			{
			panel.wait();
			
			}
			catch (Exception e)
			{}
			x2 = panel.getRow(); 	
			y2 = panel.getColumn(); 
			
			
			Panel.swap(x1, y1, x2, y2);
			panel.repaint();
			/*
			
		
			*/
			
			
		}
		
		
	}

}

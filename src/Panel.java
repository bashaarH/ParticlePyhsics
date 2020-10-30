import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class Panel extends JPanel {
	public static ImageIcon[][] particle = new ImageIcon[4][5];
	public static ImageIcon[][] part;
	private ClickHandler click = new ClickHandler();
	private Random rand = new Random(); 
	private boolean waiting = false; 

	Panel() {
		super();
		particle[0][0] = new Particle(0, 0, "Particles\\up.png");
		particle[0][1] = new Particle(0, 200, "Particles\\charm.png");
		particle[0][2] = new Particle(0, 400, "Particles\\top.png");
		particle[0][3] = new Particle(0, 600, "Particles\\gluon.png");
		particle[0][4] = new Particle(0, 800, "Particles\\Higgs Boson.png");
		particle[1][0] = new Particle(200, 0, "Particles\\down.png");
		particle[1][1] = new Particle(200, 200, "Particles\\strange.png");
		particle[1][2] = new Particle(200, 400, "Particles\\bottom.png");
		particle[1][3] = new Particle(200, 600, "Particles\\photon.png");
		particle[1][4] = new Particle(200, 800, "Particles\\blank.png");
		particle[2][0] = new Particle(400, 0, "Particles\\electron.png");
		particle[2][1] = new Particle(400, 200, "Particles\\muon.png");
		particle[2][2] = new Particle(400, 400, "Particles\\tau.png");
		particle[2][3] = new Particle(400, 600, "Particles\\Z boson.png");
		particle[2][4] = new Particle(400, 800, "Particles\\blank.png");
		particle[3][0] = new Particle(600, 0, "Particles\\electron neutrino.png");
		particle[3][1] = new Particle(600, 200, "Particles\\muon neutrino.png");
		particle[3][2] = new Particle(600, 400, "Particles\\tau neutrino.png");
		particle[3][3] = new Particle(600, 600, "Particles\\W boson.png");
		particle[3][4] = new Particle(600, 800, "Particles\\blank.png");
		part = particle;
		for (int i = 0; i < 4; i++)
		{
			for (int n = 0; n < 5; n++)
			{
				part[i][n] = particle[i][n];
			}
		}
		this.setBackground(Color.GREEN);
		this.setSize(1000,800);
		shuffle();
		this.addMouseListener(click);
		// 
	}

	public void setStatus(boolean status)
	{
		waiting = status; 
	}
	public int getRow() {
		return click.getRow();
	}
	
	public int getColumn()
	{
		return click.getColumn(); 
	}
	
	public void paint(Graphics g)
	{
		// super.paint(graphics);
		Graphics2D graphicsContext = (Graphics2D) g; 
		//  graphicsContext.setColor(col);
	  //    graphicsContext.fill(new Rectangle(20, 20, 100, 100));
	    
	     // graphics.fillRect(100,200,200,100);
		// ImageIcon img = new ImageIcon("Images\\Test.Jpg");
		// g.drawImage(img.getImage(), 500,500, 400, 4000, null);
		// graphicsContext.drawImage(img.getImage(), 30, 50, 400, 4000, null);

		super.paint(g);
		for (int i = 0; i < 4; i++)
		{
			for (int n = 0; n < 5; n++)
			{
				g.drawImage(part[i][n].getImage(), n*200,
						i*200,200, 200, null);
				// System.out.println("HI");
			}
		}
	}
	
	public static void swap(int x1, int y1, int x2, int y2)
	{
		ImageIcon temp = part[x1][y1];
		part[x1][y1] = part[x2][y2];
		part[x2][y2] = temp; 
	}
	
	public boolean equals()
	{
		// System.out.println(Arrays.equals(part[0][0], particle[0][0]));
		return Arrays.equals(part, particle);
		
	}
	
	public void shuffle()
	{
		int r1 ;
		int r2;
		ImageIcon temp;
		for (int i = 0; i < 4; i++)
		{
			for (int n = 0; n < 5; n++)
			{
				r1  =(int) (rand.nextFloat() * 4);
				r2 = (int) (rand.nextFloat() *5);
				temp = part[i][n];
				part[i][n] = part[r1][r2];
				part[r1][r2] = temp; 
			}
		}
	}

	private class ClickHandler implements MouseListener {
		int column;
		int row;

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public synchronized void mousePressed(MouseEvent e) {
			row = (int) e.getY() / 200;
			column = (int) e.getX() / 200;
			if(waiting)	
				{
				notify();
				waiting = false; 
				}
			repaint();
			
		}

		public int getColumn() {
			return column;
		}

		public int getRow() {
			return row;
		}

		public void mouseReleased(MouseEvent e) {
		}
	}
}

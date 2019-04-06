package receivingServer;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.*;


public abstract class drawOnGraph extends JPanel implements ActionListener{
	  Timer t = new Timer (5, this);
	  double x = 0, y = 0;
	  double velX = 0, velY = 0;
	  
	  public void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D) g;
		  Ellipse2D circle  = new Ellipse2D.Double(x, y, 4, 4);
		  g2.fill(circle);
		  t.start();
		  
	  }
	  
	  public void setVelX(double vX) {
		velX =   vX;
	  }
	  
	  public void setVelY(double vY) {
			velY =   vY;
		  }
	  
}
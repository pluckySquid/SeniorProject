package localization;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;


public class drawOnGraph extends JPanel implements ActionListener{
	  Timer t = new Timer (10, this);
	  double x = 0, y = 0;
		  //double velX = 0, velY = 0;
	  
	  public void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D) g;
		  Ellipse2D circle  = new Ellipse2D.Double(x+500, y+300, 10, 10);
		  g2.fill(circle);
		  t.start();
		  
	  }
	  
	  public void actionPerformed(ActionEvent e) {
		  readFromDatabase currentLocation = new readFromDatabase();	
		  x = currentLocation.getDistanceX() ;
		  y = currentLocation.getDistanceY() ;
		  repaint();
	  }
	  
	 // public double getXLocation() {
		  //double Xlocation = currentLocation.getDistanceX();
		//return Xlocation;
	 // }
	  
//	  public double getYLocation() {
//		  double Ylocation = currentLocation.getDistanceY();
//		return Ylocation;
//	  }
//	  
//	  public static void getLoc() {
//			while(true) {
//			currentLocation.changeLocation();
//			}
//		}
	  
	  
	  
}
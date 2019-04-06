package localization;
import javax.swing.*;
import javax.swing.JFrame;


public class localization {
	public static void main(String[] args) {
		drawOnGraph s = new drawOnGraph();
		JFrame f = new JFrame();
		f.add(s);
		f.setVisible(true);
		f.setSize(1000, 600);
		f.setTitle("Moving human");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	
	
}

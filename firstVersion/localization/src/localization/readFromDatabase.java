package localization;
import java.sql.*;
import java.time.LocalTime;
import java.util.Calendar;



public class readFromDatabase {
	

	/**
	 * A Java MySQL PreparedStatement INSERT example.
	 * Demonstrates the use of a SQL INSERT statement against a
	 * MySQL database, called from a Java program, using a
	 * Java PreparedStatement.
	 * 
	 * Created by Alvin Alexander, http://alvinalexander.com
	 */
	  double distanceX = 0;
	  double distanceY = 0;
	  double vx = 0;
	  double vy = 0;
	  double ax=0;
	  double ay;
	  double az;
	  double deltaT;
	  double current;

	  public void changeLocation()
	  {
		  
	    try
	    {
	      
	      String myUrl = "jdbc:mysql://localhost:3306/accelerationdatabase";
	     
	      Connection conn = DriverManager.getConnection(myUrl, "root", "yunshu");
	      Statement myStmt = conn.createStatement();
	      
	      ResultSet myRs =  myStmt.executeQuery("select * from acc2");
	      //ax = myRs.getFloat("accx");
    	  //ay = myRs.getFloat("accy");
    	  //az = myRs.getFloat("accz");
	      myRs.next();
    	  double lastTime = myRs.getTimestamp("t").getTime();
	      current = lastTime;
	      while(myRs.next()) {
	    	  ax = myRs.getFloat("accx");
	    	  ay = myRs.getFloat("accy");
	    	  az = myRs.getFloat("accz");
	    	  current = myRs.getTimestamp("t").getTime();
	    	  if(current - lastTime < 500)
	    	  deltaT = (current - lastTime)/1000;
	    	  //System.out.println(deltaT);
	    	  //System.out.println(myRs.getTimestamp("t") +"    X: "+ ax + ", Y: " + ay + ", Z: " + az);
	    	  vx = velocityCalculation(vx, ax, deltaT);
	    	  vy = velocityCalculation(vy, ay, deltaT);
	    	  distanceX = distanceX+distanceCalculation(vx, deltaT, ax);
	    	  distanceY = distanceY +distanceCalculation(vy, deltaT, ay);
	    	  lastTime = current;
	      }
	      
	     
      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	    //this.distanceX = setDistanceX();
	    //this.distanceY = setDistanceY();
	    System.out.println("distance X is:  " + distanceX);
	      System.out.println("distance Y is:  " + distanceY);
	  }
	  
	  public double getDistanceX() {
		  distanceX = 0;
		  changeLocation();
		  return distanceX;
	  }
	  public double getDistanceY() {
		  distanceY = 0;
		  changeLocation();
		  return distanceY;
	  }
	  
	  
	  public double distanceCalculation(double v, double time, double acclerations) {
		  double distance = 0;
		  //double v = acclerations * time;
		 
		  distance = v * time + 0.5 * acclerations * time * time;
		  
		  return distance;
			
		}
	  
	  public double velocityCalculation(double v, double a, double t) {
		  return v + a*t;
	  }




	
	
	  
	 
}

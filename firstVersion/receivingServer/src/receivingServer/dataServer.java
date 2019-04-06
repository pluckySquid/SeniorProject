package receivingServer;
import java.beans.Statement;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.time.LocalTime;
import java.util.Calendar;

public class dataServer {

	// Unique User ID
	static int userID;
	
	// Accelerometer data
	static double accelerometer_x;
	static double accelerometer_y;
	static double accelerometer_z;

	// Geolocation data
	static Socket s;
	static ServerSocket ss;
	static InputStreamReader isr;
	static BufferedReader br;

	// Byte array for received data
	static byte[] receiveData = new byte[1024];

	public static void main(String[] args) throws Exception {
		getIPAddress();
		System.out.println("The connection is completed.");
		getAccelerometerData();
	}
	
	
	


	public static void getIPAddress() {
		System.out.println("welcome to the server");

		// Port Number
		try {
		ss =new ServerSocket(5110);
		
			System.out.println("The server port is 5110");

		s=ss.accept();
		System.out.println("The serversocket has been accepted, the message is:   ");
		isr = new InputStreamReader(s.getInputStream());
		br = new BufferedReader(isr);
		String message = br.readLine();
		System.out.println(message);
			ss.close();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getAccelerometerData() throws SQLException {
		

			try {
				
				ss =new ServerSocket(5110);
				System.out.println("The server port is 5110");

				while (true) {
					// Waits on welcoming socket for client to create contact
					s = ss.accept();
					System.out.println("socket has been accepted ");

					// Construct an object to process the HTTP request message
					isr = new InputStreamReader(s.getInputStream());
					br = new BufferedReader(isr);
					String message = br.readLine();
					System.out.println(message);
					//sendingDataToDatabase(message);
					//System.out.println("/////////////////////////////////////////");

				}

			} catch (IOException e) {
				e.printStackTrace();
			
		}
	}
	
	
	public static void sendingDataToDatabase(String data) throws SQLException {
		
		 String myUrl = "jdbc:mysql://127.0.0.1:3306/accelerationdatabase";
		 Connection conn = DriverManager.getConnection(myUrl, "root", "yunshu");
	      java.sql.Statement myStmt = conn.createStatement();
		String datas[] = data.split(", ");
		double xAcc = Double.parseDouble(datas[0]);
		double yAcc =  Double.parseDouble(datas[1]);
		double zAcc =  Double.parseDouble(datas[2]);
		java.sql.Timestamp time = java.sql.Timestamp.valueOf(datas[3]);
		String sql = "";
		sql = "insert into acc2 " + "(t, accx, accy, accz)" + "values ('"+time+"', " + xAcc + ", "+yAcc +", "+ zAcc +")";
        myStmt.execute(sql);
        //time = System.currentTimeMillis();
        //timestamp = new java.sql.Timestamp(time);
       // System.out.println(time);
		
		
	}
	
	
	
		
		
	
	
}
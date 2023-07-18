package connector;

import java.sql.*;				
import javax.swing.JOptionPane;


public class DBconnector {
	
	private static Connection conn=null;
	
	public static Connection getDatabaseConnection() {
		if(conn==null) {
			String url="jdbc:mysql://localhost:3306/practicedb";			
			try {
				conn=DriverManager.getConnection(url, "root", "Qwerty12345");
				if(conn !=null) {
					JOptionPane.showMessageDialog(null, "Connected to Local Server","JDBC Connection Status",JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

}

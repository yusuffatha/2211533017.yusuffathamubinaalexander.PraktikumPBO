package config;

import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseHelper {

	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/laundry_apps",
						"root", "");
			}
				return connection;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,  e);
			return null;
		}
	}

}

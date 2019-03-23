/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/library?useSSL=false";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";

	private static Connection conn;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.print("ok");
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.print("fail");
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static Connection getConnection() {
		return conn;
	}

	public static void main(String args[]) {
		getConnection();
	}
}

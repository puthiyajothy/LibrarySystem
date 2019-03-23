package com.srg.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.srg.model.Book;
import com.srg.model.Mainclassification;
import com.srg.model.Subclassification;

import ComUtil.DatabaseConnection;

public class MainclassificationDao {
	
		
		public static int saveclassification(Mainclassification mainclassification) throws ClassNotFoundException, SQLException {
			int status=0;
	        DatabaseConnection db = new DatabaseConnection();
	        Connection con = db.getConnection();
	        PreparedStatement statement;
	        

	        String insertclassification="INSERT INTO classification(mainID,mainclassificationname) VALUES (?,?)";
	        statement=con.prepareStatement(insertclassification);
	        
	        String mainID=mainclassification.getMainID();
	        String mainclassificationname=mainclassification.getMainclassificationname();
	        
	        
	        statement.setString(1, mainID);
	        statement.setString(2, mainclassificationname);
	        
	        status =statement.executeUpdate();
	        //DatabaseConnection.disconnection();
		 
	        return status;
		}
		
	
		
		public static ArrayList<Mainclassification> showmainclassification() {
			ArrayList<Mainclassification> result = new ArrayList<>();
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement statement;
			
			String showSQL = "SELECT * FROM classification";
			try {
				statement = con.prepareStatement(showSQL);
				ResultSet View = statement.executeQuery();

				while (View.next()) {
					Mainclassification mainclassification = new Mainclassification();
					mainclassification.setMainID(View.getString("mainID"));
					mainclassification.setMainclassificationname(View.getString("mainclassificationname"));
				
					result.add(mainclassification);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;

		}

		
public void mainclassificationdelete(String mainID) throws SQLException, ClassNotFoundException {
	        DatabaseConnection db = new DatabaseConnection();
	        Connection con =db.getConnection();
	        PreparedStatement statement;

	        String deleteSQL = "DELETE FROM classification WHERE mainID = ?";

	        statement = con.prepareStatement(deleteSQL);
	        statement.setString(1, mainID);
	        statement.executeUpdate();
	        //DatabaseConnection.disconnection();
	    }


public void updateMainclassification(Mainclassification mainclassification) {
			
		
	try {
		Connection con = DatabaseConnection.getConnection();
		String updateMainclassification = "UPDATE classification set mainID=? ,mainclassificationname=?,where mainID=?";
		PreparedStatement statement = con.prepareStatement(updateMainclassification);

		 String mainID=mainclassification.getMainID();
	     String mainclassificationname=mainclassification.getMainclassificationname();
	        
	        
	     statement.setString(1, mainID);
	     statement.setString(2, mainclassificationname);
	     statement.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}
		
	public static Mainclassification getRecordById(String mainID) {
	Mainclassification mainclassification = null;
	try {
		Connection con = DatabaseConnection.getConnection();
		String query = "select * from classification where mainID=?";
		PreparedStatement statement = con.prepareStatement(query);

		statement.setString(1, mainID);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			mainclassification = new Mainclassification();
			
			String MainID = rs.getString("mainID");
			String mainclassificationname = rs.getString("mainclassificationname");
			

			mainclassification.setMainID(mainID);
			mainclassification.setMainclassificationname(mainclassificationname);
	
			
		}
	} catch (SQLException ex) {
		Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
	}
	return mainclassification;
}
}


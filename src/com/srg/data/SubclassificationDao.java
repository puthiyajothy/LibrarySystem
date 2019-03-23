package com.srg.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.srg.model.Book;
import com.srg.model.Subclassification;

import ComUtil.DatabaseConnection;

public class SubclassificationDao {
	
	private static final String classificationID = null;

	public static int saveclassification(Subclassification subclassification) throws ClassNotFoundException, SQLException {
		int status=0;
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        PreparedStatement statement;
        
        
        
        String insertclassification="INSERT INTO subclassification(classificationid,classificationname,mainclassificationname) VALUES (?,?,?)";
        statement=con.prepareStatement(insertclassification);
        
        String classificationID=subclassification.getClassificationID();
        String classificationname=subclassification.getClassificationname();
        String mainclassificationname=subclassification.getMainclassificationname();

        
        
        
        statement.setString(1, classificationID);
        statement.setString(2, classificationname );
        statement.setString(3, mainclassificationname);
        
        status =statement.executeUpdate();
        //DatabaseConnection.disconnection();
	 
        return status;
	}
	
	public static ArrayList<Subclassification> showsubclassification() {
		ArrayList<Subclassification> result = new ArrayList<>();
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement statement;

		String showSQL = "SELECT * FROM subclassification";
		try {
			statement = con.prepareStatement(showSQL);
			ResultSet View = statement.executeQuery();

			while (View.next()) {
				Subclassification subclassification = new Subclassification();
				subclassification.setClassificationID(View.getString("classificationID"));
				subclassification.setClassificationname(View.getString("classificationname"));
				subclassification.setMainclassificationname(View.getString("mainclassificationname"));
				result.add(subclassification);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	
	}
	
	public void deletesubclassification(String classificationID) throws SQLException, ClassNotFoundException {
        DatabaseConnection db = new DatabaseConnection();
        Connection con =db.getConnection();
        PreparedStatement statement;

        String deleteSQL = "DELETE FROM subclassification WHERE classificationID = ?";

        statement = con.prepareStatement(deleteSQL);
        statement.setString(1, classificationID);
        statement.executeUpdate();
        //DatabaseConnection.disconnection();
    }
	
	
	
}

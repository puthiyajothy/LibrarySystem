/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srg.data;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.srg.model.Book;

import ComUtil.DatabaseConnection;

public class BookDao {
	

	public static boolean saveBook(Book book) {

		try {
			Connection con = DatabaseConnection.getConnection();
			String insertBook = "INSERT INTO book(bookId,booktitle,bookauthor,bookpublish,classification,subclassification) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(insertBook);

			String bookid = book.getBookId();
			String Booktitle = book.getBookTitle();
			String Bookauthor = book.getBookauthor();
			String Bookpublish = book.getBookpublish();
			String classification=book.getClassification();
			String subclassification=book.getSubclassification();

			statement.setString(1, bookid);
			statement.setString(2, Booktitle);
			statement.setString(3, Bookauthor);
			statement.setString(4, Bookpublish);
			statement.setString(5, classification);
			statement.setString(6, subclassification);
			if (statement.executeUpdate() > 0) {
				return true;
			}

			
		} catch (SQLException ex) {
			Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static ArrayList<Book> showBook() {
		ArrayList<Book> result = new ArrayList<>();
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement statement;

		String showSQL = "SELECT * FROM book";
		try {
			statement = con.prepareStatement(showSQL);
			ResultSet View = statement.executeQuery();

			while (View.next()) {
				Book book = new Book();
				book.setBookId(View.getString("bookId"));
				book.setBookTitle(View.getString("booktitle"));
				book.setBookauthor(View.getString("bookauthor"));
				book.setBookpublish(View.getString("bookpublish"));
				book.setClassification(View.getString("classification"));
				book.setSubclassification(View.getString("subclassification"));
				result.add(book);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
	

	public void deleteBook(String bookId) throws SQLException, ClassNotFoundException {
        //DatabaseConnection db = new DatabaseConnection();
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement statement;

        String deleteSQL = "DELETE FROM book WHERE bookId = ?";
       
        statement = con.prepareStatement(deleteSQL);
        statement.setString(1, bookId);
        statement.executeUpdate();
        //DatabaseConnection.disconnection();
    }
	
	public void updateBook(Book book) {

		try {
			Connection con = DatabaseConnection.getConnection();
			String updateBook = "UPDATE book set bookId=? ,booktitle=?,bookauthor=?,bookpublish=?,classification=?,subclassification=?where bookId=?";
			PreparedStatement statement = con.prepareStatement(updateBook);

			String bookid = book.getBookId();
			String Booktitle = book.getBookTitle();
			String Bookauthor = book.getBookauthor();
			String Bookpublish = book.getBookpublish();
			String classification=book.getClassification();
			String subclassification=book.getSubclassification();

			statement.setString(1, bookid);
			statement.setString(2, Booktitle);
			statement.setString(3, Bookauthor);
			statement.setString(4, Bookpublish);
			statement.setString(5, classification);
			statement.setString(6, subclassification);
			statement.setString(7, bookid);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static Book getRecordById(String bookId) {
		Book book = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			String query = "select * from book where bookId=?";
			PreparedStatement statement = con.prepareStatement(query);

			statement.setString(1, bookId);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				book = new Book();
				
				String bookid = rs.getString("bookId");
				String Booktitle = rs.getString("booktitle");
				String Bookauthor = rs.getString("bookauthor");
				String Bookpublish = rs.getString("bookpublish");
				String classification=rs.getString("classification");
				String subclassification=rs.getString("subclassification");
	
				book.setBookId(bookid);
				book.setBookTitle(Booktitle);
				book.setBookauthor(Bookauthor);
				book.setBookpublish(Bookpublish);
				book.setClassification(classification);
				book.setSubclassification(subclassification);
			}
		} catch (SQLException ex) {
			Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return book;
	}
	
}
		
	



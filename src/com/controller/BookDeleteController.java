package com.controller;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.BookDao;

public class BookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
	        String bookId = request.getParameter("deletebookId");
	        BookDao dao=new BookDao();
	        
				try {
					dao.deleteBook(bookId);
					RequestDispatcher dispatcher;
					request.setAttribute("booksList", BookDao.showBook());
			         dispatcher = request.getRequestDispatcher("./dash.jsp");
			         dispatcher.forward(request, response);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				 
			
	 }
}

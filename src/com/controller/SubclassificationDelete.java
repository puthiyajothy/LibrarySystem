package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.BookDao;
import com.srg.data.SubclassificationDao;

public class SubclassificationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
	        String classificationID = request.getParameter("classificationID");
	        SubclassificationDao dao=new SubclassificationDao();
	        
				try {
					dao.deletesubclassification(classificationID);
					RequestDispatcher dispatcher;
					request.setAttribute("SubclassificationList",SubclassificationDao.showsubclassification());
			         dispatcher = request.getRequestDispatcher("/subclassification");
			         dispatcher.forward(request, response);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				 
			
	 }
	
	

	
}



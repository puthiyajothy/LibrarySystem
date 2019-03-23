package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.MainclassificationDao;
import com.srg.data.SubclassificationDao;

public class MainclassificationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
		
	        String mainID = request.getParameter("mainID");
	        MainclassificationDao dao= new MainclassificationDao();
	        
				try {
					dao.mainclassificationdelete(mainID);
					RequestDispatcher dispatcher;
					request.setAttribute("Mainclassification", MainclassificationDao.showmainclassification());
			         dispatcher = request.getRequestDispatcher("/mainclassification");
			         dispatcher.forward(request, response);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				 
			
	 }
	
	
	
	

}

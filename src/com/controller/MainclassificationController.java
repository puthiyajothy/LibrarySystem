package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.BookDao;
import com.srg.data.MainclassificationDao;
import com.srg.data.SubclassificationDao;
import com.srg.model.Mainclassification;
import com.srg.model.Subclassification;

public class MainclassificationController extends HttpServlet {
		private static final long serialVersionUID = 1L; 
			
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
				
		try {
			String mainID = request.getParameter("mainID");
			String mainclassificationname = request.getParameter("mainclassificationname");
			
			Mainclassification mainclassification =new Mainclassification();
			mainclassification.setMainID(mainID);
			mainclassification.setMainclassificationname(mainclassificationname);
			
			
			MainclassificationDao.saveclassification(mainclassification);
			
			List<Mainclassification> mainclassificationList = MainclassificationDao.showmainclassification();

			RequestDispatcher dispatcher;
			 dispatcher = request.getRequestDispatcher("classificationview.jsp");
			 request.setAttribute("MinclassificationList", mainclassificationList);
			 dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		

		

		List<Mainclassification> mainclassificationList = MainclassificationDao.showmainclassification();

		RequestDispatcher dispatcher;
		 dispatcher = request.getRequestDispatcher("classificationview.jsp");
		 request.setAttribute("MinclassificationList", mainclassificationList);
		 dispatcher.forward(request, response);
	}
	
	 protected void doGet1(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
		
	        String mainID = request.getParameter("mainID");
	        MainclassificationDao dao= new MainclassificationDao();
	        
				try {
					dao.mainclassificationdelete(mainID);
					RequestDispatcher dispatcher;
					request.setAttribute("Mainclassification", MainclassificationDao.showmainclassification());
			         dispatcher = request.getRequestDispatcher("/classificationview.jsp");
			         dispatcher.forward(request, response);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			
	 }
	 } 
package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.srg.data.MainclassificationDao;
import com.srg.data.SubclassificationDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.model.Mainclassification;
import com.srg.model.Subclassification;



public class SubclassificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String classificationID = request.getParameter("classificationid");
			String classificationname = request.getParameter("classificationname");
			String mainclassificationname=request.getParameter("mainclassificationname");
		
			
			Subclassification subclassification =new Subclassification();
			subclassification.setClassificationID(classificationID);
			subclassification.setClassificationname(classificationname);
			subclassification.setMainclassificationname(mainclassificationname);
			
			SubclassificationDao.saveclassification(subclassification);
			List<Subclassification>subclassificationList= SubclassificationDao.showsubclassification();

			RequestDispatcher dispatcher;
			 dispatcher = request.getRequestDispatcher("subclassificationview.jsp");
			 request.setAttribute("SubclassificationList", subclassificationList);
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
	
		List<Subclassification>subclassificationList= SubclassificationDao.showsubclassification();
		RequestDispatcher dispatcher;
		 dispatcher = request.getRequestDispatcher("subclassificationview.jsp");
		 request.setAttribute("SubclassificationList", subclassificationList);
		 dispatcher.forward(request, response);
	}
	
	 protected void doGet1(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
		
		 	String classificationID =request.getParameter("classificationID");
	        SubclassificationDao dao= new SubclassificationDao();
	        
				try {
					dao.deletesubclassification(classificationID);
					RequestDispatcher dispatcher;
					request.setAttribute("subclassification", SubclassificationDao.showsubclassification());
			         dispatcher = request.getRequestDispatcher("classificationID.jsp");
			         dispatcher.forward(request, response);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
		
	}
}

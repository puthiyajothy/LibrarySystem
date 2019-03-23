package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.BookDao;
import com.srg.data.MainclassificationDao;
import com.srg.model.Book;
import com.srg.model.Mainclassification;

@WebServlet("/updatemainclass")
public class mainclasseditController  extends HttpServlet {  

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String mainID =request.getParameter("mainID");
		String mainclassificationname = request.getParameter("mainclassificationname");
		
		
		Mainclassification  mainclassification = new Mainclassification();
		mainclassification.setMainID(mainID);
		mainclassification.setMainclassificationname(mainclassificationname);

		
		MainclassificationDao  bd = new MainclassificationDao ();
		bd.updateMainclassification(mainclassification);
		request.setAttribute("MinclassificationList", MainclassificationDao.showmainclassification());
		RequestDispatcher dispatcher = request.getRequestDispatcher("classificationview.jsp");
		dispatcher.forward(request, response);
	}



}

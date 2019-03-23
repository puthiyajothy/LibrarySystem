/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.BookDao;

import com.srg.model.Book;

public class BookControllerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);
		Book book = new Book();
		book.setBookId(request.getParameter("bookid"));
		book.setBookTitle(request.getParameter("booktitle"));
		book.setBookauthor(request.getParameter("bookauthor"));
		book.setBookpublish(request.getParameter("bookpublish"));
		book.setClassification(request.getParameter("mainclassificationname"));
		book.setSubclassification(request.getParameter("subClassification"));

		
			if (BookDao.saveBook(book)) {
				request.setAttribute("booksList", BookDao.showBook());
				RequestDispatcher dispatcher = request.getRequestDispatcher("./dash.jsp");
				dispatcher.forward(request, response);
			}

		// processRequest(request, response);

	}

	
}

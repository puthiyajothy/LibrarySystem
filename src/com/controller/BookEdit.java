package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srg.data.BookDao;
import com.srg.model.Book;

@WebServlet("/updateBook")
public class BookEdit extends HttpServlet {  

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String bookId =request.getParameter("bookid");
		String bookTitle = request.getParameter("booktitle");
		String bookauthor = request.getParameter("bookauthor");
		String bookpublish = request.getParameter("bookpublish");
		String classification = request.getParameter("mainclassificationname");
		String subclassification =request.getParameter("subClassification");
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookTitle(bookTitle);
		book.setBookauthor(bookauthor);
		book.setBookpublish(bookpublish);
		book.setClassification(classification);
		book.setSubclassification(subclassification);
		
		BookDao bd = new BookDao();
		bd.updateBook(book);
		//response.sendRedirect("dash.jsp");
		request.setAttribute("booksList", BookDao.showBook());
		RequestDispatcher dispatcher = request.getRequestDispatcher("dash.jsp");
		dispatcher.forward(request, response);
	}

}



        
         



package org.elibrary.control;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elibrary.db.ObjectToTable;
import org.elibrary.doc.Author;
import org.elibrary.doc.Category;
import org.elibrary.doc.CategoryManager;
import org.elibrary.user.*;
/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Author newAuthor = new Author(request.getParameter("authName"), request.getParameter("authBio"));
		ObjectToTable ott = new ObjectToTable();
		ott.authorToTable(newAuthor);
		response.sendRedirect("uploadBook.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

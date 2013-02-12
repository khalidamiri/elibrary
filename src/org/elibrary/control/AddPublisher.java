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
import org.elibrary.doc.Category;
import org.elibrary.doc.CategoryManager;
import org.elibrary.doc.Publisher;
import org.elibrary.user.*;
/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddPublisher")
public class AddPublisher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPublisher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Publisher newPub = new Publisher();
		ObjectToTable ott = new ObjectToTable();
		newPub.setName(request.getParameter("pubName"));
		newPub.setDescription(request.getParameter("pubDesc"));
		ott.addCategory(newPub);
		response.sendRedirect("addAuthor.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

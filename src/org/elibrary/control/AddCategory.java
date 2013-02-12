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

import org.elibrary.doc.Category;
import org.elibrary.doc.CategoryManager;
import org.elibrary.user.*;
/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category newCategory = new Category();
		CategoryManager cm = new CategoryManager();
		newCategory.setName(request.getParameter("catName"));
		newCategory.setDescription(request.getParameter("catDesc"));
		System.out.println(newCategory.getName());
		cm.addCategory(newCategory);
		response.sendRedirect("addPublisher.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

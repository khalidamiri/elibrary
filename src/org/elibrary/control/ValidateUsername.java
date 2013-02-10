package org.elibrary.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elibrary.db.TableToObject;
import org.elibrary.user.UserManager;
import org.elibrary.user.UserManagerInterface;

/**
 * Servlet implementation class ValidateUsername
 */
@WebServlet("/ValidateUsername")
public class ValidateUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserManager um = new UserManager();
    /**
     * Default constructor. 
     */
    public ValidateUsername() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(um.validateUser(request.getParameter("userName")) == true)
			response.getWriter().write("true");
		else
			response.getWriter().write("false");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

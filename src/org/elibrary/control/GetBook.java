package org.elibrary.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.elibrary.doc.BookManager;

/**
 * Servlet implementation class GetBook
 */
@WebServlet("/GetBook")
public class GetBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BookManager bm = new BookManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Transfer-Encoding", "binary");

		/*		ServletContext ctx = getServletContext();

		int read = 0;
		byte[] bytes = new byte[1024];
*/
		byte[] pdf = bm.getBook(3).getPdf();
		OutputStream os = response.getOutputStream();
		IOUtils.write(pdf, os);

		os.flush();
		os.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Transfer-Encoding", "binary");

		/*		ServletContext ctx = getServletContext();

		int read = 0;
		byte[] bytes = new byte[1024];
*/
		byte[] pdf = bm.getBook(2).getPdf();
		OutputStream os = response.getOutputStream();
		IOUtils.write(pdf, os);

		os.flush();
		os.close();
	}

}

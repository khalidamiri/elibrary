package org.elibrary.control;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import org.elibrary.doc.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadDoc
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookManager bm = new BookManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Gets the book and its information from the book upload form, and converts is to a book object.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Add the validation part either in here or wherever its proper.
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		Book newBook = new Book();
		HashMap<String, String> bookFormData = new HashMap<String, String>();
		try {
			List reqItems = upload.parseRequest(request);
			Iterator iter = reqItems.iterator();
			while(iter.hasNext()){
				FileItem item = (FileItem) iter.next();
				if(item.isFormField()){
					bookFormData.put(item.getFieldName(), item.getString());
				}
				else{
					String fileName = item.getName();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					byte[] b = item.get();
					newBook.setPdf(b);
//					System.out.println("Following file uploaded: " + fileName + " : " + contentType + " : " + isInMemory);
				}
			}
			newBook.setTitle(bookFormData.get("title"));
			// TODO the author and publisher should return int not string from the form.
			newBook.setCategory(1);
			newBook.setPublisher(1);
			newBook.setUploadDate(new Date());
			newBook.setDescription(bookFormData.get("description"));
			newBook.setPrivacy(Privacy.PUBLIC);
			// TODO This should be userid not user, get the userid from session
			newBook.setUploader(null);
			newBook.setTags(bookFormData.get("tags"));
			bm.addBook(newBook);
			response.sendRedirect("viewBook.html");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

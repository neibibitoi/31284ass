package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsofttranslator.api.V2.TranslationClient;

import rest.client.ReviewClient;

/**
 * Servlet implementation class Review
 */
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String reviewXml = ReviewClient.fetchReviewInfo(Integer.parseInt(id));
		request.setAttribute("reviewXml", reviewXml);
	
		String[] lans = TranslationClient.getAllSupportLanguages();
		request.setAttribute("lans", lans);
		request.setAttribute("id", id);
			
		request.getRequestDispatcher("review.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

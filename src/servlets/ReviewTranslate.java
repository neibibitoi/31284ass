package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import com.microsofttranslator.api.V2.TranslationClient;

import soap.client.Review;
import soap.client.ReviewService;
import soap.client.ReviewServiceServiceLocator;

/**
 * Servlet implementation class ReviewTranslate
 */
public class ReviewTranslate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewTranslate() {
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
		String toLan = request.getParameter("toLan");

		ReviewServiceServiceLocator locator = new ReviewServiceServiceLocator();
		try {
			ReviewService reviewService = locator.getReviewServicePort();
			Review review = reviewService.getReviewById(Integer.parseInt(id));

			String[] translationResults = TranslationClient
					.translate(new String[] { review.getHeadline(), review.getDescription() }, toLan);

			
			request.setAttribute("review", review);
			request.setAttribute("toLan", toLan);
			request.setAttribute("translationResults", translationResults);
			request.getRequestDispatcher("reviewTranslation.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

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

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import soap.client.ReviewService;
import soap.client.ReviewServiceServiceLocator;

/**
 * Servlet implementation class OnDeleteReview
 */
public class OnDeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnDeleteReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String reviewId = request.getParameter("reviewId");

		// validate
		if (username.isEmpty()) {
			response.sendRedirect("Review?id=" + reviewId + "&errorMsg=" + "Username Cannot be Empty");
			return;
		}
		if (password.isEmpty()) {
			response.sendRedirect("Review?id=" + reviewId + "&errorMsg=" + "password Cannot be Empty");
			return;
		}

		// asking soap client to send request to soap service
		ReviewServiceServiceLocator locator = new ReviewServiceServiceLocator();
		ReviewService reviewService;
		try {
			reviewService = locator.getReviewServicePort();

			int deleteResult = reviewService.deleteReview(username, password, Integer.parseInt(reviewId));

			if (deleteResult == -1) {
				response.sendRedirect("Review?id=" + reviewId + "&errorMsg=" + "Login Fail");
				return;
			} else if (deleteResult == -2) {
				response.sendRedirect("Review?id=" + reviewId + "&errorMsg=" + "You are not the owner");
				return;
			} else {
				response.sendRedirect("result.jsp?msg=" + "Review " + reviewId + " is deleted successful");
				return;
			}

		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}

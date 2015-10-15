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
 * Servlet implementation class OnPostReview
 */
public class OnPostReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnPostReview() {
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

		String hotelId = request.getParameter("hotelId");
		String headline = request.getParameter("headline");
		String description = request.getParameter("description");
		String rating = request.getParameter("rating");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// validate
		if (username.isEmpty()) {
			response.sendRedirect("Hotel?id=" + hotelId + "&errorMsg=" + "Username Cannot be Empty");
			return;
		}
		if (password.isEmpty()) {
			response.sendRedirect("Hotel?id=" + hotelId + "&errorMsg=" + "password Cannot be Empty");
			return;
		}
		if (headline.isEmpty()) {
			response.sendRedirect("Hotel?id=" + hotelId + "&errorMsg=" + "headline Cannot be Empty");
			return;
		}
		if (description.isEmpty()) {
			response.sendRedirect("Hotel?id=" + hotelId + "&errorMsg=" + "description Cannot be Empty");
			return;
		}
		if (rating.isEmpty()) {
			response.sendRedirect("Hotel?id=" + hotelId + "&errorMsg=" + "rating Cannot be Empty");
			return;
		}

		// asking soap client to send request to soap service
		ReviewServiceServiceLocator locator = new ReviewServiceServiceLocator();
		ReviewService reviewService;
		try {
			reviewService = locator.getReviewServicePort();
			int newReviewId = reviewService.postReview(username, password, headline, description,
					Integer.parseInt(rating), Integer.parseInt(hotelId));
			
			if (newReviewId == -1) {
				response.sendRedirect("Hotel?id=" + hotelId + "&errorMsg=" + "Login Fail");
				return;
			} else {
				response.sendRedirect("Hotel?id=" + hotelId);
				return;
			}
			
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}

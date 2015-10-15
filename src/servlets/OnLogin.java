package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import soap.client.Author;
import soap.client.Review;
import soap.client.ReviewService;
import soap.client.ReviewServiceServiceLocator;

/**
 * Servlet implementation class OnLogin
 */
public class OnLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnLogin() {
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

		ReviewServiceServiceLocator locator = new ReviewServiceServiceLocator();
		ReviewService reviewService;
		try {
			reviewService = locator.getReviewServicePort();
			Author author = reviewService.login(username, password);
			if (author == null) {
				request.setAttribute("errorMsg", "Invalid Login");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			} else {
				request.getSession().setAttribute("loginAuthor", author);
				response.sendRedirect("Hotels");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}


		
	}

}

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rest.client.HotelClient;
import rest.client.ReviewClient;

/**
 * Servlet implementation class Hotel
 */
public class Hotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String hotelXml = HotelClient.fethHotelInfo(Integer.parseInt(id));
		String reviewsXml = ReviewClient.fethHotelReviews(Integer.parseInt(id));
		
		
		request.setAttribute("hotelXml", hotelXml);
		request.setAttribute("reviewsXml", reviewsXml);
		
		request.getRequestDispatcher("hotel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package soap;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import bean.Author;
import bean.Review;
import bean.Reviews;
import dao.AuthorDAO;
import dao.HotelDAO;
import dao.ReviewDAO;

@WebService
public class ReviewService {

	@Resource
	private WebServiceContext context;

	private void initXmlFile() {
		ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		synchronized (application) {
			ReviewDAO.setXMLFile(application.getRealPath("db/review.xml"));
			AuthorDAO.setXMLFile(application.getRealPath("db/author.xml"));
			HotelDAO.setXMLFile(application.getRealPath("db/hotel.xml"));
		}
	}

	@WebMethod
	public List<Review> getAllReviews(int hotelId) {
		initXmlFile();
		Reviews reviews = ReviewDAO.getAll();
		return reviews.getReviews();
	}
	
	@WebMethod
	public Review getReviewById(int reviewId) {
		initXmlFile();
		return ReviewDAO.getReviewById(reviewId);
	}

	@WebMethod
	public int postReview(String username, String password, String headline, String description, int rating,
			int hotelId) {
		initXmlFile();

		// authenication first
		Author author = AuthorDAO.getAuthorByUsernamePassword(username, password);
		if (author == null) {
			// login fail
			return -1;
		} else {
			Review review = new Review();
			review.setAuthorId(author.getId());
			review.setDescription(description);
			review.setHeadline(headline);
			review.setHotelId(hotelId);
			review.setRating(rating);
			review.setDate(new Date());
			ReviewDAO.addNewReview(review);
			return review.getId();
		}
	}

	@WebMethod
	public int deleteReview(String username, String password, int reviewId) {
		initXmlFile();
		// authenication first
		Author author = AuthorDAO.getAuthorByUsernamePassword(username, password);
		if (author == null) {
			// login fail
			return -1;
		} else {
			Review review = ReviewDAO.getReviewById(reviewId);
			// validate owner
			if (review.getAuthorId() != author.getId()) {
				// wrong owner
				return -2;
			} else {
				ReviewDAO.deleteReview(review);
				return 1;
			}
		}

	}

}

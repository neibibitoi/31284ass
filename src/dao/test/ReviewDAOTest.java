package dao.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import bean.Review;
import bean.Reviews;
import dao.ReviewDAO;

public class ReviewDAOTest {

	@Before
	public void setup() {
		// create a xml file first
		Reviews reviews = new Reviews();

		Review review = new Review();
		review.setAuthorId(1);
		review.setHotelId(1);
		review.setHeadline("headline 1");
		review.setDate(new Date());
		review.setRating(4);
		review.setDescription("description 1");
		review.setId(1);

		reviews.addReview(review);
		ReviewDAO.saveAll(reviews);
	}

	@Test
	public void testAddReview() {
		
		Review review = new Review();
		review.setAuthorId(1);
		review.setHotelId(1);
		review.setHeadline("headline 2");
		review.setDate(new Date());
		review.setRating(3);
		review.setDescription("description 2");
		
		ReviewDAO.addNewReview(review);
		assertEquals(2, ReviewDAO.getAll().getReviews().size());
	}

	
	@Test
	public void testDelReview() {
		Review review = new Review();
		review.setAuthorId(1);
		review.setHotelId(1);
		review.setHeadline("headline 2");
		review.setDate(new Date());
		review.setRating(3);
		review.setDescription("description 2");
		ReviewDAO.addNewReview(review);

		
		ReviewDAO.deleteReview(review);
		assertEquals(1, ReviewDAO.getAll().getReviews().size());
		assertEquals("headline 1", ReviewDAO.getAll().getReviews().get(0).getHeadline());
	}

}

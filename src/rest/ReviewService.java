package rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import bean.Hotel;
import bean.Review;
import bean.Reviews;
import dao.HotelDAO;
import dao.ReviewDAO;

@Path("/review")
public class ReviewService {

	@Context
	private ServletContext application;

	private void initReviewXmlFile() {
		synchronized (application) {
			ReviewDAO.setXMLFile(application.getRealPath("db/review.xml"));
		}
	}

	@Path("info")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Review getReviewById(@QueryParam("reviewId") int reviewId){
		initReviewXmlFile();
		return ReviewDAO.getReviewById(reviewId);
	}
	
	@Path("search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Reviews searchReviews(@QueryParam("hotelId") Integer hotelId, @QueryParam("startDate") String startDateStr,
			@QueryParam("endDate") String endDateStr, @QueryParam("starRating") Integer starRating) {

		initReviewXmlFile();

		Reviews reviews = ReviewDAO.getAll();
		Reviews resultReviews = new Reviews();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (hotelId == null) {
			throw new RuntimeException("No Hotel ID");
		}

		for (Review r : reviews.getReviews()) {

			if (r.getHotelId() != hotelId.intValue()) {
				continue;
			}

			if (startDateStr != null) {
				Date startDate;
				try {
					startDate = df.parse(startDateStr);
					if (r.getDate().compareTo(startDate) < 0) {
						continue;
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			if (endDateStr != null) {
				Date endDate;
				try {
					endDate = df.parse(endDateStr);
					if (r.getDate().compareTo(endDate) > 0) {
						continue;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			if (starRating != null) {
				if (r.getRating() != starRating.intValue()) {
					continue;
				}
			}

			resultReviews.addReview(r);
		}

		return resultReviews;
	}
}

package soap.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class SoapClientTest {

	public static void main(String[] args) throws ServiceException, RemoteException {
		ReviewServiceServiceLocator locator = new ReviewServiceServiceLocator();
		ReviewService reviewService = locator.getReviewServicePort();

		Review[] reviews = reviewService.getAllReviews(1);
		System.out.println(reviews.length);

		int newReviewId = reviewService.postReview("lee", "lee", "h", "d", 5, 1);
		System.out.println("newReviewId is" + newReviewId);

		reviews = reviewService.getAllReviews(1);
		System.out.println(reviews.length);

		int deleteResult = reviewService.deleteReview("lee", "lee", newReviewId);
		System.out.println("deleteResult is" + deleteResult);

		reviews = reviewService.getAllReviews(1);
		System.out.println(reviews.length);
		
//		reviewService.getReviewById(arg0);

	}

}

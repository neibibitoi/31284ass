package bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Reviews {
	private List<Review> reviews;

	public Reviews() {
		this.reviews = new ArrayList<Review>();
	}

	public List<Review> getReviews() {
		return reviews;
	}

	@XmlElementWrapper
	@XmlElement(name = "review")
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

}

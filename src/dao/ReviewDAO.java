package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bean.Review;
import bean.Reviews;

public class ReviewDAO {

	public static String XML_FILE = "WebContent/db/review.xml";

	public static void setXMLFile(String xml) {
		XML_FILE = xml;
	}

	public static void addNewReview(Review review) {
		review.setId(getLargestId() + 1);
		Reviews reviews = getAll();
		reviews.addReview(review);
		saveAll(reviews);
	}

	public static void deleteReview(Review review) {

		Reviews reviews = getAll();
		Iterator<Review> it = reviews.getReviews().iterator();
		// loop all the reviews in the file,
		// if we found one, delete it, and rewrite the xml file
		while (it.hasNext()) {
			Review a = it.next();
			if (a.getId() == review.getId()) {
				it.remove();
			}
		}
		saveAll(reviews);
	}

	public static Review getReviewById(int id) {
		Reviews reviews = getAll();
		for (Review review : reviews.getReviews()) {
			if (review.getId() == id) {
				return review;
			}
		}
		return null;
	}

	public static int getLargestId() {
		Reviews reviews = getAll();
		List<Review> reviewList = reviews.getReviews();

		if (reviewList.isEmpty()) {
			return 0;
		} else {
			return reviewList.get(reviewList.size() - 1).getId();
		}
	}

	public static void saveAll(Reviews reviews) {
		try {
			File file = new File(XML_FILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Reviews.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "review.xsd");
			jaxbMarshaller.marshal(reviews, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Reviews getAll() {
		Reviews reviews = new Reviews();

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Reviews.class);
			Unmarshaller u = jc.createUnmarshaller();

			// Now unmarshal the object from the file
			FileInputStream fin = new FileInputStream(XML_FILE);
			reviews = (Reviews) u.unmarshal(fin);

			fin.close();

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reviews;
	}

}

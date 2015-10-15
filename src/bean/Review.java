package bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "review")
public class Review implements Serializable {

	private int id;
	private String headline;
	private Date date;
	private int rating;
	private String description;
	private int hotelId;
	private int authorId;

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	@XmlElement
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public Date getDate() {
		return date;
	}

	@XmlElement
	public void setDate(Date date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	@XmlElement
	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public int getHotelId() {
		return hotelId;
	}

	@XmlElement
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getAuthorId() {
		return authorId;
	}

	@XmlElement
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

}

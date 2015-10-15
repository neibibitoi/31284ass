package bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Hotels {
	private List<Hotel> hotels;

	public Hotels() {
		this.hotels = new ArrayList<Hotel>();
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	@XmlElementWrapper
	@XmlElement(name = "hotel")
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public void addHotel(Hotel hotel) {
		this.hotels.add(hotel);
	}

}

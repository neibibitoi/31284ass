package dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bean.Hotel;
import bean.Hotels;
import dao.HotelDAO;

public class HotelDAOTest {

	@Before
	public void setup() {
		// create a xml file first
		Hotels hotels = new Hotels();
		Hotel hotel = new Hotel();
		hotel.setName("hotel 1");
		hotel.setCity("sydney");
		hotel.setCountry("AU");
		hotel.setId(1);

		hotels.addHotel(hotel);
		HotelDAO.saveAll(hotels);
	}

	@Test
	public void testAddHotel() {
		Hotel hotel = new Hotel();
		hotel.setName("hotel 2");
		hotel.setCity("mel");
		hotel.setCountry("AU");
		HotelDAO.addNewHotel(hotel);

		assertEquals(2, HotelDAO.getAll().getHotels().size());
	}

	
	@Test
	public void testDelHotel() {
		Hotel hotel = new Hotel();
		hotel.setName("hotel 2");
		hotel.setCity("mel");
		hotel.setCountry("AU");
		HotelDAO.addNewHotel(hotel);

		
		HotelDAO.deleteHotel(hotel);
		assertEquals(1, HotelDAO.getAll().getHotels().size());
		assertEquals("hotel 1", HotelDAO.getAll().getHotels().get(0).getName());
	}

}

package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import bean.Hotel;
import bean.Hotels;
import dao.HotelDAO;

@Path("/hotel")
public class HotelService {

	@Context
	private ServletContext application;

	private void initHotelXmlFile() {
		synchronized (application) {
			HotelDAO.setXMLFile(application.getRealPath("db/hotel.xml"));
		}
	}

	@Path("info")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Hotel getHotelById(@QueryParam("hotelId") int hotelId){
		initHotelXmlFile();
		return HotelDAO.getHotelById(hotelId);
	}
	
	
	@Path("search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Hotels searchHotels(@QueryParam("name") String name, @QueryParam("country") String country,
			@QueryParam("city") String city) {

		initHotelXmlFile();

		Hotels hotels = HotelDAO.getAll();
		Hotels resultHotels = new Hotels();

		for (Hotel h : hotels.getHotels()) {

			if (name != null) {
				if (!h.getName().toLowerCase().contains(name.toLowerCase())) {
					continue;
				}
			}

			if (country != null) {
				if (!h.getCountry().equalsIgnoreCase(country)) {
					continue;
				}
			}

			if (city != null) {
				if (!h.getCity().equalsIgnoreCase(city)) {
					continue;
				}
			}

			resultHotels.addHotel(h);
		}

		return resultHotels;
	}
}

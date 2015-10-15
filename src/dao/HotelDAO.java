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

import bean.Hotel;
import bean.Hotels;

public class HotelDAO {

	public static String XML_FILE = "WebContent/db/hotel.xml";

	public static void setXMLFile(String xml) {
		XML_FILE = xml;
	}

	public static void addNewHotel(Hotel hotel) {
		hotel.setId(getLargestId() + 1);
		Hotels hotels = getAll();
		hotels.addHotel(hotel);
		saveAll(hotels);
	}

	public static void deleteHotel(Hotel hotel) {

		Hotels hotels = getAll();
		Iterator<Hotel> it = hotels.getHotels().iterator();
		// loop all the hotels in the file,
		// if we found one, delete it, and rewrite the xml file
		while (it.hasNext()) {
			Hotel a = it.next();
			if (a.getId() == hotel.getId()) {
				it.remove();
			}
		}
		saveAll(hotels);
	}

	public static Hotel getHotelById(int id) {
		Hotels hotels = getAll();
		for (Hotel hotel : hotels.getHotels()) {
			if (hotel.getId() == id) {
				return hotel;
			}
		}
		return null;
	}

	public static int getLargestId() {
		Hotels hotels = getAll();
		List<Hotel> hotelList = hotels.getHotels();

		if (hotelList.isEmpty()) {
			return 0;
		} else {
			return hotelList.get(hotelList.size() - 1).getId();
		}
	}

	public static void saveAll(Hotels hotels) {
		try {
			File file = new File(XML_FILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Hotels.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "hotel.xsd");
			
			jaxbMarshaller.marshal(hotels, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Hotels getAll() {
		Hotels hotels = new Hotels();

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Hotels.class);
			Unmarshaller u = jc.createUnmarshaller();

			// Now unmarshal the object from the file
			FileInputStream fin = new FileInputStream(XML_FILE);
			hotels = (Hotels) u.unmarshal(fin);

			fin.close();

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return hotels;
	}

}

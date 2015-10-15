package bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hotel")
public class Hotel implements Serializable {

	private int id;
	private String name;
	private String city;
	private String country;
	private String address;
	private String telphone;
	private String email;

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	@XmlElement
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

}

package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class Authors implements Serializable {

	private List<Author> authors;

	public Authors() {
		authors = new ArrayList<Author>();
	}
	
	public List<Author> getAuthors() {
		return authors;
	}

	@XmlElementWrapper
	@XmlElement(name="author")
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	
	
}

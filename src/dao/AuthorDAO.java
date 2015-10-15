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

import bean.Author;
import bean.Authors;

public class AuthorDAO {

	public static String XML_FILE = "WebContent/db/author.xml";

	public static void setXMLFile(String xml) {
		XML_FILE = xml;
	}

	public static void addNewAuthor(Author author) {
		author.setId(getLargestId() + 1);
		Authors authors = getAll();
		authors.addAuthor(author);
		saveAll(authors);
	}

	public static void deleteAuthor(Author author) {

		Authors authors = getAll();
		Iterator<Author> it = authors.getAuthors().iterator();
		// loop all the authors in the file,
		// if we found one, delete it, and rewrite the xml file
		while (it.hasNext()) {
			Author a = it.next();
			if (a.getId() == author.getId()) {
				it.remove();
			}
		}
		saveAll(authors);
	}

	public static Author getAuthorById(int id) {
		Authors authors = getAll();
		for (Author author : authors.getAuthors()) {
			if (author.getId() == id) {
				return author;
			}
		}
		return null;
	}

	public static Author getAuthorByUsernamePassword(String username, String password) {
		Authors authors = getAll();
		for (Author author : authors.getAuthors()) {
			if (username.equals(author.getName()) && password.equals(author.getPassword())) {
				return author;
			}
		}
		return null;
	}

	public static int getLargestId() {
		Authors authors = getAll();
		List<Author> authorList = authors.getAuthors();

		if (authorList.isEmpty()) {
			return 0;
		} else {
			return authorList.get(authorList.size() - 1).getId();
		}
	}

	public static void saveAll(Authors authors) {
		try {
			File file = new File(XML_FILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Authors.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "author.xsd");
			jaxbMarshaller.marshal(authors, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Authors getAll() {
		Authors authors = new Authors();

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Authors.class);
			Unmarshaller u = jc.createUnmarshaller();

			// Now unmarshal the object from the file
			FileInputStream fin = new FileInputStream(XML_FILE);
			authors = (Authors) u.unmarshal(fin);

			fin.close();

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return authors;
	}

}

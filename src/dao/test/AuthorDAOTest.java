package dao.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bean.Author;
import bean.Authors;
import dao.AuthorDAO;

public class AuthorDAOTest {

	@Before
	public void setup(){
		// create a xml file first
		Authors authors = new Authors();
		Author author = new Author();
		author.setName("lee");
		author.setPassword("lee");
		author.setId(1);
		authors.addAuthor(author);
		AuthorDAO.saveAll(authors);
	}
	
	
	@Test
	public void testAddAuthor() {
		Author author = new Author();
		author.setName("kate");
		author.setPassword("kate");
		AuthorDAO.addNewAuthor(author);
		
		assertEquals(2, AuthorDAO.getAll().getAuthors().size());
		
	}

}

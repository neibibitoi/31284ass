package service;

import bean.Author;
import bean.Authors;
import dao.AuthorDAO;

public class AuthorService {

	/**
	 * if login success, should return author object if login faili, should
	 * return null
	 * 
	 * @param username
	 * @param passwrod
	 * @return
	 */
	public static Author login(String username, String password) {
		Authors allAuthors = AuthorDAO.getAll();
		for (Author a : allAuthors.getAuthors()) {
			if (a.getName().equals(username) && a.getPassword().equals(password)) {
				return a;
			}
		}
		return null;
	}
}

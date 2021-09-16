package book_application.dao;

import java.util.HashMap;
import java.util.Map;

import book_application.model.book;

public class book_api_daoimpl implements book_api_dao {
	int key = 100;
	
	HashMap<Integer, book> books = new HashMap<Integer, book>();
	
	@Override
	public int add_book(book book) {
		

		books.put(++key, book);

		return key;
	}

	@Override
	public book update_book(book book) {
		books.put(book.getIsbn(), book);
		return books.get(book.getIsbn());
	}

	@Override
	public void delete_book(int isbn) {
		
		books.remove(isbn);

	}

	@Override
	public book get_book(int isbn) {

		return books.get(isbn);
	}

	@Override
	public Map<Integer, book> getAllBook() {
		// TODO Auto-generated method stub
		return books;
	}

}

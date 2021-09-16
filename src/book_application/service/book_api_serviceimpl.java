package book_application.service;

import java.util.Map;

import book_application.dao.book_api_daoimpl;
import book_application.model.book;

public class book_api_serviceimpl implements book_api_service{
	
	book_api_daoimpl bookdao = new book_api_daoimpl();

	@Override
	public int add_book(book book) {
		
		return bookdao.add_book(book);
	}

	@Override
	public book update_book(book book) {
		
		return bookdao.update_book(book);
	}

	@Override
	public void delete_book(int isbn) {
		
		bookdao.delete_book(isbn);
		
	}

	@Override
	public book get_book(int isbn) {
		
		return bookdao.get_book(isbn);
	}

	@Override
	public Map<Integer, book> getAllBook() {
		
		return bookdao.getAllBook();
	}


}

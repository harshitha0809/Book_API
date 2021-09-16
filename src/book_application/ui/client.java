package book_application.ui;

import java.util.Iterator;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import exceptionPacakge.InvalidValueException;
import book_application.model.book;
import book_application.service.book_api_serviceimpl;

public class client {
	public static void main(String[] args) throws InvalidValueException {
		book_api_serviceimpl service = new book_api_serviceimpl();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("******************************************");
			String title = null;
			String author = null;
			int isbn = 0;
			while (true) {
				System.out.println("*****Book Application***");
				System.out.println("1.Add book");
				System.out.println("2.Update book");
				System.out.println("3.Delete book");
				System.out.println("4.Get book");
				System.out.println("5.Get All book");
				System.out.println("6.Buy book");
				
				int options = sc.nextInt();

				switch (options) {
				case 1:
					System.out.println("******************************************");
					System.out.println("Enter the book title: ");
					title = sc.next();
					System.out.println("Enter the author name : ");
					author = sc.next();
					book a = new book(title, author, 0);
					isbn = service.add_book(a);
					System.out.println("Book Added Successfully with id : " + isbn);
					System.out.println("******************************************");
					break;
				case 2:
					System.out.println("******************************************");
					System.out.println("Enter info to update the book");
					System.out.println("Enter the ISBN");
					isbn = sc.nextInt();
					System.out.println("Enter the book title : ");
					title = sc.next();
					System.out.println("Enter the author name: ");
					author = sc.next();
					book update_book = new book(title, author, isbn);
					book update_book1 = service.update_book(update_book);
					System.out.println("Book updated Successfully with id :" + update_book1);
					System.out.println("******************************************");
					break;
				case 3:
					System.out.println("******************************************");
					System.out.println("Enter ISBN :");
					isbn = sc.nextInt();
					try {
						if (isbn > 100) {
							service.delete_book(isbn);
							System.out.println("Book deleted Successfully with id : " + isbn);
						} else {
							throw new InvalidValueException("Invlaid ISBN");
						}
					} catch (InvalidValueException ex) {
						System.out.println("Invalid ISBN");
					}
					System.out.println("******************************************");
					break;
				case 4:
					System.out.println("******************************************");
					System.out.println("enter ISBN");
					isbn = sc.nextInt();
					try {
						if(isbn >100) {
							book book1 = service.get_book(isbn);
							System.out.println(book1);
						}
						else {
							throw new InvalidValueException("Invlaid ISBN");
						}
					} catch (InvalidValueException e) {
						System.out.println("Invalid ISBN");
					}
					System.out.println("******************************************");
					break;
				case 5:
					System.out.println("******************************************");
					Map<Integer, book> books = service.getAllBook();// entry
					Set<Integer> keys = books.keySet();
					Iterator<Integer> itr = keys.iterator();
					while (itr.hasNext()) {
						int key = itr.next();
						System.out.println("ISBN " + key + " " + books.get(key));
					}
					System.out.println("******************************************");
					break;
					
				case 6:
					System.out.println("******************************************");
					bookStore.display();
					
				default:
					System.out.println("Thank you for using Application");
					System.out.println("******************************************");
					System.exit(0);

					break;

				}
			}
		}
	}

}

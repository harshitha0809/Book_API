package book_application.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import exceptionPacakge.InvalidValueException;

import book_application.model.book;

public class bookStore {
	public static void display() throws InvalidValueException {
		double amount = 0.0;
		double sum = 0.0;
		int count = 1;

		List<book> list = new ArrayList<book>();

		try (Scanner scan = new Scanner(System.in)) {

			int menu = 0;
			System.out.println("Book Store");
			System.out.println();
			System.out.println("1. Buy book");
			System.out.println("2. Receipt");
			System.out.println("3. Receive Payment");
			System.out.println("4. Exit");
			boolean quit = false;
			do {
				if (count > 5) {
					System.out.println("You cannot buy more than 5 books at a time.");
				}
				System.out.print("Please enter your choice: ");
				menu = scan.nextInt();
				System.out.println();
				switch (menu) {
				case 1:
					System.out.println("******************************************");
					count++;
					System.out.println("Enter the Book Title: ");
					String booktitle = scan.next();
					System.out.println("Enter the Autho namer: ");
					String auth = scan.next();
					System.out.println("Enter the ISBN: ");
					int no = scan.nextInt();
					System.out.println("Enter the Price: ");
					double p = scan.nextDouble();
					try {
					if (p > 100) {
						
						System.out.println("Enter the Discount: ");
						double dis = scan.nextDouble();
						double total1 = p - (p * (dis / 100));
						list.add(new book(booktitle, auth, no, p, dis, total1));
					} else {
						throw new InvalidValueException("Invalid price");
					}
					}
					catch (InvalidValueException ex) { 
						
						System.out.println("Price of book must be greater than 100");
						System.out.println("******************************************");
					}
					break;
				case 2:
					System.out.println("******************************************");
					System.out.println("Title Author ISBN Price  Discount Total");

					for (book s1 : list) {
						System.out.println(s1.getTitle() + " " + s1.getAuthor() + " " + s1.getIsbn() + " "
								+ s1.getPrice() + " " + s1.getDiscount() + " " + s1.getTotal());
						sum += s1.getTotal();
					}

					System.out.println("Total= " + sum);
					System.out.println("******************************************");
					break;
				case 3:
					System.out.println("******************************************");
					System.out.println("Customer Pays: ");
					amount = scan.nextDouble();
					try {
					if (amount > 100) {
						double balance = amount - sum;
						System.out.println("Balance to be given: " + balance);
					} else {
						throw new InvalidValueException("Pay the required amount");
						
					}
					}catch (InvalidValueException e) {
						System.out.println("Pay the required amount");
					}
					quit = true;
					
				case 4:
					System.out.println("******************************************");
					quit = true;
					break;
				default:
					System.out.println("******************************************");
					System.out.println("Invalid Entry!");
				}
			} while (!quit);
		}
	}
}

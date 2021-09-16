package book_application.model;

public class book {
	private String title;
	private String author;
	private int isbn;
	public double price;
	public double discount;
	public double total;
	public book(String title, String author, int isbn, double price, double discount, double total) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.discount = discount;
		this.total = total;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public book() {
		
	}
	public book(String title, String author, int isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "book [title=" + title + ", author=" + author + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

}
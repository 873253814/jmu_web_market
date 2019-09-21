package jmu_web.market.order;

public class DetailOrder {
	private int count;
	private String isbn;
	private String title;
	private double price;
	
	public DetailOrder() {
		super();
	}
	
	public DetailOrder(int count, String isbn, String title, double price) {
		super();
		this.count = count;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "DetailOrder [count=" + count + ", isbn=" + isbn + ", title="
				+ title + ", price=" + price + "]";
	}
	
	
	
}

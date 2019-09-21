package jmu_web.market.cart;
public class Cart {
	private String userId;
	private String product;
	private String title;
	private String author;
	private float price;
	private String count;

	public Cart() {
		super();
	}
	
	public Cart(String userId,String product,String title,String author,float price,String count){
		super();
		this.userId = userId;
		this.product = product;
		this.title = title;
		this.author = author;
		this.price = price;
		this.count = count;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", product=" + product + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", count=" + count + "]";
	}

	
	
}

package jmu_web.market.collect;

public class Collect {
	private String userId;
	private String product;
	private String title;
	private float price;
	
	public Collect() {
		super();
	}
	
	public Collect(String userId,String product,String title,float price) {
		super();
		this.userId = userId;
		this.product = product;
		this.title = title;
		this.price = price;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Collect [userId=" + userId + ", product=" + product + ", title=" + title + ", price=" + price + "]";
	}
	
	
}

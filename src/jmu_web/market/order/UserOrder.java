package jmu_web.market.order;

public class UserOrder {
	private String orderId;
	private String product;
	private String placed;
	private String title;
	private String press;
	private float price;
	private int count;
	private float total;
	private String sta;
	
	public UserOrder() {
		super();
	}
	
	public UserOrder(String orderId,String product,String placed,String title,String press,float price,int count,float total,String sta) {
		this.orderId = orderId;
		this.product = product;
		this.placed = placed;
		this.title = title;
		this.press = press;
		this.price = price;
		this.count = count;
		this.total = total;
		this.sta = sta;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPlaced() {
		return placed;
	}

	public void setPlaced(String placed) {
		this.placed = placed;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	@Override
	public String toString() {
		return "UserOrder [orderId=" + orderId + ", product=" + product + ", placed=" + placed + ", title=" + title
				+ ", press=" + press + ", price=" + price + ", count=" + count + ", total=" + total + ", sta=" + sta
				+ "]";
	}
	
	
}

package jmu_web.market.order;

public class Order {
	private String userId;
	private String orderId;
	private String sta;
	private String addressId;
	private float payment;
	private String placed;
	
	public Order() {
		super();
	}
	
	public Order(String userId,String orderId,String sta,String addressId,float payment,String placed) {
		this.userId = userId;
		this.orderId = orderId;
		this.sta = sta;
		this.addressId = addressId;
		this.payment = payment;
		this.placed = placed;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}

	public String getPlaced() {
		return placed;
	}

	public void setPlaced(String placed) {
		this.placed = placed;
	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderId=" + orderId + ", sta=" + sta + ", addressId="
				+ addressId + ", payment=" + payment + ", placed=" + placed + "]";
	}
	
}

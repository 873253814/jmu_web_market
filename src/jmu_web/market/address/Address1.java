package jmu_web.market.address;

public class Address1 {
	private String user_id;
	private String address;
	private String added;
	private String receiver;
	private String receiver_phone;

	public Address1() {
		super();
	}

	public Address1(String user_id, String address, String added,
			String receiver, String receiver_phone) {
		super();
		this.user_id = user_id;
		this.address = address;
		this.added = added;
		this.receiver = receiver;
		this.receiver_phone = receiver_phone;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	@Override
	public String toString() {
		return "Address [user_id=" + user_id + ", address=" + address
				+ ", added=" + added + ", receiver=" + receiver
				+ ", receiver_phone=" + receiver_phone + "]";
	}
	
	
}

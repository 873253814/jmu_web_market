package jmu_web.market.address;

public class Address {
	private String rid;
	private String receiver;
	private String address;
	private String receiverPhone;
	
	public Address() {
		super();
	}
	
	public Address(String rid,String receiver,String address,String receiverPhone) {
		this.rid = rid;
		this.receiver = receiver;
		this.address = address;
		this.receiverPhone = receiverPhone;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Address [rid=" + rid + ", receiver=" + receiver + ", address=" + address + ", receiverPhone="
				+ receiverPhone + "]";
	}


	
}

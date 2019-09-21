package jmu_web.market.book.recommended;

public class Recommended {
	private String rid;
	private String product;
	private String title;
	public Recommended() {
		super();
	}
	
	public Recommended(String rid,String product,String title) {
		this.rid = rid;
		this.product = product;
		this.title = title;
	}

	public String getRid() {
		return rid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Recommended [rid=" + rid + ", product=" + product + ", title=" + title + "]";
	}
	
}

package jmu_web.market.book.entity;

public class SelectConditionBook {
	private String isbn;
	private String title;
	public SelectConditionBook() {
		super();
	}
	
	public SelectConditionBook(String isbn,String title) {
		this.isbn = isbn;
		this.title = title;
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

	@Override
	public String toString() {
		return "SelectConditionBook [isbn=" + isbn + ", title=" + title + "]";
	}
	
	
}

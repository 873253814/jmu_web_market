package jmu_web.market.book.entity;

import java.sql.Date;

public class Book {
	private String isbn;  //图书编号
	private String title; //标题（书名）
	private String author; // 作者
	private double price; //价格
	private String press;//出版社
	private int edtion;//版次
	private Date published;// 出版日期
	private int pages;//页数
	private int words;//字数
	private String packaging;//包装
	private String format;//开本
	private String form;//用纸
	
	public Book() {
		super();
	}

	public Book(String isbn, String title, String author, double price,
			String press, int edtion, Date published, int pages, int words,
			String packaging, String format, String form) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.press = press;
		this.edtion = edtion;
		this.published = published;
		this.pages = pages;
		this.words = words;
		this.packaging = packaging;
		this.format = format;
		this.form = form;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public int getEdtion() {
		return edtion;
	}

	public void setEdtion(int edtion) {
		this.edtion = edtion;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", press=" + press + ", edtion="
				+ edtion + ", published=" + published + ", pages=" + pages
				+ ", words=" + words + ", packaging=" + packaging + ", format="
				+ format + ", form=" + form + "]";
	}
	
	
}

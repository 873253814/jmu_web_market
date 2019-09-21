package jmu_web.market.book.dao;

import java.util.List;

import jmu_web.market.book.entity.Book;
import jmu_web.market.book.entity.SelectConditionBook;

public interface BookDAO {
	List<Book> getAll();
	List<Book> getBookByIsbn1(String isbn);
    int addBook(Book book);
    boolean updateBook(Book book);
    List<SelectConditionBook> SelectConditionBook(String condition);
    List<Book> getBookByTitle(String title);
	List<Book> getCondition(String title);
	Book getBookByIsbn(String isbn);
	
}

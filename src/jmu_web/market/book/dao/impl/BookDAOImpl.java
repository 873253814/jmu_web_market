package jmu_web.market.book.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmu_web.market.book.dao.BookDAO;
import jmu_web.market.book.entity.Book;
import jmu_web_market.utils.JdbcUtils;
import jmu_web.market.book.entity.SelectConditionBook;

public class BookDAOImpl extends JdbcUtils implements BookDAO {

	@Override
	public List<Book> getAll() {
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_book ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Book book = getBook(rs);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	private Book getBook(ResultSet rs) throws SQLException {
		String isbn = rs.getString(1);
		String title = rs.getString(2);
		String author = rs.getString(3);
		double price = rs.getDouble(4);
		String press = rs.getString(5);
		int edtion = rs.getInt(6);
		Date published = rs.getDate(7);
		int pages = rs.getInt(8);
		int words = rs.getInt(9);
		String packaging = rs.getString(10);
		String format = rs.getString(11);
		String form = rs.getString(12);
		
		Book book = new Book(isbn, title, author, price, press, edtion, published, pages, words, packaging, format, form);
		
		return book;
	}

	@Override
	public List<Book> getBookByIsbn1(String isbn) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_book where isbn = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			while(rs.next()){
				Book book = getBook(rs);
				list.add(book);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}

	
	@Override
	public List<Book> getBookByTitle(String title) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_book where title = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while(rs.next()){
				Book book = getBook(rs);
				list.add(book);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	@Override
	public int addBook(Book book) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_book values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getPress());
			ps.setInt(6, book.getEdtion());
			ps.setDate(7, book.getPublished());
			ps.setInt(8, book.getPages());
			ps.setInt(9, book.getWords());
			ps.setString(10, book.getPackaging());
			ps.setString(11, book.getFormat());
			ps.setString(12, book.getForm());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public boolean updateBook(Book book) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update tb_book title=?, author=?, price=?, press=?, edtion=?,"
				+"published=?, pages=?, words=?, packaging=?, format=?, form=?"
				+" where set isbn=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setDouble(3, book.getPrice());
			ps.setString(4, book.getPress());
			ps.setInt(5, book.getEdtion());
			ps.setDate(6, book.getPublished());
			ps.setInt(7, book.getPages());
			ps.setInt(8, book.getWords());
			ps.setString(9, book.getPackaging());
			ps.setString(10, book.getFormat());
			ps.setString(11, book.getForm());
			ps.setString(12, book.getIsbn());
			
			flag = ps.executeUpdate()>0 ? true:false;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return flag;
	}
	
	
	private SelectConditionBook getConditionBook(ResultSet rs) throws SQLException {
		String isbn = rs.getString(1);
		String title = rs.getString(2);
		
		SelectConditionBook cbook = new SelectConditionBook(isbn, title);
		
		return cbook;
	}

	@Override
	public List<SelectConditionBook> SelectConditionBook(String condition) {
		List<SelectConditionBook> list = new ArrayList<SelectConditionBook>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT isbn,title FROM tb_book WHERE title REGEXP ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, condition);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectConditionBook cbook = getConditionBook(rs);
				list.add(cbook);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	public List<Book> getCondition(String title) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_book where title REGEXP ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while(rs.next()){
				Book book = getBook(rs);
				list.add(book);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Book book = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_book where isbn = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			while(rs.next()){
				book = getBook(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return book;
	}
}

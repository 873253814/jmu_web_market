package jmu_web.market.cart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmu_web.market.cart.Cart;
import jmu_web.market.cart.dao.CartDAO;
import jmu_web_market.utils.JdbcUtils;

public class CartDAOImpl extends JdbcUtils implements CartDAO {

	@Override
	public List<Cart> getAll() {
		List<Cart> list = new ArrayList<Cart>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,product,title,author,price,count from tb_book,tb_cart_item where tb_book.isbn=tb_cart_item.product ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Cart cartBook = getCartBook(rs);
				list.add(cartBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	private Cart getCartBook(ResultSet rs) throws SQLException {
		String userId = rs.getString(1);
		String product = rs.getString(2);
		String title = rs.getString(3);
		String author = rs.getString(4);
		float price = rs.getFloat(5);
		String count = rs.getString(6);
		
		Cart cartBook = new Cart(userId, product, title, author, price, count);
		
		return cartBook;
	}

	@Override
	public List<Cart> getBookById(String userId) {
		List<Cart> list = new ArrayList<Cart>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,product,title,author,price,count from tb_book,tb_cart_item where tb_book.isbn=tb_cart_item.product and user_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				Cart cartBook = getCartBook(rs);
				list.add(cartBook);
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
	public int addCartBook(String userId, String product, int count) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_cart_item (user_id,product,count)values(?,?,?)";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2, product);
			ps.setInt(3, count);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}
	public boolean cartIsExisted(String userId, String product) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;
		String sql = "select * from tb_cart_item where user_id = ? and product = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, product);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = false;
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public int deleteCartBook(String userId,String product) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from tb_cart_item where user_id=? and product=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2, product);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public boolean updateCart(String userId, String product,int count) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update tb_cart_item set count=? where user_id=? and product=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,count );
			ps.setString(2, userId);
			ps.setString(3,product );
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return false;
	}

}

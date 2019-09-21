package jmu_web.market.collect.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmu_web.market.collect.Collect;
import jmu_web.market.collect.dao.CollectDAO;
import jmu_web_market.utils.JdbcUtils;

public class CollectDAOImpl extends JdbcUtils implements CollectDAO {

	public List<Collect> getAll() {
		List<Collect> list = new ArrayList<Collect>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,product,title,author,price,count from tb_book,tb_cart_item where tb_book.isbn=tb_cart_item.product ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Collect collectBook = getCollectBook(rs);
				list.add(collectBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	private Collect getCollectBook(ResultSet rs) throws SQLException {
		String userId = rs.getString(1);
		String product = rs.getString(2);
		String title = rs.getString(3);
		float price = rs.getFloat(4);
		
		Collect cartBook = new Collect(userId, product, title, price);
		
		return cartBook;
	}

	@Override
	public List<Collect> getCollectBookById(String userId) {
		List<Collect> list = new ArrayList<Collect>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,product,title,price from tb_book,tb_collect where tb_book.isbn=tb_collect.product and user_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				Collect collectBook = getCollectBook(rs);
				list.add(collectBook);
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
	public int collectBook(String userId, String product) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_collect (user_id,product)values(?,?)";
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
	public int deleteCollectBook(String userId, String product) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from tb_collect where user_id=? and product=?";
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
	public boolean collectIsExisted(String userId, String product) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;
		String sql = "select * from tb_collect where user_id = ? and product = ?";
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



}

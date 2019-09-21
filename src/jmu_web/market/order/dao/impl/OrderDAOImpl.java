package jmu_web.market.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmu_web.market.order.DetailOrder;
import jmu_web.market.order.Order;
import jmu_web.market.order.UserOrder;
import jmu_web.market.order.dao.OrderDAO;
import jmu_web_market.utils.JdbcUtils;

public class OrderDAOImpl extends JdbcUtils implements OrderDAO {

	@Override
	public List<Order> getAll() {
		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,product,title,author,price,count from tb_book,tb_cart_item where tb_book.isbn=tb_cart_item.product ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Order orderBook = getOrder(rs);
				list.add(orderBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	private Order getOrder(ResultSet rs) throws SQLException {
		String userId = rs.getString(1);
		String orderId = rs.getString(2);
		String sta = rs.getString(3);
		String addressId = rs.getString(4);
		float payment = rs.getFloat(5);
		String placed = rs.getString(6);
		
		Order orderBook = new Order(userId, orderId, sta, addressId, payment, placed);
		
		return orderBook;
	}
	
	private UserOrder getUserOrder(ResultSet rs) throws SQLException {
		String orderId = rs.getString(1);
		String product = rs.getString(2);
		String placed = rs.getString(3);
		String title = rs.getString(4);
		String press = rs.getString(5);
		int count = rs.getInt(6);
		float price = rs.getFloat(7);
		float total = rs.getFloat(8);
		String sta = rs.getString(9);
		
		UserOrder userOrderBook = new UserOrder(orderId,product, placed, title, press, price, count,total,sta);
		
		return userOrderBook;
	}

	@Override
	public int addOrder(Order o) {
			int result = 0;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "insert into tb_order (user_id,order_id,sta,address_id,payment,placed)values(?,?,?,?,?,?)";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, o.getUserId());
				ps.setString(2, o.getOrderId());
				ps.setString(3, o.getSta());
				ps.setString(4, o.getAddressId());
				ps.setFloat(5, o.getPayment());
				ps.setString(6, o.getPlaced());
				result = ps.executeUpdate();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				closeAll(rs, ps, conn);
			}
			return result;
		}

	@Override
	public int addDetailOrder(String product, float price, int count, String orderId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_order_item (product,price,count,order_id)values(?,?,?,?)";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product);
			ps.setFloat(2, price);
			ps.setInt(3, count);
			ps.setString(4, orderId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public List<UserOrder> getOrderBookById(String userId) {
		List<UserOrder> list = new ArrayList<UserOrder>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select tb_order.order_id,product,placed,title,press,count,tb_book.price,payment,sta from tb_order,tb_order_item,tb_book where tb_order_item.product=tb_book.isbn and tb_order_item.order_id=tb_order.order_id and user_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				UserOrder userOrderBook = getUserOrder(rs);
				list.add(userOrderBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	@Override
	public boolean updateOrder(String userId,String product,String handover) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update tb_order set sta=?, handover=? where user_id=? and order_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			String sta = "Received";
			ps.setString(1,sta );
			ps.setString(2,handover );
			ps.setString(3, userId);
			ps.setString(4, product);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return false;
	}

	@Override
	public int deleteOrder(String userId, String orderId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "delete from tb_order_item where order_id=?";
		String sql1 = "delete from tb_order where user_id=? and order_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderId);
			ps.executeUpdate();
			ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, userId);
			ps1.setString(2, orderId);
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,order_id,sta,address_id,payment,placed from tb_order";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Order orderBook = getOrder(rs);
				list.add(orderBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	@Override
	public Order getOrder(String order_id) {
		Order order = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id, order_id, sta, address_id, payment, placed from tb_order where order_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, order_id);
			rs = ps.executeQuery();
			while(rs.next()){
				order = getOrder(rs);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return order;
	}

	@Override
	public List<Order> getOrderByReceiver(String address_id) {
		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,product,title,author,price,count from tb_book,tb_cart_item where tb_book.isbn=tb_cart_item.product ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Order orderBook = getOrder(rs);
				list.add(orderBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	@Override
	public List<DetailOrder> getDetailOrderByOrderId(String order_id) {
		List<DetailOrder> list = new ArrayList<DetailOrder>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select tb_order_item.count, tb_book.isbn,"
		+" tb_book.title, tb_book.price from tb_book, tb_order_item"
		+" where tb_order_item.product=tb_book.isbn and tb_order_item.order_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, order_id);
			rs = ps.executeQuery();
			while(rs.next()){
				DetailOrder detailOrder = getDetailOrder(rs);
				list.add(detailOrder);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
		
	}
	
	private DetailOrder getDetailOrder(ResultSet rs) throws SQLException {
		int count = rs.getInt(1);
		String isbn = rs.getString(2);
		String title = rs.getString(3);
		double price = rs.getDouble(4);
		DetailOrder detailOrder = new DetailOrder(count, isbn, title, price);
		
		return detailOrder;
	}

	@Override
	public List<Order> getOrderByStatus(String order_sta) {
		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id,order_id,sta,address_id,payment,placed from tb_order where sta=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, order_sta);
			rs = ps.executeQuery();
			while(rs.next()){
				Order Order = getOrder(rs);
				list.add(Order);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}

	}







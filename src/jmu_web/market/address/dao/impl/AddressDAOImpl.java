package jmu_web.market.address.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jmu_web.market.address.Address;
import jmu_web.market.address.Address1;
import jmu_web.market.address.dao.AddressDAO;
import jmu_web_market.utils.JdbcUtils;

public class AddressDAOImpl extends JdbcUtils implements AddressDAO {

	private Address getReceiverAddress(ResultSet rs) throws SQLException {
		String rid = rs.getString(1);
		String receiver = rs.getString(2);
		String address = rs.getString(3);
		String receiverPhone = rs.getString(4);
		
		Address receiverAddress = new Address(rid,receiver, address, receiverPhone);
		
		return receiverAddress;
	}

	@Override
	public List<Address> getAddress(String userId) {
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select rid,receiver,address,receiver_phone from tb_user,tb_address where tb_user.phone=tb_address.user_id and user_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				Address receiverAddress = getReceiverAddress(rs);
				list.add(receiverAddress);
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
	public int addAddress(Address1 address) {
		System.out.println("***************************"+address);
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_address (user_id,address,added,receiver,receiver_phone)values(?,?,?,?,?)";
		try {
			conn = getConn();
		    Date date = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			ps = conn.prepareStatement(sql);
			ps.setString(1, address.getUser_id());
			ps.setString(2, address.getAddress());
			ps.setString(3, sdf.format(date));
			ps.setString(4, address.getReceiver());
			ps.setString(5, address.getReceiver_phone());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public Address1 getReceiver(String order_id) {
		Address1 receiver = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select tb_address.user_id, address, added, receiver, receiver_phone from tb_address, tb_order "
		+"where tb_address.rid = tb_order.address_id and tb_address.user_id = tb_order.user_id "
				+"and tb_order.order_id=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, order_id);
			rs = ps.executeQuery();
			while(rs.next()){
				receiver = getAddress(rs);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return receiver;
	}

	private Address1 getAddress(ResultSet rs) throws SQLException {
		String user_id = rs.getString(1);
		String address = rs.getString(2);
		String added = rs.getString(3);
		String receiver = rs.getString(4);
		String receiver_phone = rs.getString(5);
		Address1 addre = new Address1(user_id, address, added, receiver, receiver_phone); 
		return addre;
	}

	@Override
	public int updateAddress(Address a) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update tb_address set address=?,receiver=?,receiver_phone=? where rid=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAddress());
			ps.setString(2, a.getReceiver());
			ps.setString(3, a.getReceiverPhone());
			ps.setString(4, a.getRid());
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
	public int deleteAddress(String rid) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from tb_address where rid=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,rid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}


	

}

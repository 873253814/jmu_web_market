package jmu_web_market.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmu_web.market.user.User;
import jmu_web_market.user.dao.UserDAO;
import jmu_web_market.utils.JdbcUtils;

public class UserDAOImpl extends JdbcUtils implements UserDAO{
	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_user order by uname";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = getUser(rs);
			    list.add(u);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	private User getUser(ResultSet rs) throws SQLException {
		String userName = rs.getString(1);
		String userPass = rs.getString(2);
		String userEmail = rs.getString(3);
		String userPhone = rs.getString(4);
		User u = new User(userName, userPass, userEmail, userPhone);
		return u;
	}

	@Override
	public User getUserByName(String userName) {
		User u = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where uname = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
			   u = getUser(rs);
			   
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return u;
	}

	@Override
	public int addUser(User u) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_user (uname,upwd,email,phone,role)values(?,?,?,?,0)";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getUserPass());
			ps.setString(3, u.getUserEmail());
			ps.setString(4, u.getUserPhone());
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
	public boolean updateUser(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update tb_user set upwd=?,email=?,phone=? where uname=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserPass());
			ps.setString(2, u.getUserEmail());
			ps.setString(3, u.getUserPhone());
			ps.setString(4, u.getUserName());
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
	public String Login(String userName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String userPass = null;
		String userRole = null;
		String sql = "select * from tb_user where phone= ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()) {
				userPass = rs.getString("upwd");
				userRole = rs.getString("role");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return userPass+","+userRole;
	}

	@Override
	public boolean nameIsExisted(String userName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select * from tb_user where phone = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
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
	public boolean eamilIsExisted(String userEmail) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select * from tb_user where email = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userEmail);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("uname"));
				flag = true;
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
	public boolean phoneIsExisted(String userPhone) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select * from tb_user where phone = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userPhone);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
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
	public int updatePass(String userId,String userPass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update tb_user set upwd=? where phone=?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,userPass );
			ps.setString(2,userId );
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
	public String passwordIsExisted(String userPhone) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		String sql = "select upwd from tb_user where phone = ?";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userPhone);
			rs = ps.executeQuery();
			if(rs.next()) {
				pwd = rs.getString("upwd");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, conn);
		}
		return pwd;
	}
}

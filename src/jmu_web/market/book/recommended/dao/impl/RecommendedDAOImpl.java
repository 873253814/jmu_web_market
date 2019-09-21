package jmu_web.market.book.recommended.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmu_web.market.book.recommended.Recommended;
import jmu_web.market.book.recommended.dao.RecommendedDAO;
import jmu_web_market.utils.JdbcUtils;

public class RecommendedDAOImpl extends JdbcUtils implements RecommendedDAO {

	@Override
	public List<Recommended> getAll() {
		List<Recommended> list = new ArrayList<Recommended>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select rid,product,title from tb_recommended,tb_book where tb_recommended.product=tb_book.isbn ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Recommended recBook = getRecBook(rs);
				list.add(recBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}

	private Recommended getRecBook(ResultSet rs) throws SQLException {
		String rid = rs.getString(1);
		String product = rs.getString(2);
		String title = rs.getString(3);
		Recommended recBook = new Recommended(rid, product,title);
		
		return recBook;
	}

	@Override
	public List<Recommended> getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}
}

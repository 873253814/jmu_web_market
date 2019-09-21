package jmu_web_market.user.dao;

import java.util.List;

import jmu_web.market.user.User;

	public interface UserDAO {
	    List<User> getAll();
	    User getUserByName(String userName);
	    int addUser(User u);
	    boolean updateUser(User u);
		String Login(String userName);
		boolean nameIsExisted(String userName);
		boolean eamilIsExisted(String userEmail);
		boolean phoneIsExisted(String userPhone);
		int updatePass(String userId,String userPass);
		String passwordIsExisted(String userPhone);
}

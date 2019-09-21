package jmu_web.market.user;

public class User {
	private String userName;
	private String userPass;
	private String userEmail;
	private String userPhone;
	
	public User() {
		super();
	}
	
	public User(String userPhone,String userName,String userPass,String userEmail){
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPass=" + userPass
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
	}
	
}

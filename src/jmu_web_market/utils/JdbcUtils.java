package jmu_web_market.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	static String driver;
	static String url;
	static String user;
	static String pass;
   static{
	   InputStream in = JdbcUtils.class.getResourceAsStream("db.properties");
	   Properties p = new Properties();
	   try {
		p.load(in);
		driver = p.getProperty("jdbcDriver");
		url = p.getProperty("jdbcUrl");
		user = p.getProperty("user");
		pass = p.getProperty("pass");
		Class.forName(driver);
	  } catch (Exception e) {
		throw new RuntimeException("加载数据库配置文件出错————"+e);
	}
   }
   
   public static Connection getConn() throws Exception{
	   return DriverManager.getConnection(url,user,pass);
   }
   public static void main(String[] args) throws Exception{
	if(null!=getConn())
		System.out.println("success");
}
   public static void closeAll(ResultSet rs,Statement ps,Connection conn){
	   
   }
}

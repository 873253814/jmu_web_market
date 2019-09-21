package jmu_web_market.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
   public static String getNowTime(){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	   return sdf.format(new Date());
   }
   public static void main(String[] args) {
	System.out.println(getNowTime());
	
   }
}

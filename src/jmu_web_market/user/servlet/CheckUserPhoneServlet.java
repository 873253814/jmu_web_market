package jmu_web_market.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.user.User;
import jmu_web_market.user.dao.UserDAO;
import jmu_web_market.user.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/CheckUserPhoneServlet")
public class CheckUserPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckUserPhoneServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userPhone = request.getParameter("phone");
		UserDAO dao = new UserDAOImpl();
		boolean result = dao.phoneIsExisted(userPhone);
		PrintWriter out = response.getWriter();
		//System.out.println(result);
		out.println(result);
			//out.print("<script>alert('×¢²á³É¹¦')</script>");
			
		
	}




}

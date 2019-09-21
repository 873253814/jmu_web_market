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
@WebServlet("/CheckUserPasswordServlet")
public class CheckUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckUserPasswordServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userPhone = request.getParameter("userId");
		String userPass = request.getParameter("upwd");
		UserDAO dao = new UserDAOImpl();
		String password = dao.passwordIsExisted(userPhone);
		PrintWriter out = response.getWriter();
		//System.out.println(password);
		//out.println(password);
		if(password.equals(userPass)) {
			out.print(true);
		}else {
			out.print(false);
		}
			//out.print("<script>alert('×¢²á³É¹¦')</script>");
			
		
	}




}

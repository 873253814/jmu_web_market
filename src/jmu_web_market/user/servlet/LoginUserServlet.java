package jmu_web_market.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jmu_web.market.user.User;
import jmu_web_market.user.dao.UserDAO;
import jmu_web_market.user.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginUserServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("uname");
		String userPass = request.getParameter("upwd");
		UserDAO dao = new UserDAOImpl();
		String getPwd = dao.Login(userName);
		PrintWriter out = response.getWriter();
		System.out.println(getPwd);
		String[] userInfor = getPwd.split(",");
		if(userInfor[0]!=null&&userInfor[0].equals(userPass)&&userInfor[1].equals("0")) {
			HttpSession mySession = request.getSession(true);
			mySession.setAttribute("sessionId", userName);
			System.out.print(mySession.getAttribute("sessionId"));
	    	response.sendRedirect("../jmu_web_market/user/jsp/index.jsp");
		}else if(userInfor[0]!=null&&userInfor[0].equals(userPass)&&userInfor[1].equals("1")){
			response.sendRedirect("order");
		}else {
			out.print("<script>alert('error')</script>");
			response.sendRedirect("../jmu_web_market/user/jsp/login.jsp");
		}
		/*if(u.getUserPass().equals(userPass)) {
			response.sendRedirect("../jmu_web_market/user/page/index.html");
		}else {
			response.sendRedirect("../jmu_web_market/user/page/login.html");
		}*/
			//out.print("<script>alert('×¢²á³É¹¦')</script>");

			
		
	}




}

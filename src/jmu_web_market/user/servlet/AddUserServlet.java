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
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddUserServlet() {
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
		String userEmail = request.getParameter("email");
		String userPhone = request.getParameter("phone");
		
		UserDAO dao = new UserDAOImpl();
		User u = new User(userName,userPass,userEmail,userPhone);
		int result = dao.addUser(u);
		PrintWriter out = response.getWriter();
			//out.print("<script>alert('×¢²á³É¹¦')</script>");
		System.out.println(result);
		if(result>0){
			response.sendRedirect("../jmu_web_market/user/page/login.html");
			//request.getRequestDispatcher("../login.html").forward(request, response);
		}else{
			out.print("<script>alert('×¢²áÊ§°Ü')</script>");
			response.sendRedirect("../jmu_web_market/user/page/regist.html");
		}
			
		
	}




}

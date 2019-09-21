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
@WebServlet("/UpdateUserPasswordServlet")
public class UpdateUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateUserPasswordServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userPhone = request.getParameter("user.uname");
		String userPass = request.getParameter("cpwd");
		UserDAO dao = new UserDAOImpl();
		int result = dao.updatePass(userPhone, userPass);
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.print(true);
		}else {
			out.print(false);
		}
		//System.out.println(password);
		//out.println(password);
			//out.print("<script>alert('×¢²á³É¹¦')</script>");
			
		
	}




}

package jmu_web.market.cart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.cart.dao.CartDAO;
import jmu_web.market.cart.dao.impl.CartDAOImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public DeleteCartServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userId = request.getParameter("userId");
		String product = request.getParameter("product");
		CartDAO dao = new CartDAOImpl();
		int result = dao.deleteCartBook(userId, product);
		if(result>0) {
			response.sendRedirect("../jmu_web_market/user/jsp/cart.jsp");
		}
			
		
	}






}






package jmu_web.market.collect.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.collect.dao.CollectDAO;
import jmu_web.market.collect.dao.impl.CollectDAOImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/DeleteCollectServlet")
public class DeleteCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteCollectServlet() {
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
		CollectDAO dao = new CollectDAOImpl();
		int result = dao.deleteCollectBook(userId, product);
		if(result>0) {
			response.sendRedirect("../jmu_web_market/user/jsp/collect.jsp");
		}
			
		
	}




}

package jmu_web.market.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.order.Order;
import jmu_web.market.order.dao.OrderDAO;
import jmu_web.market.order.dao.impl.OrderDAOImpl;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateOrderServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = df.format(new Date());
		String userId = request.getParameter("sid");
		String orderId = request.getParameter("orderId");
    	OrderDAO dao = new OrderDAOImpl();
		dao.updateOrder(userId,orderId,nowDate);
		PrintWriter out = response.getWriter();
		response.sendRedirect("../jmu_web_market/user/jsp/order.jsp");

	}




}

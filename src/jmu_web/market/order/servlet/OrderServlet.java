package jmu_web.market.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.order.dao.OrderDAO;
import jmu_web.market.order.dao.impl.OrderDAOImpl;
import jmu_web.market.order.Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		OrderDAO dao = new OrderDAOImpl();
		List<Order> orderList = dao.getAllOrder();
		//System.out.println(orderList);
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("admin/page/order-list.jsp").forward(request, response);
	
		
	}

}

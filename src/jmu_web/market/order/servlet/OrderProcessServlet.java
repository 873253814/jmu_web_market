package jmu_web.market.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.address.dao.AddressDAO;
import jmu_web.market.address.dao.impl.AddressDAOImpl;
import jmu_web.market.address.Address;
import jmu_web.market.address.Address1;
import jmu_web.market.order.dao.OrderDAO;
import jmu_web.market.order.dao.impl.OrderDAOImpl;
import jmu_web.market.order.DetailOrder;
import jmu_web.market.order.Order;

@WebServlet("/OrderProcessServlet")
public class OrderProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderProcessServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset='utf-8'");
		String order_id = request.getParameter("order_id");
		
		AddressDAO dao1 = new AddressDAOImpl();
		Address1 addre = dao1.getReceiver(order_id);
		
		OrderDAO dao = new OrderDAOImpl();
		Order order = dao.getOrder(order_id);
		List<DetailOrder> detailOrderList = dao.getDetailOrderByOrderId(order_id);
		
		request.setAttribute("addre", addre);
		request.setAttribute("order", order);
		request.setAttribute("detailOrderList", detailOrderList);
		request.getRequestDispatcher("admin/page/order-process.jsp").forward(request, response);
	}

}

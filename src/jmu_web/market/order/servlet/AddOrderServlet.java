package jmu_web.market.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddOrderServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userId = request.getParameter("sid");
		String orderId = request.getParameter("orderId");
		String sta = "Paid";
		String total = request.getParameter("total");
		float payment = Float.parseFloat(total);
		String addressId = request.getParameter("rid");
		String placed = request.getParameter("nowDate");
		String product = request.getParameter("product");
		String count1 = request.getParameter("count");
		int count = Integer.parseInt(count1);
    	OrderDAO dao = new OrderDAOImpl();
		Order o = new Order(userId,orderId,sta,addressId,payment,placed);
		int result = dao.addOrder(o);
		int result1 = dao.addDetailOrder(product, payment, count, orderId);
		PrintWriter out = response.getWriter();
			//out.print("<script>alert('×¢²á³É¹¦')</script>");
		System.out.println(result);
		if(result>0&&result>0){
			response.sendRedirect("../jmu_web_market/user/jsp/pay-success.jsp?total="+payment+"&orderId="+orderId);
			//request.getRequestDispatcher("../login.html").forward(request, response);
		}else{
			out.print("<script>alert('Ê§°Ü')</script>");
		}	
	}




}

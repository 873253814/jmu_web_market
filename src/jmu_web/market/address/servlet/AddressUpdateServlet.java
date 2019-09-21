package jmu_web.market.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.address.dao.AddressDAO;
import jmu_web.market.address.dao.impl.AddressDAOImpl;
import jmu_web.market.address.*;

@WebServlet("/AddressUpdateServlet")
public class AddressUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddressUpdateServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		AddressDAO dao = new AddressDAOImpl();
		String userId = request.getParameter("rid");
		String receiver = request.getParameter("receiver");
		String address = request.getParameter("user.address");
		String receiverPhone = request.getParameter("receiverPhone");
		System.out.println(userId);
		System.out.println(receiver);
		System.out.println(address);
		System.out.println(receiverPhone);
		PrintWriter out = response.getWriter();
		Address addre = new Address(userId, receiver,address, receiverPhone);
		int i = dao.updateAddress(addre);
		 if (i>0) {
			 out.print(true);
			 //System.out.println("Ìí¼Ó³É¹¦");
		} else {
			out.print(false);
		}
		//request.getRequestDispatcher("user/page/address-add.jsp").forward(request, response);
		
		
	}

}

package jmu_web.market.address.servlet;

import java.io.IOException;
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

@WebServlet("/AddressAddServlet")
public class AddressAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddressAddServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		AddressDAO dao = new AddressDAOImpl();
		String userId = request.getParameter("userId");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String receiver = request.getParameter("receiver");
		String address = request.getParameter("address");
		String receiverPhone = request.getParameter("receiverPhone");
		
		Address1 addre = new Address1(userId, address, df.format(new Date()), receiver, receiverPhone);
		int i = dao.addAddress(addre);
		 if (i>0) {
			 response.getWriter().print("<script>alert('添加成功！');location.href = 'user/page/address-add.jsp';</script>");
			 //System.out.println("添加成功");
		} else {
			response.getWriter().print("<script>alert('添加失败！');location.href = 'user/jsp/address-add.jsp';</script>");
			//System.out.println("添加失败");
		}
		//request.getRequestDispatcher("user/page/address-add.jsp").forward(request, response);
		
		
	}

}

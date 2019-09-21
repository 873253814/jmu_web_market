package jmu_web.market.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.book.dao.BookDAO;
import jmu_web.market.book.dao.impl.BookDAOImpl;
import jmu_web.market.book.entity.*;;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/SelectBookServlet")
public class SelectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SelectBookServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String title = request.getParameter("title");
		BookDAO dao = new BookDAOImpl();
		List<SelectConditionBook> list = dao.SelectConditionBook(title);
		PrintWriter out = response.getWriter();
		out.print(title);
			//out.print("<script>alert('×¢²á³É¹¦')</script>");
			
		
	}




}

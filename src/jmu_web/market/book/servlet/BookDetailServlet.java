package jmu_web.market.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmu_web.market.book.dao.BookDAO;
import jmu_web.market.book.dao.impl.BookDAOImpl;
import jmu_web.market.book.entity.Book;


@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset='utf-8'");
		BookDAO dao = new BookDAOImpl();
		String isbn = request.getParameter("isbn");
		Book book = dao.getBookByIsbn(isbn);
		System.out.println("book------------------"+book);
		request.setAttribute("book", book);
		request.getRequestDispatcher("admin/page/product-detail.jsp").forward(request, response);
	
		
	}

}

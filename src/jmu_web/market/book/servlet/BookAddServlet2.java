package jmu_web.market.book.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import jmu_web_market.utils.Utils;
import jmu_web.market.book.dao.BookDAO;
import jmu_web.market.book.dao.impl.BookDAOImpl;
import jmu_web.market.book.entity.Book;

@WebServlet("/BookAddServlet2")
public class BookAddServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		
		 uploadFile(request, response);
		 Book book = getBook(request, response);
		 BookDAO dao = new BookDAOImpl();
		 //System.out.println(book);
		 if(dao.addBook(book)>0)
		 {
			System.out.print(request.getContextPath()+"/admin/page/product-add2.jsp");
			//response.sendRedirect(request.getContextPath()+"/admin/page/product-list.jsp");
		 }
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}
	
	Map<String,String> map = new HashMap<String,String>();
	
	public Book getBook(HttpServletRequest request, HttpServletResponse response){
		Book book = null;
		/*String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String pages = request.getParameter("pages");
		String words = request.getParameter("words");
		String press = request.getParameter("press");
		String edition = request.getParameter("edition");
		String published = request.getParameter("published");
		String format = request.getParameter("format");
		String packaging = request.getParameter("packaging");
		String form = request.getParameter("form");*/
		
		String isbn = map.get("isbn");
		String title = map.get("title");
		String author = map.get("author");
		double price = Double.parseDouble(map.get("price"));
		int pages = Integer.parseInt(map.get("pages"));
		int words = Integer.parseInt(map.get("words"));
		String press = map.get("press");
		int edition = Integer.parseInt(map.get("edition"));
		String published = map.get("published");
		String format = map.get("format");
		String packaging = map.get("packaging");
		String form = map.get("form");
		
		//double price2=Double.parseDouble(price);
		//int pages2=Integer.parseInt(pages);
		//int words2=Integer.parseInt(words);
		//int edition2=Integer.parseInt(edition);
		//System.out.print(isbn+" "+title+" "+author+" "+price2+" "+pages2+" "+words2+" "+press+" "+edition2+" "+published+" "+format+" "+packaging+" "+form);
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date d = null;
		try {
			d = format1.parse(published);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		java.sql.Date dd = new java.sql.Date(d.getTime());
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		
		String isbn = request.getParameter("isbn");
		//System.out.println(isbn);
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		//System.out.println(author);
		double price = Double.parseDouble(request.getParameter("price"));
		int pages = Integer.parseInt(request.getParameter("pages"));
		int words = Integer.parseInt(request.getParameter("words"));
		String press = request.getParameter("press");
		int edition = Integer.parseInt(request.getParameter("edition"));
		Date published = formatter.parse(request.getParameter("published"),pos);
		String format = request.getParameter("format");
		String packaging = request.getParameter("packaging");
		String form = request.getParameter("form");*/
		book=new Book(isbn,title,author,price,press,edition,dd,pages,words,packaging,format,form);
		
		return book;
	}
	
	protected void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//�����ϴ��ļ���Ĺ�������
		FileItemFactory factory = new DiskFileItemFactory();
		//����ļ��ϴ��ĺ��������
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		PrintWriter out = response.getWriter();
		//�����ϴ��ļ��Ĵ�С�����͡������ʽ��
		upload.setFileSizeMax(10*1024*1024);
		//�����ϴ��ļ����ܴ�С
		upload.setSizeMax(50*1024*1024);
		upload.setHeaderEncoding("utf-8");
		
		//�ж��Ƿ����ļ��ϴ�������
		if (ServletFileUpload.isMultipartContent(request)) {
			//���ϴ����ļ�����ת��Ϊ��Ӧ��List����
			try {
				List<FileItem> list = upload.parseRequest((RequestContext) request);
				//�����ϴ��ļ��ĸ������Ժ�ֵ
				for (FileItem item : list) {
					//�ж��Ƿ�Ϊ��ͨ�ı�����(��file���͵�)
					if (item.isFormField()) {
						//��ȡ��Ӧ��Ԫ�ص�����
						String name = item.getFieldName();
						//��ȡ��Ӧ�ؼ���ֵ
						String value = item.getString();
						//System.out.println("*************"+name+":"+new String(value.getBytes("iso-8859-1"),"utf-8"));
						map.put(name, new String(value.getBytes("iso-8859-1"),"utf-8"));
					} else //���Ϊ�ϴ��ļ���file�ؼ�
					{
						//1.��ȡisbn���ж���isbnΪ�����ļ����Ƿ���ڣ��������ڣ��򴴽���Ϊisbn���ļ���
						String isbnx=map.get("isbn");
						System.out.println("isbnΪ"+isbnx);
						//2.ͼƬ�Ѿ�����Ϊindex.jpg��intro.jpg�ȵȣ���ȡ�ϴ��ļ�������
						String name=item.getName();
						//System.out.println("�ļ�������Ϊ��"+name);
						//�����ϴ��ļ�������,ÿ���ϴ������ϴ�ʱ����ȡ����
						String nameId = Utils.getNowTime();
						//ƴ���µ��ļ���
						name = nameId+"$"+name;
						//3.�õ��ϴ��ļ���·���������
						//String path="E:/javaѧϰ/bookstore/WebContent/user/img/goods";
						//String newpath=path+"/"+isbnx;
						String path = getServletContext().getRealPath("/upload");
						
						//System.out.println("·��Ϊ��"+newpath);
						//File f=new File(path);
						//f.mkdir();
						//4.����Ҫ�ϴ��ļ��Ķ���,�����
						File file=new File(path,name);
						//System.out.println("�ϴ����ļ���Ϊ��"+file.getName());
						//5.���ļ����浽��Ӧ��·��
						item.write(file);
						//6.ɾ����ʱ�ļ�
						item.delete();
						
						/*//��ȡ�ϴ��ļ�������
						String name = item.getName();
						//�����ϴ��ļ�������,ÿ���ϴ������ϴ�ʱ����ȡ����
						String nameId = Utils.getNowTime();
						//ƴ���µ��ļ���
						name = nameId+"$"+name;
						//�õ��ϴ��ļ���·��
						String path = getServletContext().getRealPath("/upload");
						System.out.println(path);
						//����Ҫ�ϴ��ļ��Ķ���
						File file  = new File(path, name);
						System.out.println("%%%%%%%%%%%%%%"+file.getName());
						//���ļ����浽 ��Ӧ��·��
						item.write(file);
						//ɾ���ϴ��в�������ʱ�ļ�
						item.delete();*/
						
					}
				}
				out.write("yes");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		
		} else {

		}
				
	}

	

}

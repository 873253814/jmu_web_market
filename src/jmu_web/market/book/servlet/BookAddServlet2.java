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
			// TODO 自动生成的 catch 块
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
		
		//创建上传文件项的工厂对象
		FileItemFactory factory = new DiskFileItemFactory();
		//获得文件上传的核心类对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		PrintWriter out = response.getWriter();
		//设置上传文件的大小、类型、编码格式等
		upload.setFileSizeMax(10*1024*1024);
		//设置上传文件的总大小
		upload.setSizeMax(50*1024*1024);
		upload.setHeaderEncoding("utf-8");
		
		//判断是否是文件上传的类型
		if (ServletFileUpload.isMultipartContent(request)) {
			//将上传的文件数据转换为对应的List集合
			try {
				List<FileItem> list = upload.parseRequest((RequestContext) request);
				//遍历上传文件的各个属性和值
				for (FileItem item : list) {
					//判断是否为普通的表单数据(非file类型的)
					if (item.isFormField()) {
						//获取对应表单元素的名字
						String name = item.getFieldName();
						//获取对应控件的值
						String value = item.getString();
						//System.out.println("*************"+name+":"+new String(value.getBytes("iso-8859-1"),"utf-8"));
						map.put(name, new String(value.getBytes("iso-8859-1"),"utf-8"));
					} else //如果为上传文件的file控件
					{
						//1.获取isbn，判断以isbn为名的文件夹是否存在，若不存在，则创建名为isbn新文件夹
						String isbnx=map.get("isbn");
						System.out.println("isbn为"+isbnx);
						//2.图片已经命名为index.jpg，intro.jpg等等，获取上传文件的名字
						String name=item.getName();
						//System.out.println("文件的名字为："+name);
						//处理上传文件的名字,每次上传根据上传时间来取名字
						String nameId = Utils.getNowTime();
						//拼接新的文件名
						name = nameId+"$"+name;
						//3.得到上传文件的路径，并输出
						//String path="E:/java学习/bookstore/WebContent/user/img/goods";
						//String newpath=path+"/"+isbnx;
						String path = getServletContext().getRealPath("/upload");
						
						//System.out.println("路径为："+newpath);
						//File f=new File(path);
						//f.mkdir();
						//4.创建要上传文件的对象,并输出
						File file=new File(path,name);
						//System.out.println("上传的文件名为："+file.getName());
						//5.将文件保存到对应的路径
						item.write(file);
						//6.删除临时文件
						item.delete();
						
						/*//获取上传文件的名字
						String name = item.getName();
						//处理上传文件的名字,每次上传根据上传时间来取名字
						String nameId = Utils.getNowTime();
						//拼接新的文件名
						name = nameId+"$"+name;
						//得到上传文件的路径
						String path = getServletContext().getRealPath("/upload");
						System.out.println(path);
						//创建要上传文件的对象
						File file  = new File(path, name);
						System.out.println("%%%%%%%%%%%%%%"+file.getName());
						//将文件保存到 对应的路径
						item.write(file);
						//删除上传中产生的临时文件
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

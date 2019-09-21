package jmu_web.market.order.dao;
import java.util.List;

import jmu_web.market.order.Order;
import jmu_web.market.order.UserOrder;
import jmu_web.market.order.DetailOrder;

public interface OrderDAO {
	List<Order> getAll();
	public int addOrder(Order o);
	public int addDetailOrder(String product,float price,int count,String orderId);
	List<UserOrder> getOrderBookById(String userId);
	boolean updateOrder(String userId,String product,String handover);
	int deleteOrder(String userId,String orderId);
	//select product,placed,title,press,count,tb_book.price,payment from tb_order,tb_order_item,tb_book where tb_order_item.product=tb_book.isbn and tb_order_item.order_id=tb_order.order_id and user_id=12345678901
	List<Order> getAllOrder(); //���ڹ���Ա�������ж�������ʾ
	Order getOrder(String order_id); //���ڶ�������ҳ�涩��״̬��
	List<Order> getOrderByReceiver(String address_id);
	List<DetailOrder> getDetailOrderByOrderId(String order_id);
	List<Order> getOrderByStatus(String order_sta); //���ڰ�����״̬�鿴����
}

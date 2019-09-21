package jmu_web.market.cart.dao;
import java.util.List;
import jmu_web.market.cart.Cart;

public interface CartDAO {
	List<Cart> getAll();
	List<Cart> getBookById(String isbn);
	int addCartBook(String userId,String product,int count);
	boolean cartIsExisted(String userId, String product);
	int deleteCartBook(String userId,String product);
	boolean updateCart(String userId,String product,int count);
	
}

package jmu_web.market.address.dao;

import java.util.List;
import jmu_web.market.address.Address;
import jmu_web.market.address.Address1;

public interface AddressDAO {
	List<Address> getAddress(String userId);
	int addAddress(Address1 address);
	Address1 getReceiver(String order_id);
	int updateAddress(Address a);
	int deleteAddress(String rid);
}

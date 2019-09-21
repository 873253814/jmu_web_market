package jmu_web.market.collect.dao;

import java.util.List;

import jmu_web.market.collect.Collect;

public interface CollectDAO {
	List<Collect> getAll();
	List<Collect> getCollectBookById(String userId);
	int collectBook(String userId,String product);
	int deleteCollectBook(String userId,String product);
	boolean collectIsExisted(String userId,String product);
}

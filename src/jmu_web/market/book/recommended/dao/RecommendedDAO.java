package jmu_web.market.book.recommended.dao;

import java.util.List;

import jmu_web.market.book.recommended.Recommended;

	public interface RecommendedDAO {
	    List<Recommended> getAll();
	    List<Recommended> getBookByIsbn(String isbn);
}

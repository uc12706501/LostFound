package com.lkk.lostfound.dao;

import java.util.*;

public interface DaoBase<T> {

	void save(T entity);

	void delete(long entityId);

	T get(long entityId);

	List<T> getAll();

	List<T> getPartial(int pageSize, int pageIndex);

	List<T> Query(String queryString);
}

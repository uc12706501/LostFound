package com.lkk.lostfound.dao;

import java.util.*;

public interface DaoBase<T> {

	T get(long entityId);

	Integer save(T entity);

	void update(T entity);

	void delete(long entityId);

	List<T> getAll();

	List<T> getPartial(int pageSize, int pageIndex);

	List<T> Query(String queryString);
}

package com.lkk.lostfound.dao;

import java.util.*;

import org.javatuples.Pair;

import com.lkk.lostfound.daoImpl.DaoBaseImpl.SortDirection;

public interface DaoBase<T> {

	T get(long entityId);

	Long save(T entity);

	void update(T entity);

	void delete(long entityId);

	// 查询
	List<T> getAll();

	List<T> getLasted(int count);

	Pair<List<T>, Integer> getPartial(int pageIndex, int PageSize);

	Pair<List<T>, Integer> getPartial(int pageIndex, int PageSize,
			String field, String filterString);

	Pair<List<T>, Integer> getPartial(int pageIndex, int PageSize,
			String field, String filterString, String sortField,
			SortDirection direction);
}

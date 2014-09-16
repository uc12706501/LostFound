package com.lkk.lostfound.dao;

import java.util.*;

import org.javatuples.Pair;

import com.lkk.lostfound.daoImpl.Order;
import com.lkk.lostfound.daoImpl.DaoBaseImpl.SortDirection;

/**
 * @author lkk
 *
 * @param <T>
 */
public interface DaoBase<T> {

	T get(long entityId);

	Long save(T entity);

	void update(T entity);

	void delete(long entityId);

	// 查询
	List<T> getAll();

	List<T> getLasted(int count);

	List<T> getLasted(int count, final Map<String, Object> params);

	/**
	 * @param index
	 *            页数
	 * @param size
	 *            每页记录数
	 * @return 对所有记录进行分页之后的结果
	 */
	Pair<List<T>, Integer> getPartial(final int index, final int size);

	/**
	 * @param index
	 *            页数
	 * @param size
	 *            每页的记录数
	 * @param params
	 *            查询参数
	 * @return 查询并分页之后的结果集
	 */
	Pair<List<T>, Integer> getPartial(final int index, final int size,
			final Map<String, Object> params);

	/**
	 * @param index
	 *            页数
	 * @param size
	 *            每页的记录数
	 * @param order
	 *            顺序
	 * @param params
	 *            查询的参数
	 * @param propertyName
	 *            排序属性
	 * @return 查询和排序和分页之后的结果集
	 */
	Pair<List<T>, Integer> getPartial(final int index, final int size,
			final Map<String, Object> params, final Order order,
			final String... propertyName);

	public List<T> query(final int index, final int size,
			final Map<String, Object> params, final Order order,
			final String... propertyName);
}

package com.lkk.lostfound.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.javatuples.Pair;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lkk.lostfound.dao.DaoBase;
import com.lkk.lostfound.utils.StringUtils;

public abstract class DaoBaseImpl<T> extends HibernateDaoSupport implements
		DaoBase<T> {

	public enum SortDirection {
		ASC, DESC,
	}

	@SuppressWarnings("unchecked")
	public T get(long entityId) {
		return (T) getHibernateTemplate().get(getEntityClass(), entityId);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public Long save(T entity) {
		return (Long) getHibernateTemplate().save(entity);
	}

	public void delete(long entityId) {
		getHibernateTemplate().delete(get(entityId));
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getHibernateTemplate().find("from " + getEntityClassName());
	}

	public List<T> getLasted(int count) {
		return getPartial(1, count).getValue0();
	}

	public Pair<List<T>, Integer> getPartial(int pageIndex, int PageSize) {
		return getPartial(pageIndex, PageSize, null, null, null, null);
	}

	public Pair<List<T>, Integer> getPartial(int pageIndex, int PageSize,
			String field, String filterString) {
		return getPartial(pageIndex, PageSize, field, filterString, null, null);
	}

	public Pair<List<T>, Integer> getPartial(int pageIndex, int PageSize,
			String field, String filterString, String sortField,
			SortDirection direction) {
		String queryString = createQueryString(field, filterString, sortField,
				direction);
		List<T> results = page(pageIndex, PageSize, queryString);
		int count = count(queryString);
		return new Pair<List<T>, Integer>(results, count);
	}

	// TODO 考虑更好的实现
	private List<T> page(Integer pageIndex, Integer pageSize, String queryString) {
		List<T> results = null;

		// 分页
		int startPosition = (pageIndex - 1) * pageSize;
		int maxResults = pageSize;

		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(queryString);
			query.setFirstResult(startPosition);
			query.setMaxResults(maxResults);
			results = query.list();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}

	private Integer count(String queryString) {
		Integer count = 0;

		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String countString = "select count (*) " + queryString;
			Query query = session.createQuery(countString);
			count = ((Number) query.uniqueResult()).intValue();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	private String createQueryString(String filterField, String filterString,
			String sortField, SortDirection direction) {
		// 基本查找
		StringBuilder queryString = new StringBuilder();
		queryString
				.append(String.format("from %s as e ", getEntityClassName()));
		// 过滤
		if (!StringUtils.containsNullOrEmpty(filterField, filterString))
			queryString.append("where e." + filterField + " like '%"
					+ filterString + "%'");
		// 排序
		String sortDirection = direction == SortDirection.ASC ? "asc" : "desc";
		if (!StringUtils.isNullOrEmpty(sortField))
			queryString.append(String.format("orderby e.%s %s", sortField,
					sortDirection));

		return queryString.toString();
	}

	protected String getEntityClassName() {
		return getEntityClass().getName();
	}

	abstract Class<?> getEntityClass();
}
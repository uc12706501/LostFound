package com.lkk.lostfound.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lkk.lostfound.dao.DaoBase;

public abstract class DaoBaseImpl<T> extends HibernateDaoSupport implements
		DaoBase<T> {
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

	public List<T> getPartial(int pageSize, int pageIndex) {
		return null;
	}

	public List<T> Query(String queryString) {
		return null;
	}

	protected String getEntityClassName() {
		return getEntityClass().getName();
	}

	abstract Class getEntityClass();
}
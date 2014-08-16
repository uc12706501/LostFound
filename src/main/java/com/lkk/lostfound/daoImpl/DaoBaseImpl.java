package com.lkk.lostfound.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lkk.lostfound.dao.DaoBase;

public abstract class DaoBaseImpl<T> extends HibernateDaoSupport implements
		DaoBase<T> {
	protected HibernateTemplate hibernateTemplate = getHibernateTemplate();

	public T get(long entityId) {
		return (T) hibernateTemplate.get(getEntityClass(), entityId);
	}

	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	public Integer save(T entity) {
		return (Integer) getHibernateTemplate().save(entity);
	}

	public void delete(long entityId) {
		hibernateTemplate.delete(get(entityId));
	}

	public List<T> getAll() {
		return hibernateTemplate.find("find " + getEntityClassName());
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

package com.lkk.lostfound.daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.javatuples.Pair;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lkk.lostfound.dao.DaoBase;

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
		return getLasted(count, null);
	}

	public List<T> getLasted(int count, final Map<String, Object> params) {
		return getPartial(1, count, params).getValue0();
	}

	public Pair<List<T>, Integer> getPartial(int index, int size) {
		return getPartial(index, size, null, null, new String[] {});
	}

	public Pair<List<T>, Integer> getPartial(int index, int size,
			Map<String, Object> params) {
		return getPartial(index, size, params, null, new String[] {});
	}

	public Pair<List<T>, Integer> getPartial(final int index, final int size,
			final Map<String, Object> params, final Order order,
			final String... propertyName) {
		return new Pair<List<T>, Integer>(query(index, size, params, order,
				propertyName), getSumRecord(params));
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> query(final int index, final int size,
			final Map<String, Object> params, final Order order,
			final String... propertyName) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(org.hibernate.Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(getEntityClass());
				if (params != null && params.size() > 0)
					for (String field : params.keySet())
						criteria.add(Property.forName(field).eq(
								params.get(field)));
				if (propertyName != null && propertyName.length > 0) {
					switch (order) {
					case ASC:
						criteria.addOrder(org.hibernate.criterion.Order
								.asc(propertyName[0]));
						break;
					case DESC:
						criteria.addOrder(org.hibernate.criterion.Order
								.desc(propertyName[0]));
						break;
					}
				}
				criteria.setFirstResult((index - 1) * size);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	private Integer getSumRecord(final Map<String, Object> params) {
		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(org.hibernate.Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(getEntityClass());
						if (params != null && params.size() > 0)
							for (String field : params.keySet())
								criteria.add(Property.forName(field).eq(
										params.get(field)));
						criteria.setProjection(Projections.rowCount());
						return criteria.list().get(0);
					}
				});
	}

	protected String getEntityClassName() {
		return getEntityClass().getName();
	}

	abstract Class<T> getEntityClass();
}
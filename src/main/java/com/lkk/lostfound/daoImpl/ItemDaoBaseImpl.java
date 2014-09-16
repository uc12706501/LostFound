package com.lkk.lostfound.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.lkk.lostfound.dao.ItemDaoBase;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.User;

public abstract class ItemDaoBaseImpl<T extends ItemBase> extends
		DaoBaseImpl<T> implements ItemDaoBase<T> {

	@Override
	@SuppressWarnings("unchecked")
	public T get(final long entityId) {

		return (T) getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(getEntityClass());
				criteria.add(Property.forName("id").eq(entityId));
				criteria.setFetchMode("messages", FetchMode.EAGER);
				return criteria.list();
			}
		}).get(0);
	}

	public List<T> findByUser(User user) {
		String query = String.format("from %s where User.id='%s'",
				getEntityClass(), user.getId());
		return getHibernateTemplate().find(query);
	}

	public void switchStatus(long id) {
		ItemBase item = get(id);
		ItemStatus status = item.getStatus();
		item.setStatus(status == ItemStatus.HAS_FOUND ? ItemStatus.NOT_FOUND
				: ItemStatus.HAS_FOUND);
		getHibernateTemplate().saveOrUpdate(item);
	}
}

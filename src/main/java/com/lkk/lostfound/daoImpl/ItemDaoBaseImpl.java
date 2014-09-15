package com.lkk.lostfound.daoImpl;

import java.util.List;

import com.lkk.lostfound.dao.ItemDaoBase;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.User;

public abstract class ItemDaoBaseImpl<T extends ItemBase> extends
		DaoBaseImpl<T> implements ItemDaoBase<T> {

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

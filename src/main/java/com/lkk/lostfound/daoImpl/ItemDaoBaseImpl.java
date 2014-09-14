package com.lkk.lostfound.daoImpl;

import java.util.List;

import com.lkk.lostfound.dao.ItemDaoBase;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.User;

public abstract class ItemDaoBaseImpl<T extends ItemBase> extends
		DaoBaseImpl<T> implements ItemDaoBase<T> {

	public List<T> findByUser(User user) {
		String query = String.format("from %s where User.id='%s'",
				getEntityClass(), user.getId());
		return getHibernateTemplate().find(query);
	}
}

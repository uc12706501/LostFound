package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;

public class ItemDaoImpl extends DaoBaseImpl<ItemBase> implements ItemDao {

	@Override
	Class<ItemBase> getEntityClass() {
		return ItemBase.class;
	}

	public void switchStatus(long id) {
		ItemBase item = get(id);
		ItemStatus status = item.getStatus();
		item.setStatus(status == ItemStatus.HAS_FOUND ? ItemStatus.NOT_FOUND
				: ItemStatus.HAS_FOUND);
		getHibernateTemplate().saveOrUpdate(item);
	}

}

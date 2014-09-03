package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;

public class ItemDaoImpl extends DaoBaseImpl<ItemBase> implements ItemDao {

	@Override
	Class getEntityClass() {
		return ItemBase.class;
	}

}

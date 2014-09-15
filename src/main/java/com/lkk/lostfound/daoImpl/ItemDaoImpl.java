package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;

public class ItemDaoImpl extends ItemDaoBaseImpl<ItemBase> implements ItemDao {

	@Override
	Class<ItemBase> getEntityClass() {
		return ItemBase.class;
	}

}

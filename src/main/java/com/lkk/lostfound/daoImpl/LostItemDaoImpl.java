package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.model.LostItem;

public class LostItemDaoImpl extends ItemDaoBaseImpl<LostItem> implements
		LostItemDao {

	@Override
	Class<LostItem> getEntityClass() {
		return LostItem.class;
	}
}

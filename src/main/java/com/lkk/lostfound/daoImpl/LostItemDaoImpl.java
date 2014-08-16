package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.model.LostItem;

public class LostItemDaoImpl extends DaoBaseImpl<LostItem> implements LostItemDao{

	@Override
	Class getEntityClass() {
		return LostItem.class;
	}

}

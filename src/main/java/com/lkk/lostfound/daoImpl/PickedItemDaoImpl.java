package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.PickedItem;

public class PickedItemDaoImpl extends DaoBaseImpl<PickedItem> implements
		PickedItemDao {

	@Override
	Class getEntityClass() {
		return PickedItem.class;
	}

}

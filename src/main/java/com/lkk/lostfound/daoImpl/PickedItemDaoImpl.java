package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.PickedItem;

public class PickedItemDaoImpl extends ItemDaoBaseImpl<PickedItem> implements
		PickedItemDao {

	@Override
	Class<PickedItem> getEntityClass() {
		return PickedItem.class;
	}

}

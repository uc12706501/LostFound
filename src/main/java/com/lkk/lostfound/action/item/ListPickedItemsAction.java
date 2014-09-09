package com.lkk.lostfound.action.item;

import com.lkk.lostfound.dao.DaoBase;
import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.PickedItem;

@SuppressWarnings("serial")
public class ListPickedItemsAction extends ListActionBase<PickedItem> {

	private PickedItemDao pickedItemDao;

	@Override
	public String getClazz() {
		return "pickedItem";
	}

	@Override
	public DaoBase<PickedItem> getDao() {
		return pickedItemDao;
	}

	public void setPickedItemDao(PickedItemDao pickedItemDao) {
		this.pickedItemDao = pickedItemDao;
	}

}

package com.lkk.lostfound.action.item;

import com.lkk.lostfound.dao.DaoBase;
import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.model.LostItem;

@SuppressWarnings("serial")
public class ListLostItemsAction extends ListActionBase<LostItem> {
	private LostItemDao lostItemDao;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getClazz() {
		return "lostItem";
	}

	@Override
	public DaoBase<LostItem> getDao() {
		return lostItemDao;
	}

	public void setLostItemDao(LostItemDao lostItemDao) {
		this.lostItemDao = lostItemDao;
	}

}
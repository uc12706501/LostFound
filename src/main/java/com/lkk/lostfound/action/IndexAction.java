package com.lkk.lostfound.action;

import java.util.HashMap;
import java.util.List;

import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.LostItem;
import com.lkk.lostfound.model.PickedItem;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport implements Preparable {
	private List<LostItem> lostItems;
	private List<PickedItem> pickedItems;
	private LostItemDao lostItemDao;
	private PickedItemDao pickedItemDao;

	public static final int INDEX_MAX_ITEMS = 6;

	public void prepare() throws Exception {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("status", ItemStatus.NOT_FOUND);

		lostItems = lostItemDao.getLasted(INDEX_MAX_ITEMS, params);
		pickedItems = pickedItemDao.getLasted(INDEX_MAX_ITEMS, params);
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	// getter and setter
	public List<LostItem> getLostItems() {
		return lostItems;
	}

	public List<PickedItem> getPickedItems() {
		return pickedItems;
	}

	public void setLostItemDao(LostItemDao lostItemDao) {
		this.lostItemDao = lostItemDao;
	}

	public void setPickedItemDao(PickedItemDao pickedItemDao) {
		this.pickedItemDao = pickedItemDao;
	}

}

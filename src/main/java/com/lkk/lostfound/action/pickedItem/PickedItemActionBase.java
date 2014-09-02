package com.lkk.lostfound.action.pickedItem;

import com.lkk.lostfound.dao.PickedItemDao;
import com.opensymphony.xwork2.ActionSupport;

public class PickedItemActionBase extends ActionSupport {

	protected PickedItemDao pickedItemDao;

	public void setPickedItemDao(PickedItemDao pickedItemDao) {
		this.pickedItemDao = pickedItemDao;
	}
}

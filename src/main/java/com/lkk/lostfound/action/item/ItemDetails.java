package com.lkk.lostfound.action.item;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.LostItem;
import com.lkk.lostfound.model.PickedItem;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ItemDetails extends ActionSupport implements Preparable {

	private long id;
	private String clazz;
	private ItemDao itemDao;
	private ItemBase item;

	public void prepare() throws Exception {
		item = itemDao.get(id);
	}

	@Override
	public String execute() throws Exception {
		return clazz;
	}

	// getter and setter
	public void setId(long id) {
		this.id = id;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public PickedItem getPickedItem() {
		return (PickedItem) item;
	}

	public void setPickedItem(PickedItem pickedItem) {
		this.item = pickedItem;
	}

	public LostItem getlLostItem() {
		return (LostItem) item;
	}

	public void setLostItem(LostItem lostItem) {
		this.item = lostItem;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}

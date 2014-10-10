package com.lkk.lostfound.action.item;

import com.lkk.lostfound.dao.ItemDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	private long id;
	private ItemDao itemDao;
	private String clazz;

	@Override
	public String execute() throws Exception {
		getItemDao().delete(id);
		return SUCCESS;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}

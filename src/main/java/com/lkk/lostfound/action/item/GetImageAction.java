package com.lkk.lostfound.action.item;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GetImageAction extends ActionSupport {
	private long id;
	private ItemDao itemDao;

	public InputStream getInputStream() {
		ItemBase item = getItemDao().get(id);
		return new ByteArrayInputStream(item.getImage());
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

}

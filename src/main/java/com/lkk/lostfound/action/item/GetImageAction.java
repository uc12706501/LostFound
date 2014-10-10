package com.lkk.lostfound.action.item;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.utils.ImageUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GetImageAction extends ActionSupport {
	private long id;
	private int maxHeight;
	private ItemDao itemDao;

	public InputStream getInputStream() throws IOException {
		ItemBase item = getItemDao().get(id);
		byte[] imageBytes = item.getImage();
		if (maxHeight != 0)
			imageBytes = ImageUtils.compress(imageBytes, maxHeight, 0);
		return new ByteArrayInputStream(imageBytes);
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

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
}

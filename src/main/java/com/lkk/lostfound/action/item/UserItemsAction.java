package com.lkk.lostfound.action.item;

import java.util.List;

import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class UserItemsAction extends ActionSupport {

	private String clazz;
	private LostItemDao lostItemDao;
	private PickedItemDao pickedItemDao;
	private List<? extends ItemBase> items;

	@Override
	public String execute() throws Exception {
		getData();
		return SUCCESS;
	}

	// 获取数据
	private void getData() {
		if (clazz.equals("pickedItem")) {
			setItems(pickedItemDao.getAll());
		}
		if (clazz.equals("lostItem")) {
			setItems(lostItemDao.getAll());
		}
	}

	// getter and setter

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setLostItemDao(LostItemDao lostItemDao) {
		this.lostItemDao = lostItemDao;
	}

	public void setPickedItemDao(PickedItemDao pickedItemDao) {
		this.pickedItemDao = pickedItemDao;
	}

	public List<? extends ItemBase> getItems() {
		return items;
	}

	public void setItems(List<? extends ItemBase> items) {
		this.items = items;
	}
}

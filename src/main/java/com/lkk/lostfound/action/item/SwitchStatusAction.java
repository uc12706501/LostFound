package com.lkk.lostfound.action.item;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.opensymphony.xwork2.ActionSupport;

@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class SwitchStatusAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ItemDao itemDao;
	private long id;
	private String clazz;

	@Override
	public String execute() throws Exception {
		itemDao.switchStatus(id);
		return SUCCESS;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}

package com.lkk.lostfound.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.User;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.lkk.lostfound.security.SecurityInterceptor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class UserItemsAction extends ActionSupport implements
		ServletRequestAware, Preparable {

	private String clazz;
	private LostItemDao lostItemDao;
	private PickedItemDao pickedItemDao;
	private List<? extends ItemBase> items;
	private HttpServletRequest request;
	private User user;

	@Override
	public String execute() throws Exception {
		getData();
		return SUCCESS;
	}

	// 获取数据
	private void getData() {
		if (clazz.equals("pickedItem")) {
			setItems(pickedItemDao.findByUser(user));
		}
		if (clazz.equals("lostItem")) {
			setItems(lostItemDao.findByUser(user));
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void prepare() throws Exception {
		Object userObj = request.getSession(true).getAttribute(
				SecurityInterceptor.USER_OBJECT);
		user = userObj == null ? null : (User) userObj;
	}
}

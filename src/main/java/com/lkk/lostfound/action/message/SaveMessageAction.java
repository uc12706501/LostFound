package com.lkk.lostfound.action.message;

import java.util.Date;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class SaveMessageAction extends SingleMessageActionBase {
	private static final long serialVersionUID = 1L;

	private ItemDao itemDao;
	private long itemId;
	private String clazz;

	@Override
	@Validations(visitorFields = { @VisitorFieldValidator(fieldName = "model", message = "Default message", shortCircuit = true) })
	@RequiresAuthentication
	public String execute() throws Exception {
		ItemBase item = itemDao.get(itemId);
		message.setTime(new Date());
		message.setItem(item);
		messageDao.save(message);
		return SUCCESS;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getItemId() {
		return itemId;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}

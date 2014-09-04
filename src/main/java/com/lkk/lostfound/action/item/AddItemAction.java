package com.lkk.lostfound.action.item;

import java.io.File;

import com.lkk.lostfound.dao.ItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.LostItem;
import com.lkk.lostfound.model.PickedItem;
import com.lkk.lostfound.utils.FileUtils;
import com.lkk.lostfound.utils.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AddItemAction extends ActionSupport implements Preparable {
	private String clazz;
	private ItemBase item;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private ItemDao itemDao;
	private long id;

	// implemention of preparable
	public void prepare() throws Exception {
		if (clazz.equals("pickedItem"))
			item = new PickedItem();
		if (clazz.equals("lostItem"))
			item = new LostItem();
		item.setStatus(ItemStatus.NOT_FOUND);
	}

	// action logic
	public String input() {
		return clazz;
	}

	@Override
	public String execute() throws Exception {

		// 手动验证
		// VisitorFieldValidator visitorFieldValidator = new
		// VisitorFieldValidator();
		// visitorFieldValidator.setAppendPrefix(true);
		// visitorFieldValidator
		// .setValidatorContext(new DelegatingValidatorContext(this));
		// visitorFieldValidator.setFieldName(clazz);
		// visitorFieldValidator.setValueStack(ActionContext.getContext()
		// .getValueStack());
		// visitorFieldValidator.validate(this);

		if (hasErrors())
			return clazz;

		if (!StringUtils.isNullOrEmpty(uploadFileName)) {
			item.setImage(FileUtils.getBytesFromFile(upload));
			id = itemDao.save(item);
			return SUCCESS;
		} else {
			addFieldError("upload", "该字段不可为空");
			return clazz;
		}
	}

	// getter and setter
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getClazz() {
		return clazz;
	}

	public PickedItem getPickedItem() {
		return (PickedItem) item;
	}

	public void setPickedItem(PickedItem pickedItem) {
		this.item = pickedItem;
	}

	public LostItem getLostItem() {
		return (LostItem) item;
	}

	public void setLostItem(LostItem lostItem) {
		this.item = lostItem;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public long getId() {
		return id;
	}
}

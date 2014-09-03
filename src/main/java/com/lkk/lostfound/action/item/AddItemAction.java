package com.lkk.lostfound.action.item;

import java.io.File;

import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.LostItem;
import com.lkk.lostfound.model.PickedItem;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AddItemAction extends ActionSupport implements Preparable {
	private String clazz;
	ItemBase item;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	// implemention of preparable
	public void prepare() throws Exception {
		if (clazz == "pickeditem")
			item = new PickedItem();
		if (clazz == "lostitem")
			item = new LostItem();
		item.setStatus(ItemStatus.NOT_FOUND);
	}

	// action logic
	public String input() {
		return clazz;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	// getter and setter
	public void setClazz(String clazz) {
		this.clazz = clazz;
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

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
}

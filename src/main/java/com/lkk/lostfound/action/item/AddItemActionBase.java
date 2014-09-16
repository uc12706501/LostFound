package com.lkk.lostfound.action.item;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.lkk.lostfound.dao.ItemDaoBase;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.User;
import com.lkk.lostfound.security.SecurityInterceptor;
import com.lkk.lostfound.utils.FileUtils;
import com.lkk.lostfound.utils.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class AddItemActionBase<T extends ItemBase> extends ActionSupport
		implements Preparable, ServletRequestAware {

	protected HttpServletRequest request;
	protected long id;
	protected T item;
	protected ItemDaoBase<T> itemDao;
	protected File upload;
	protected String uploadFileName;
	protected String uploadContentType;

	public void setServletRequest(HttpServletRequest arg0) {

		this.request = arg0;
	}

	public void prepare() throws Exception {
		setItem(itemDao.get(id));
	}

	@Override
	@SkipValidation
	public String execute() throws Exception {
		return INPUT;
	}

	public String save() throws IOException {
		if (!StringUtils.isNullOrEmpty(uploadFileName)) {
			getItem().setImage(FileUtils.getBytesFromFile(upload));
			// 关联当前用户
			User user = (User) request.getSession(false).getAttribute(
					SecurityInterceptor.USER_OBJECT);
			getItem().setPublisher(user);
			getItem().setStatus(ItemStatus.NOT_FOUND);
			id = itemDao.save(getItem());
			return SUCCESS;
		} else {
			addFieldError("upload", "该字段不可为空");
			return INPUT;
			
		}
	}

	// getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ItemDaoBase<T> getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDaoBase<T> itemDao) {
		this.itemDao = itemDao;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public T getItem() {
		return item;
	}

	@VisitorFieldValidator(appendPrefix = true)
	public void setItem(T item) {
		this.item = item;
	}

}

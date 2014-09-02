package com.lkk.lostfound.action.pickedItem;

import java.io.File;
import java.io.IOException;

import com.lkk.lostfound.utils.FileUtils;
import com.lkk.lostfound.utils.StringUtils;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class CreateAction extends SinglePickedItemActionBase {
	private static final long serialVersionUID = 1L;

	private File upload;
	private String uploadFileName;
	@SuppressWarnings("unused")
	private String uploadContentType;

	@Override
	public String execute() throws Exception {
		return INPUT;
	}

	@VisitorFieldValidator(fieldName = "model", appendPrefix = false)
	public String save() throws IOException {

		boolean containFile = !StringUtils.isNullOrEmpty(uploadFileName);
		// 如果id为0，代表新建
		if (id == 0) {
			if (containFile) {
				model.setImage(FileUtils.getBytesFromFile(upload));
				// TODO 关联User
				pickedItemDao.save(model);
				return SUCCESS;
			} else {
				addFieldError("upload", "请选择文件");
				return INPUT;
			}
		}
		// 如果id不为0，则说明是修改
		else {
			if (containFile)
				model.setImage(FileUtils.getBytesFromFile(upload));
			pickedItemDao.update(model);
			return SUCCESS;
		}
	}

	public String details() {
		return "details";
	}

	// getter and setter
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

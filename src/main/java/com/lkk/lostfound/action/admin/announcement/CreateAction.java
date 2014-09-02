package com.lkk.lostfound.action.admin.announcement;

import java.io.File;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.lkk.lostfound.model.Announcement;
import com.lkk.lostfound.utils.*;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@SuppressWarnings("serial")
public class CreateAction extends SingleAnnouncementActionBase {

	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	@Override
	@SkipValidation
	public String execute() throws Exception {
		// 修改时显示图片
		return INPUT;
	}

	@Validations(visitorFields = { @VisitorFieldValidator(fieldName = "model", message = "Default Message", appendPrefix = false) })
	public String confirm() throws Exception {
		if (!StringUtils.isNullOrEmpty(uploadFileName)) {
			model.setImage(FileUtils.getBytesFromFile(upload));
			if (id == 0)
				announcementDao.save(model);
			else
				announcementDao.update(model);
			return SUCCESS;
		}
		if (id != 0) {
			announcementDao.update(model);
			return SUCCESS;
		}
		addFieldError("upload", "请选择文件");
		return INPUT;
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

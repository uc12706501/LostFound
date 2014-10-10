package com.lkk.lostfound.action.announcement;

import java.io.File;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.lkk.lostfound.utils.*;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@SuppressWarnings("serial")
@RequiresAuthentication(UserRole.Admin)
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
			// 公告的图片不进行压缩，直接保存
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

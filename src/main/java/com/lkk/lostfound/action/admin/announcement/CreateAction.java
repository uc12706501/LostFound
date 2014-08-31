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
public class CreateAction extends AnnouncementActionBase implements
		ModelDriven<Announcement>, Preparable {

	private Announcement model;
	private Long announcementId;

	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	@Override
	@SkipValidation
	public String execute() throws Exception {
		return INPUT;
	}

	@Validations(visitorFields = { @VisitorFieldValidator(fieldName = "model", message = "Default Message", appendPrefix = false) })
	public String confirm() throws Exception {
		if (!StringUtils.isNullOrEmpty(uploadFileName)) {
			model.setImage(FileUtils.getBytesFromFile(upload));
			if (model.getId() == 0)
				announcementDao.save(model);
			else
				announcementDao.update(model);
			return SUCCESS;
		}
		return INPUT;
	}

	// implement of ModelDriven
	public Announcement getModel() {
		return model;
	}

	// implement of Preparable
	public void prepare() throws Exception {

		if (announcementId == null
				|| announcementDao.get(getAnnouncementId()) == null)
			model = new Announcement();
		else
			model = announcementDao.get(getAnnouncementId());
	}

	// getter and setter
	public long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
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

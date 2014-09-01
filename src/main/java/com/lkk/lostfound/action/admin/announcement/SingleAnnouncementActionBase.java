package com.lkk.lostfound.action.admin.announcement;

import java.util.Date;

import com.lkk.lostfound.model.Announcement;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SingleAnnouncementActionBase extends AnnouncementActionBase
		implements ModelDriven<Announcement>, Preparable {

	protected Announcement model;
	protected Long announcementId;

	// implement of ModelDriven
	public Announcement getModel() {
		return model;
	}

	// implement of Preparable
	public void prepare() throws Exception {

		if (announcementId == null
				|| announcementDao.get(getAnnouncementId()) == null) {
			model = new Announcement();
			model.setCreateDate(new Date(System.currentTimeMillis()));
		} else
			model = announcementDao.get(getAnnouncementId());
	}

	// getter and setter
	public long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
	}

}

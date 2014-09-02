package com.lkk.lostfound.action.admin.announcement;

import java.util.Date;

import com.lkk.lostfound.model.Announcement;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SingleAnnouncementActionBase extends AnnouncementActionBase
		implements ModelDriven<Announcement>, Preparable {

	private static final long serialVersionUID = 1L;
	protected Announcement model;
	protected long id;

	// implement of ModelDriven
	public Announcement getModel() {
		return model;
	}

	// implement of Preparable
	public void prepare() throws Exception {

		if (id == 0 || announcementDao.get(id) == null) {
			model = new Announcement();
			model.setCreateDate(new Date(System.currentTimeMillis()));
		} else
			model = announcementDao.get(id);
	}

	// getter and setter

	public void setId(long id) {
		this.id = id;
	}

}

package com.lkk.lostfound.action.announcement;

import com.lkk.lostfound.dao.AnnouncementDao;
import com.opensymphony.xwork2.ActionSupport;

public class AnnouncementActionBase extends ActionSupport {
	private static final long serialVersionUID = 1L;
	protected AnnouncementDao announcementDao;

	// getter and setter
	public void setAnnouncementDao(AnnouncementDao announcementDao) {
		this.announcementDao = announcementDao;
	}
}

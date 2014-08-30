package com.lkk.lostfound.action.admin.announcement;

import java.util.List;

import com.lkk.lostfound.dao.AnnouncementDao;
import com.lkk.lostfound.model.Announcement;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {

	private AnnouncementDao announcementDao;
	private List<Announcement> announcements;

	@Override
	public String execute() throws Exception {
		announcements = announcementDao.getAll();
		return SUCCESS;
	}

	// getter and setter
	public void setAnnouncementDao(AnnouncementDao announcementDao) {
		this.announcementDao = announcementDao;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

}

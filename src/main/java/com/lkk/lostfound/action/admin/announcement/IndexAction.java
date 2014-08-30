package com.lkk.lostfound.action.admin.announcement;

import java.util.List;

import com.lkk.lostfound.model.Announcement;

@SuppressWarnings("serial")
public class IndexAction extends AnnouncementActionBase {
	protected List<Announcement> announcements;

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	@Override
	public String execute() throws Exception {
		announcements = announcementDao.getAll();
		return SUCCESS;
	}
}

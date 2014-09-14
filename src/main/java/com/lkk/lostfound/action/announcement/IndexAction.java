package com.lkk.lostfound.action.announcement;

import java.util.List;

import com.lkk.lostfound.model.Announcement;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;

@SuppressWarnings("serial")
@RequiresAuthentication(UserRole.Admin)
public class IndexAction extends AnnouncementActionBase {
	protected List<Announcement> announcements;

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	@Override
	@RequiresAuthentication(UserRole.Admin)
	public String execute() throws Exception {
		announcements = announcementDao.getAll();
		return SUCCESS;
	}
}

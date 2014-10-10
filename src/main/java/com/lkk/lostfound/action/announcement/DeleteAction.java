package com.lkk.lostfound.action.announcement;

import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;

@RequiresAuthentication(UserRole.Admin)
public class DeleteAction extends AnnouncementActionBase {
	private long id;

	public String execute() throws Exception {
		announcementDao.delete(id);
		return SUCCESS;
	};

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

package com.lkk.lostfound.action.announcement;

import java.util.List;

import com.lkk.lostfound.dao.AnnouncementDao;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class GetIndexAnnosAction extends ActionSupport implements Preparable {
	private AnnouncementDao announcementDao;
	private List<Long> ids;

	// implement of preparable
	public void prepare() throws Exception {
		ids = announcementDao.getDisplayIds();
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	// getter and setter
	public void setAnnouncementDao(AnnouncementDao announcementDao) {
		this.announcementDao = announcementDao;
	}

	public List<Long> getIds() {
		return ids;
	}

}

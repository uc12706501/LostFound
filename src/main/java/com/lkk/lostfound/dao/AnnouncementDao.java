package com.lkk.lostfound.dao;

import java.util.List;

import com.lkk.lostfound.model.Announcement;

public interface AnnouncementDao extends DaoBase<Announcement> {
	public List<Long> getDisplayIds();
}

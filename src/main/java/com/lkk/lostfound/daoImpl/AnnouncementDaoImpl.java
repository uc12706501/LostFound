package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.AnnouncementDao;
import com.lkk.lostfound.model.Announcement;

public class AnnouncementDaoImpl extends DaoBaseImpl<Announcement> implements AnnouncementDao {

	@Override
	Class getEntityClass() {
		return Announcement.class;
	}

}

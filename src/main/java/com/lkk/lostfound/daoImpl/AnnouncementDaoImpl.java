package com.lkk.lostfound.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import com.lkk.lostfound.dao.AnnouncementDao;
import com.lkk.lostfound.model.Announcement;

public class AnnouncementDaoImpl extends DaoBaseImpl<Announcement> implements
		AnnouncementDao {

	@Override
	Class<Announcement> getEntityClass() {
		return Announcement.class;
	}

	@SuppressWarnings("unchecked")
	public List<Long> getDisplayIds() {
		List<Long> announcements = new ArrayList<Long>();
		StringBuffer query = new StringBuffer();
		query.append("select E.id");
		query.append(String.format(" from %s E ", getEntityClassName()));
		query.append("where E.display=true ");
		announcements = getHibernateTemplate().find(query.toString());
		return announcements;
	}

}

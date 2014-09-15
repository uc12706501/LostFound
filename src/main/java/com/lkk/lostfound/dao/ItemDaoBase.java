package com.lkk.lostfound.dao;

import java.util.List;

import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.User;

public interface ItemDaoBase<T extends ItemBase> extends DaoBase<T> {
	List<T> findByUser(User user);

	void switchStatus(long id);
}

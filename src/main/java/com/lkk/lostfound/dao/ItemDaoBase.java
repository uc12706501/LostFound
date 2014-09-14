package com.lkk.lostfound.dao;

import java.util.List;

import com.lkk.lostfound.model.User;

public interface ItemDaoBase<T> extends DaoBase<T> {
	List<T> findByUser(User user);
}

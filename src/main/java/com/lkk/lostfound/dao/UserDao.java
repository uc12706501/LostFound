package com.lkk.lostfound.dao;

import com.lkk.lostfound.model.User;

public interface UserDao extends DaoBase<User> {
	User findByName(String name);

	void changePasswored(User user, String newPassword);
}

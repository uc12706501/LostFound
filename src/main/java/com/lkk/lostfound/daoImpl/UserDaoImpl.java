package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.UserDao;
import com.lkk.lostfound.model.User;

public class UserDaoImpl extends DaoBaseImpl<User> implements UserDao {

	@Override
	Class getEntityClass() {

		return User.class;
	}
}

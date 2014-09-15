package com.lkk.lostfound.daoImpl;

import java.util.List;

import com.lkk.lostfound.dao.UserDao;
import com.lkk.lostfound.model.User;

public class UserDaoImpl extends DaoBaseImpl<User> implements UserDao {

	@Override
	Class<User> getEntityClass() {
		return User.class;
	}

	public User findByName(String name) {
		String query = String.format("from User u where u.account='%s'", name);
		List<?> result = getHibernateTemplate().find(query);
		if (result.size() > 0)
			return (User) result.get(0);
		else
			return null;
	}

	public void changePasswored(User user, String newPassword) {
		user.setPassword(newPassword);
		getHibernateTemplate().saveOrUpdate(user);
	}
}

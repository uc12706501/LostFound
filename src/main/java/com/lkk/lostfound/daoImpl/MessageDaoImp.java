package com.lkk.lostfound.daoImpl;

import com.lkk.lostfound.dao.MessageDao;
import com.lkk.lostfound.model.Message;

public class MessageDaoImp extends DaoBaseImpl<Message> implements MessageDao{

	@SuppressWarnings("rawtypes")
	@Override
	Class getEntityClass() {
		return Message.class;
	}

}

package com.lkk.lostfound.action.message;

import com.lkk.lostfound.dao.MessageDao;
import com.opensymphony.xwork2.ActionSupport;

public class MessageActionBase extends ActionSupport {
	private static final long serialVersionUID = 1L;
	protected MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}

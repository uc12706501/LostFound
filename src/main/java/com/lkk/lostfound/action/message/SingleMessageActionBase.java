package com.lkk.lostfound.action.message;

import com.lkk.lostfound.model.Message;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SingleMessageActionBase extends MessageActionBase implements
		ModelDriven<Message>, Preparable {

	private static final long serialVersionUID = 1L;
	protected Message message;
	protected long id;

	public void prepare() throws Exception {
		if (id != 0 || messageDao.get(id) != null) {
			message = messageDao.get(id);
		}
		message = new Message();
	}

	public Message getModel() {
		return message;
	}

	public void setId(long id) {
		this.id = id;
	}

}

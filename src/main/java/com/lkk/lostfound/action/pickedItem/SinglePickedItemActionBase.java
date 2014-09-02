package com.lkk.lostfound.action.pickedItem;

import com.lkk.lostfound.model.ItemStatus;
import com.lkk.lostfound.model.PickedItem;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SinglePickedItemActionBase extends PickedItemActionBase implements
		ModelDriven<PickedItem>, Preparable {

	private static final long serialVersionUID = 1L;
	protected PickedItem model;
	protected long id;

	public void prepare() throws Exception {
		if (id == 0 || pickedItemDao.get(id) == null) {
			model = new PickedItem();
			model.setStatus(ItemStatus.NOT_FOUND);
		} else
			model = pickedItemDao.get(id);
	}

	public PickedItem getModel() {
		return model;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

}

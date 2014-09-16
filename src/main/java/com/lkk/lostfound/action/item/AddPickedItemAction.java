package com.lkk.lostfound.action.item;

import com.lkk.lostfound.model.PickedItem;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;

@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class AddPickedItemAction extends AddItemActionBase<PickedItem> {

	@Override
	public void prepare() throws Exception {
		super.prepare();
		if (getItem() == null)
			setItem(new PickedItem());
	}
}

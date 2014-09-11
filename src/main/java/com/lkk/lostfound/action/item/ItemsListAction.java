package com.lkk.lostfound.action.item;

import java.util.List;

import org.javatuples.Pair;

import com.lkk.lostfound.dao.LostItemDao;
import com.lkk.lostfound.dao.PickedItemDao;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.model.LostItem;
import com.lkk.lostfound.model.PickedItem;
import com.lkk.lostfound.pagination.PagedList;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class ItemsListAction extends ActionSupport {

	private LostItemDao lostItemDao;
	private PickedItemDao pickedItemDao;

	protected PagedList<? extends ItemBase> items;

	private String clazz;
	protected int pageIndex = 1;
	public static final int PAGE_SIZE = 1;
	protected String filter;

	public void prepare() throws Exception {
		if (clazz.equals("lostItem")) {
			Pair<List<LostItem>, Integer> queryResults = lostItemDao
					.getPartial(pageIndex, PAGE_SIZE, "name", filter);
			items = new PagedList<LostItem>(PAGE_SIZE, pageIndex,
					queryResults.getValue1(), queryResults.getValue0());
		}
		if (clazz.equals("pickedItem")) {
			Pair<List<PickedItem>, Integer> queryResults = pickedItemDao
					.getPartial(pageIndex, PAGE_SIZE, "name", filter);
			items = new PagedList<PickedItem>(PAGE_SIZE, pageIndex,
					queryResults.getValue1(), queryResults.getValue0());
		}
	}

	@Override
	public String execute() throws Exception {
		prepare();
		return SUCCESS;
	}

	// getter and setter
	public void setLostItemDao(LostItemDao lostItemDao) {
		this.lostItemDao = lostItemDao;
	}

	public void setPickedItemDao(PickedItemDao pickedItemDao) {
		this.pickedItemDao = pickedItemDao;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}

	public PagedList<? extends ItemBase> getItems() {
		return items;
	}
}

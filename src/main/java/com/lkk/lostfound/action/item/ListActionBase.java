package com.lkk.lostfound.action.item;

import java.util.List;

import org.javatuples.Pair;

import com.lkk.lostfound.dao.DaoBase;
import com.lkk.lostfound.model.ItemBase;
import com.lkk.lostfound.pagination.PagedList;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public abstract class ListActionBase<T extends ItemBase> extends ActionSupport
		implements Preparable {
	protected int pageIndex = 1;
	public static final int PAGE_SIZE = 9;
	protected PagedList<T> items;

	public PagedList<T> getItems() {
		return items;
	}

	public void setItems(PagedList<T> items) {
		this.items = items;
	}

	public void prepare() throws Exception {
		Pair<List<T>, Integer> itemsInfo = getDao().getPartial(pageIndex,
				PAGE_SIZE);
		setItems(new PagedList<T>(PAGE_SIZE, pageIndex, itemsInfo.getValue1(),
				itemsInfo.getValue0()));
	}

	public abstract String getClazz();

	public abstract DaoBase<T> getDao();

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}

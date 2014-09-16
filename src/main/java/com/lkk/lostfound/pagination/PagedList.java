package com.lkk.lostfound.pagination;

import java.util.Iterator;
import java.util.List;

public class PagedList<T> implements Iterator<T> {
	// 所有的数据项
	private List<T> items;
	// 每一页的记录数量
	private int pageSize;
	// 当前的页数
	private int pageIndex;
	// 总的记录数
	private int totalCount;

	// 其他信息
	private String keyWord;// 用于过滤的关键字
	private String sort;// 排序
	private int maxDisplayLink = 5;// 显示分页按钮的最大数量

	// 通过这四个参数代表了分页的主要信息
	public PagedList(int pageSize, int pageIndex, int totalCount, List<T> items) {
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.items = items;
		this.totalCount = totalCount;
		calPageInfo();
	}

	// 添加额外信息的构造函数
	public PagedList(int pageSize, int pageIndex, int totalCount,
			List<T> items, String keyWord, String sort) {
		this(pageSize, pageIndex, totalCount, items);
		this.keyWord = keyWord;
		this.sort = sort;
	}

	// 通过计算可得到的额外信息
	private int pageCount;// 总的页数
	private boolean hasNext;// 是否有下一页
	private boolean hasPrev;// 是否有上一页
	private int firstPage;// 在导航栏中第一个可点击的页码
	private int lastPage;// 在导航栏中最后一个可点击的页码

	// 通过主要的四个参数来计算其他额外的信息
	private void calPageInfo() {
		calPageCount();
		calHasNext();
		calHasPrev();
		calFirstLastPage();
	}

	private void calFirstLastPage() {
		if (pageCount <= maxDisplayLink) {
			firstPage = 1;
			lastPage = pageCount;
			return;
		}

		int leftOffset = maxDisplayLink / 2;
		int rightOffset = maxDisplayLink - leftOffset - 1;
		int left = leftOffset + 1;
		int right = pageCount - rightOffset;

		if (pageIndex <= left) {
			firstPage = 1;
			lastPage = maxDisplayLink;
			return;
		}
		if (pageIndex >= right) {
			lastPage = pageCount;
			firstPage = pageCount - maxDisplayLink + 1;
			return;
		} else {
			firstPage = pageIndex - leftOffset;
			lastPage = pageCount + rightOffset;
		}
	}

	private void calHasPrev() {
		hasPrev = pageIndex == 1 ? false : true;
	}

	private void calHasNext() {
		hasNext = pageIndex < pageCount;
	}

	private void calPageCount() {
		pageCount = totalCount / pageSize;
		pageCount += ((totalCount % pageSize) == 0 ? 0 : 1);
	}

	// getter and setter
	public List<T> getItems() {
		return items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public String getSort() {
		return sort;
	}

	public int getMaxDisplayLink() {
		return maxDisplayLink;
	}

	public void setMaxDisplayLink(int maxDisplayLink) {
		this.maxDisplayLink = maxDisplayLink;
	}

	// TODO 实现iterator接口的以下三个方法
	public boolean hasNext() {
		return false;
	}

	public T next() {
		return null;
	}

	public void remove() {

	}

}
package com.cshuig.scm.common;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable{

	private static final long serialVersionUID = 4701662870055246078L;
	
	/** 每页显示记录个数 **/
	private int pageSize;
	
	/** 每页第一条记录的索引,默认为0 **/
	private int pageIndex;
	
	/** 总的记录个数 **/
	private long totalRecord;
	
	/** 当前页 **/
	private int currentPage;
	
	/** 分页的数据 **/
	private List<T> pageDatas;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getPageDatas() {
		return pageDatas;
	}

	public void setPageDatas(List<T> pageDatas) {
		this.pageDatas = pageDatas;
	}
}

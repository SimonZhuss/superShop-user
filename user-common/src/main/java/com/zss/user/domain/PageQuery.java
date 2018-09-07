package com.zss.user.domain;

/**
 * 分页入参基类
 * @author zhushanshan
 * 2017年10月17日 下午2:32:10
 */
public class PageQuery {
	private Integer pageNo;
	private Integer pageSize;
	
	private Integer currentPageIndex;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPageIndex() {
		this.currentPageIndex = ((pageNo<=0?0:pageNo)-1)*pageSize;
		return currentPageIndex;
	}
	public void setCurrentPageIndex(Integer currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
}

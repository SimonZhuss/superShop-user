package com.zss.user.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:分页Page实体类
 * @auther zhushanshan
 * @since 2017年11月15日下午3:40:35
 */
public class Page<T> implements Serializable{

	private static final long serialVersionUID = 2626585127466370060L;
	
	/**当前页面 */
	private Integer pageNo = 1;
	/**每页几行*/
	private Integer pageSize = 10;
	/**行总数*/
	private Integer totalRecordsCount;
	/**总页数**/
	private Integer totalPage;		
	
	private List<T> list;
	
	public Page(){
		
	}

	public Integer getTotalPage() {
		int n = this.totalRecordsCount / this.pageSize;
		if(this.totalRecordsCount % this.pageSize != 0){
			n++;
		}
		this.totalPage = n;
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public Integer getPageNo() {
		return pageNo;
	}


	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}


	public Integer getPageSize() {
		return pageSize == null ? 10 : pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalRecordsCount() {
		return totalRecordsCount;
	}

	public void setTotalRecordsCount(Integer totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}


	public Integer currentPageIndex(){
		return ((pageNo<=0?0:pageNo)-1)*getPageSize();
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}

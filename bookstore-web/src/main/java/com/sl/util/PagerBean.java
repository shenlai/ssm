package com.sl.util;

import java.util.Collection;

public class PagerBean {
	
	/**
	 * 当前页码
	 */
	private int pageNumber;
	/**
	 * 总页数
	 */
	private int pageCount;
	/**
	 * 每页记录数
	 */
	private int pageSize;
	/**
	 * 总记录数
	 */
	private int recordCount;
	/**
	 * 查询起始
	 */
	private int start;
	/**
	 * 查询截止
	 */
	private int end;
	/**
	 * 查询关键字
	 */
	private String keyword;
	/**
	 * 查询字段
	 */
	private String field;
	/**
	 * 排序字段
	 */
	private String orderField;
	/**
	 * 升序还是降序
	 */
	private String sc;
	
	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	
	
	public void setData(int recordCount){ 
		this.start = (this.pageNumber-1) * this.pageSize;
		
		this.end = this.pageSize;
		
		this.pageCount = recordCount / pageSize;
		 
		
		if(recordCount%pageSize != 0){
			this.pageCount++;
		}
		if(this.pageNumber > this.pageCount){
			this.pageNumber = this.pageCount;
		}
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getRecordCount() {
		return recordCount;
	}
	
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	 

}

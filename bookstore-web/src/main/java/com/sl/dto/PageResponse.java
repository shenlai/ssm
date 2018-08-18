package com.sl.dto;

import java.util.List;

import com.sl.entity.Shop;

public class PageResponse<T> extends ComResponse {
	
	private int totalCount;
	
	private List<T> dataList;
	
	public PageResponse() {
		// TODO 自动生成的构造函数存根
	}
	
	public PageResponse(int totalCount,List<T> list) {
		super();
		this.totalCount = totalCount;
		dataList = list;
	}
	
	public PageResponse(boolean success, int errorCode, String errorMsg) {
		super(success,errorCode,errorMsg);
	}
	
	
	
	
	

	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	

}

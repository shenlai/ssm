package com.sl.dto;

public class ListResponse<T> extends ComResponse {

	private T data;

	public ListResponse() {
	}
	
	public ListResponse(boolean success, T data) {
		super.setSuccess(true);
		this.data = data;
	}

	public ListResponse(boolean success, int errorCode, String errorMsg) {
		super(success,errorCode,errorMsg);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

package com.sl.dto;

public class DataResponse<T> extends ComResponse {

	private T data;

	public DataResponse() {
	}
	
	public DataResponse(boolean success, T data) {
		super.setSuccess(true);
		this.data = data;
	}

	public DataResponse(boolean success, int errorCode, String errorMsg) {
		super(success,errorCode,errorMsg);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

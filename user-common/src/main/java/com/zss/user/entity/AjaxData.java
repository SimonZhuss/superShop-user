package com.zss.user.entity;


public class AjaxData<T>{

	private String code;
	private String message;
	private T data;

	public AjaxData(Boolean success) {
		super();
	}
	
	public AjaxData() {
		super();
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}

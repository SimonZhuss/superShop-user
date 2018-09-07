package com.zss.user.constants;

public enum UserRespEnum {
	//请求结果响应码
	SUCCESS("0000", "成功"),
	PROCESSING("0001", "请求处理中"),

	//通用业务响应码
	BUSINESS_ERROR("5000", "业务异常"),
	PARAM_ERROR("5001", "参数错误"),
	NULL_DATA("5002","响应体为空"),
	REPEAT_DATA("5003","数据重复"),
	DATA_ENCRYPT_ERROR("5004","数据加密错误"),	
	DATA_DECRYPT_ERROR("5005","数据解密错误"),	
	//系统响应码
	SYSTEM_ERROR("9999", "系统异常");
	
	UserRespEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private String code;
	private String message;

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
}

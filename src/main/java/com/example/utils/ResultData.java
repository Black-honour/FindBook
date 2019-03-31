package com.example.utils;

public class ResultData<T> {

	private T data;//数据

	private int code = 200;//状态码

	private Boolean success = true;//状态
	
	private String msg;//提示信息

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		if (code != 200) {
			success = false;
		}
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResultData [data=" + data + ", code=" + code + ", success=" + success + ", msg=" + msg + "]";
	}
	
}
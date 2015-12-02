package com.subang.bean;

public class BasePrepayResult {

	public enum Code {
		succ, fail, conti
	};

	protected Integer code;
	protected String msg; // 如果code为fail，给出原因

	public BasePrepayResult() {
	}

	public BasePrepayResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public Code getCodeEnum() {
		return Code.values()[code];
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setCode(Code code) {
		this.code = code.ordinal();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

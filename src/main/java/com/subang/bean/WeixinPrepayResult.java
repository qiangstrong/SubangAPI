package com.subang.bean;

public class WeixinPrepayResult extends BasePrepayResult {

	private static final long serialVersionUID = 1L;

	private WeixinPayRequest arg;

	public WeixinPrepayResult() {
	}

	public WeixinPrepayResult(Integer code, String msg, WeixinPayRequest arg) {
		super(code, msg);
		this.arg = arg;
	}

	public WeixinPayRequest getArg() {
		return arg;
	}

	public void setArg(WeixinPayRequest arg) {
		this.arg = arg;
	}

}

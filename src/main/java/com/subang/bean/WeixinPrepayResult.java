package com.subang.bean;

public class WeixinPrepayResult extends BasePrepayResult {
	private PayAppRequest arg;

	public WeixinPrepayResult() {
	}

	public WeixinPrepayResult(Integer code, String msg, PayAppRequest arg) {
		super(code, msg);
		this.arg = arg;
	}

	public PayAppRequest getArg() {
		return arg;
	}

	public void setArg(PayAppRequest arg) {
		this.arg = arg;
	}

}

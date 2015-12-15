package com.subang.bean;

public class AliPrepayResult extends BasePrepayResult {

	private static final long serialVersionUID = 1L;

	private String arg;

	public AliPrepayResult() {
	}

	public AliPrepayResult(Integer code, String msg, String arg) {
		super(code, msg);
		this.arg = arg;
	}

	public String getArg() {
		return arg;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}
}

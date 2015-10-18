package com.subang.bean;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import com.subang.util.ComUtil;

public class AppArg {
	private Integer type;
	private String cellnum;
	private String password;
	private String timestamp;
	private String signature;

	public AppArg() {
	}

	public AppArg(Integer type, String cellnum, String password, String timestamp, String signature) {
		this.type = type;
		this.cellnum = cellnum;
		this.password = password;
		this.timestamp = timestamp;
		this.signature = signature;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCellnum() {
		return cellnum;
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public void generate() {
		timestamp = ComUtil.getTimestamp();
		signature = new String(Hex.encodeHex(DigestUtils.sha(cellnum + password + timestamp)));
	}
}

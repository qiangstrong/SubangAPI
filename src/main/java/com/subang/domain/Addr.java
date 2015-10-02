package com.subang.domain;

import java.io.Serializable;

import com.subang.bean.Result;

public class Addr extends Result implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected Boolean valid;
	protected String name;
	protected String cellnum;
	protected String detail;
	protected Integer userid;
	protected Integer regionid;

	public Addr() {
		this.valid = true;
	}

	public Addr(Integer id, Boolean valid, String name, String cellnum, String detail,
			Integer userid, Integer regionid) {
		this.id = id;
		this.valid = valid;
		this.name = name;
		this.cellnum = cellnum;
		this.detail = detail;
		this.userid = userid;
		this.regionid = regionid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellnum() {
		return cellnum;
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getRegionid() {
		return regionid;
	}

	public void setRegionid(Integer regionid) {
		this.regionid = regionid;
	}

}

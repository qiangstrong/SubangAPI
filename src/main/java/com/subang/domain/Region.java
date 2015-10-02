package com.subang.domain;

import java.io.Serializable;

import com.subang.bean.Result;

public class Region extends Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer districtid;
	private Integer workerid;

	public Region() {
	}

	public Region(Integer id, String name, Integer districtid, Integer workerid) {
		this.id = id;
		this.name = name;
		this.districtid = districtid;
		this.workerid = workerid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}

	public Integer getWorkerid() {
		return workerid;
	}

	public void setWorkerid(Integer workerid) {
		this.workerid = workerid;
	}

}

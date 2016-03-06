package com.subang.domain;

import java.io.Serializable;

public class Snapshot implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String icon;
	private Integer clothesid;

	public Snapshot() {
	}

	public Snapshot(Integer id, String icon, Integer clothesid) {
		this.id = id;
		this.icon = icon;
		this.clothesid = clothesid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getClothesid() {
		return clothesid;
	}

	public void setClothesid(Integer clothesid) {
		this.clothesid = clothesid;
	}
}

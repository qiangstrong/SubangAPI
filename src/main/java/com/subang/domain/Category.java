package com.subang.domain;

import java.io.Serializable;

public class Category implements Serializable {

	public static String iconPath = "image/info/category/";

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Boolean valid;
	private String name;
	private String icon;
	private String comment;

	public Category() {
	}

	public Category(Integer id, Boolean valid, String name, String icon, String comment) {
		super();
		this.id = id;
		this.valid = valid;
		this.name = name;
		this.icon = icon;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getValid() {
		return valid;
	}

	public String getValidDes() {
		if (valid == null) {
			return null;
		}
		if (valid) {
			return "是";
		}
		return "否";
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void calcIcon(String icon) {
		this.icon = iconPath + icon;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

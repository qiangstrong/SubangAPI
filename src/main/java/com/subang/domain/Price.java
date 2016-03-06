package com.subang.domain;

import java.io.Serializable;

public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String comment;
	private Integer categoryid;

	public Price() {
	}

	public Price(Integer id, String name, String comment, Integer categoryid) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.categoryid = categoryid;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
}

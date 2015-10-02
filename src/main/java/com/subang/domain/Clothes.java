package com.subang.domain;

import java.io.Serializable;

import com.subang.bean.Result;

public class Clothes extends Result implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String color;
	private String flaw;
	private Integer orderid;

	public Clothes() {
	}

	public Clothes(Integer id, String name, String color, String flaw, Integer orderid) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.flaw = flaw;
		this.orderid = orderid;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFlaw() {
		return flaw;
	}

	public void setFlaw(String flaw) {
		this.flaw = flaw;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}

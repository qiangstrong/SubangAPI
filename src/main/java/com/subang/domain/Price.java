package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double money;
	private String comment;
	private Integer categoryid;

	public Price() {
	}

	public Price(Integer id, Double money, String comment, Integer categoryid) {
		this.id = id;
		this.money = money;
		this.comment = comment;
		this.categoryid = categoryid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public String getMoneyDes() {
		return String.valueOf(Math.round(money));
	}

	public void setMoney(Double money) {
		this.money = ComUtil.round(money, 0);
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

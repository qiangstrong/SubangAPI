package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class Cost implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double money;
	private Integer laundryid;
	private Integer articleid;

	private String articlename;

	public Cost() {
	}

	public Cost(Integer id, Double money, Integer laundryid, Integer articleid, String articlename) {
		this.id = id;
		this.money = money;
		this.laundryid = laundryid;
		this.articleid = articleid;
		this.articlename = articlename;
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
		return ComUtil.getDes(money);
	}

	public void setMoney(Double money) {
		this.money = ComUtil.round(money);
	}

	public Integer getLaundryid() {
		return laundryid;
	}

	public void setLaundryid(Integer laundryid) {
		this.laundryid = laundryid;
	}

	public Integer getArticleid() {
		return articleid;
	}

	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}

	public String getArticlename() {
		return articlename;
	}

	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
}

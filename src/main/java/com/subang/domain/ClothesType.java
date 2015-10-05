package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class ClothesType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String icon;
	private Integer categoryid;
	private Integer priceid;

	private Double money;

	public ClothesType() {
	}

	public ClothesType(Integer id, String name, String icon, Integer categoryid, Integer priceid,
			Double money) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.categoryid = categoryid;
		this.priceid = priceid;
		this.setMoney(money);
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getPriceid() {
		return priceid;
	}

	public void setPriceid(Integer priceid) {
		this.priceid = priceid;
	}

	public Double getMoney() {
		return money;
	}

	public String getMoneyDes() {
		return ComUtil.getDes(money);
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}

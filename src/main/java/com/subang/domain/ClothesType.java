package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class ClothesType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Double money; // 单位元
	private String icon;
	private Integer categoryid;
	private Integer priceid;

	private String pricename;

	public ClothesType() {
	}

	public ClothesType(Integer id, String name, Double money, String icon, Integer categoryid,
			Integer priceid, String pricename) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.icon = icon;
		this.categoryid = categoryid;
		this.priceid = priceid;
		this.pricename = pricename;
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

	public Double getMoney() {
		return money;
	}

	public String getMoneyDes() {
		return ComUtil.getDes(money);
	}

	public void setMoney(Double money) {
		this.money = ComUtil.round(money);
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

	public String getPricename() {
		return pricename;
	}

	public void setPricename(String pricename) {
		this.pricename = pricename;
	}
}

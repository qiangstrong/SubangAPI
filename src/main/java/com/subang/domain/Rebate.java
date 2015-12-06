package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class Rebate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double money; // 单位元,注意使用ComUtil.round函数取一位小数。
	private Double benefit; // 单位元,注意使用ComUtil.round函数取一位小数。

	public Rebate() {
	}

	public Rebate(Integer id, Double money, Double benefit) {
		super();
		this.id = id;
		this.money = money;
		this.benefit = benefit;
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

	public void setMoney(Double money) {
		this.money = ComUtil.round(money);
	}

	public Double getBenefit() {
		return benefit;
	}

	public void setBenefit(Double benefit) {
		this.benefit = ComUtil.round(benefit);
	}

	public String toString() {
		if (money == null || benefit == null) {
			return null;
		}
		return "充" + Math.round(money) + "送" + Math.round(benefit);
	}
}

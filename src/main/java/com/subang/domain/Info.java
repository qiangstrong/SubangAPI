package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class Info implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String phone;
	private Double shareMoney;
	private Double salaryLimit;
	private Integer prom0;
	private Integer prom1;
	private Integer prom2;

	public Info() {
	}

	public Info(Integer id, String phone, Double shareMoney, Double salaryLimit, Integer prom0,
			Integer prom1, Integer prom2) {
		this.id = id;
		this.phone = phone;
		this.shareMoney = shareMoney;
		this.salaryLimit = salaryLimit;
		this.prom0 = prom0;
		this.prom1 = prom1;
		this.prom2 = prom2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getShareMoney() {
		return shareMoney;
	}

	public void setShareMoney(Double shareMoney) {
		this.shareMoney = ComUtil.round(shareMoney);
	}

	public Double getSalaryLimit() {
		return salaryLimit;
	}

	public void setSalaryLimit(Double salaryLimit) {
		this.salaryLimit = ComUtil.round(salaryLimit);
	}

	public Integer getProm0() {
		return prom0;
	}

	public void setProm0(Integer prom0) {
		this.prom0 = prom0;
	}

	public Integer getProm1() {
		return prom1;
	}

	public void setProm1(Integer prom1) {
		this.prom1 = prom1;
	}

	public Integer getProm2() {
		return prom2;
	}

	public void setProm2(Integer prom2) {
		this.prom2 = prom2;
	}
}

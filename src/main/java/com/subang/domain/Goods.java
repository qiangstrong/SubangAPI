package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class Goods implements Serializable {

	public static String iconPath = "image/info/goods/";
	public static String posterPath = "image/info/poster/";

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String icon;
	private String poster;
	private Double money;
	private Integer score;
	private Integer count;
	private String comment;

	public Goods() {
	}

	public Goods(Integer id, String name, String icon, String poster, Double money, Integer score,
			Integer count, String comment) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.poster = poster;
		this.money = money;
		this.score = score;
		this.count = count;
		this.comment = comment;
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = ComUtil.round(money);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

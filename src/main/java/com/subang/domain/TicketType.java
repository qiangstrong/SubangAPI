package com.subang.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.subang.util.ComUtil;

public class TicketType implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected String name;
	protected String icon;
	protected String poster;
	protected Double money;
	protected Integer score;
	protected Timestamp deadline;
	protected String comment;
	protected Integer categoryid;

	protected String categoryname;

	public TicketType() {
	}

	public TicketType(Integer id, String name, String icon, String poster, Double money,
			Integer score, Timestamp deadline, String comment, Integer categoryid,
			String categoryname) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.poster = poster;
		this.money = money;
		this.score = score;
		this.deadline = deadline;
		this.categoryid = categoryid;
		this.categoryname = categoryname;
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

	public Timestamp getDeadline() {
		return deadline;
	}

	public String getDeadlineDes() {
		if (deadline == null) {
			return "无期限";
		}
		return new Date(deadline.getTime()).toString();
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
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

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
}

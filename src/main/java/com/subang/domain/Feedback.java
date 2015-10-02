package com.subang.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.subang.bean.Result;

public class Feedback extends Result implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Timestamp time;
	private String comment;

	public Feedback() {
	}

	public Feedback(Integer id, Timestamp time, String comment) {
		this.id = id;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

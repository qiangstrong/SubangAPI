package com.subang.domain;

import java.io.Serializable;

public class Banner implements Serializable {

	public static String iconPath = "image/info/banner/";

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String link;
	private String icon; // 由后台生成，不用@NotNull校验
	private String comment;

	public Banner() {
	}

	public Banner(Integer id, String link, String icon, String comment) {
		super();
		this.id = id;
		this.link = link;
		this.icon = icon;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void calcIcon(String icon) {
		this.icon = iconPath + icon;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

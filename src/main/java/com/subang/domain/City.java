package com.subang.domain;

import java.io.Serializable;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String scope;
	private String scopeText;

	public City() {
	}

	public City(Integer id, String name, String scope, String scopeText) {
		super();
		this.id = id;
		this.name = name;
		this.scope = scope;
		this.scopeText = scopeText;
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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getScopeText() {
		return scopeText;
	}

	public void setScopeText(String scopeText) {
		this.scopeText = scopeText;
	}

}

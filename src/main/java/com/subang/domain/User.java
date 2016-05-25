package com.subang.domain;

import java.io.Serializable;

import com.subang.util.ComUtil;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Client {
		weixin, user, worker, back, promotion;

		public static String toClientDes(Client client) {
			if (client == null) {
				return "未知";
			}
			String description = null;
			switch (client) {
			case weixin:
				description = "微信";
				break;
			case user:
				description = "app";
				break;
			case worker:
				description = "app";
				break;
			case back:
				description = "后台";
				break;
			case promotion:
				description = "推广";
				break;
			}
			return description;
		}
	}

	private Integer id;
	private Boolean login;
	private String openid;
	private String userno;
	private String nickname;
	private String password;
	private String cellnum;
	private Integer score;
	private Double money;
	private Double salary;
	private Integer client;
	private Integer addrid; // 用户的默认地址
	private Integer userid;

	public User() {
		this.login = false;
	}

	public User(Integer id, Boolean login, String openid, String userno, String nickname,
			String password, String cellnum, Integer score, Double money, Double salary,
			Integer client, Integer addrid, Integer userid) {
		super();
		this.id = id;
		this.login = login;
		this.openid = openid;
		this.userno = userno;
		this.nickname = nickname;
		this.password = password;
		this.cellnum = cellnum;
		this.score = score;
		this.money = money;
		this.salary = salary;
		this.client = client;
		this.addrid = addrid;
		this.userid = userid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUserno() {
		return userno;
	}

	public String getUsernoDes() {
		return ComUtil.getDes(userno);
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellnum() {
		return cellnum;
	}

	public String getHiddenCellnum() {
		if (cellnum == null) {
			return null;
		}
		return ComUtil.hideCellnum(cellnum);
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = ComUtil.round(money);
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = ComUtil.round(salary);
	}

	public Integer getClient() {
		return client;
	}

	public Client getClientEnum() {
		if (client == null) {
			return null;
		}
		return Client.values()[client];
	}

	public String getClientDes() {
		return Client.toClientDes(getClientEnum());
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public void setClient(Client client) {
		this.client = client.ordinal();
	}

	public Integer getAddrid() {
		return addrid;
	}

	public void setAddrid(Integer addrid) {
		this.addrid = addrid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}

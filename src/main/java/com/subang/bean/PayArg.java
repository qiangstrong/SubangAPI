package com.subang.bean;

import java.io.Serializable;

import com.subang.domain.Payment.PayType;
import com.subang.domain.User.Client;
import com.subang.util.ComUtil;

public class PayArg implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer client; // 微信端，不传此参数；app端传此参数
	private Integer payType;
	private Integer orderid;
	private Integer ticketid; // 若没有使用优惠券，不传参数即可。后台得到的为null
	private Double money; // 对于订单支付，不传此参数

	public PayArg() {
	}

	public PayArg(Integer client, Integer payType, Integer orderid, Integer ticketid, Double money) {
		super();
		this.client = client;
		this.payType = payType;
		this.orderid = orderid;
		this.ticketid = ticketid;
		this.money = money;
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

	public void setClient(Integer client) {
		this.client = client;
	}

	public void setClient(Client client) {
		this.client = client.ordinal();
	}

	public Integer getPayType() {
		return payType;
	}

	public PayType getPayTypeEnum() {
		if (payType == null) {
			return null;
		}
		return PayType.values()[payType];
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType.ordinal();
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = ComUtil.round(money);
	}

}

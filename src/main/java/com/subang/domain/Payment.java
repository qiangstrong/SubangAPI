package com.subang.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.subang.util.ComUtil;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum PayType {
		balance, weixin, alipay, cash;
		public static PayType toPayType(String arg) {
			return PayType.values()[new Integer(arg)];
		}

		public static String toPayTypeDes(PayType payType) {
			if (payType == null) {
				return "未支付";
			}
			String description = null;
			switch (payType) {
			case balance:
				description = "余额";
				break;
			case weixin:
				description = "微信";
				break;
			case alipay:
				description = "支付宝";
				break;
			case cash:
				description = "现金";
				break;
			}
			return description;
		}
	}

	private Integer id;
	private Integer type;
	private Double moneyTicket;
	private String prepay_id; // 微信预支付id
	private Timestamp time;
	private String orderno;

	public Payment() {
		this.moneyTicket = 0.0;
	}

	public Payment(Integer id, Integer type, Double moneyTicket, String prepay_id, Timestamp time,
			String orderno) {
		this.id = id;
		this.type = type;
		this.moneyTicket = moneyTicket;
		this.prepay_id = prepay_id;
		this.time = time;
		this.orderno = orderno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public PayType getTypeEnum() {
		if (type == null) {
			return null;
		}
		return PayType.values()[type];
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setType(PayType type) {
		this.type = type.ordinal();
	}

	public Double getMoneyTicket() {
		return moneyTicket;
	}

	public void setMoneyTicket(Double moneyTicket) {
		this.moneyTicket = ComUtil.round(moneyTicket);
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

}

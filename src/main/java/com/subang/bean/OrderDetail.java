package com.subang.bean;

import java.sql.Date;

import com.subang.domain.Order;
import com.subang.domain.Payment.PayType;
import com.subang.util.ComUtil;

public class OrderDetail extends Order {

	private static final long serialVersionUID = 1L;

	private String categoryname;
	private String cellnum;
	private Integer payType;
	private Double moneyTicket;
	private String addrname; // 订单地址中填写的姓名
	private String addrcellnum; // 订单地址中填写的手机号
	private String cityname;
	private String districtname;
	private String regionname;
	private String addrdetail;
	private String workername;
	private String workercellnum;

	public OrderDetail() {
	}

	public OrderDetail(Integer id, String orderno, Integer state, Double money, Double freight,
			Date date, Integer time, String userComment, String workerComment, String remark,
			String barcode, Integer categoryid, Integer userid, Integer addrid, Integer workerid,
			Integer laundryid, String categoryname, String cellnum, Integer payType,
			Double moneyTicket, String addrname, String addrcellnum, String cityname,
			String districtname, String regionname, String addrdetail, String workername,
			String workercellnum) {
		super(id, orderno, state, money, freight, date, time, userComment, workerComment, remark,
				barcode, categoryid, userid, addrid, workerid, laundryid);
		this.categoryname = categoryname;
		this.cellnum = cellnum;
		this.payType = payType;
		this.moneyTicket = moneyTicket;
		this.addrname = addrname;
		this.addrcellnum = addrcellnum;
		this.cityname = cityname;
		this.districtname = districtname;
		this.regionname = regionname;
		this.addrdetail = addrdetail;
		this.workername = workername;
		this.workercellnum = workercellnum;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCellnum() {
		return cellnum;
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
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

	public String getPayTypeDes() {
		if (payType == null) {
			return "未支付";
		}
		String description = null;
		switch (getPayTypeEnum()) {
		case balance:
			description = "余额";
			break;
		case weixin:
			description = "微信";
			break;
		case alipay:
			description = "支付宝";
			break;
		}
		return description;
	}

	public String getPaymentDes() {
		String description = "";
		description += "订单￥" + getMoneyDes() + "+";
		description += "运费￥" + getFreightDes() + "-";
		description += "优惠券￥" + getMoneyTicket();
		return description;
	}

	public String getTotalMoneyDes() {
		Double totalMoney;
		if (money == null || freight == null) {
			totalMoney = null;
		} else {
			totalMoney = money + freight;
		}
		return ComUtil.getDes(totalMoney);
	}

	public String getActualMoneyDes() {
		Double actualMoney;
		if (money == null || freight == null || moneyTicket == null) {
			actualMoney = null;
		} else {
			actualMoney = money + freight - moneyTicket;
		}
		return ComUtil.getDes(actualMoney);
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Double getMoneyTicket() {
		return moneyTicket;
	}

	public void setMoneyTicket(Double moneyTicket) {
		this.moneyTicket = moneyTicket;
	}

	public String getAddrname() {
		return addrname;
	}

	public void setAddrname(String addrname) {
		this.addrname = addrname;
	}

	public String getAddrcellnum() {
		return addrcellnum;
	}

	public void setAddrcellnum(String addrcellnum) {
		this.addrcellnum = addrcellnum;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public String getAddrdetail() {
		return addrdetail;
	}

	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public String getWorkercellnum() {
		return workercellnum;
	}

	public void setWorkercellnum(String workercellnum) {
		this.workercellnum = workercellnum;
	}
}

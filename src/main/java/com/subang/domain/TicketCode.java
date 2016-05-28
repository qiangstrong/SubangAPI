package com.subang.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class TicketCode implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Boolean valid;
	private String codeno;
	private Timestamp start;
	private Timestamp end;
	protected Integer ticketTypeid;

	public TicketCode() {
		this.valid = true;
	}

	public TicketCode(Integer id, Boolean valid, String codeno, Timestamp start, Timestamp end,
			Integer ticketTypeid) {
		this.id = id;
		this.valid = valid;
		this.codeno = codeno;
		this.start = start;
		this.end = end;
		this.ticketTypeid = ticketTypeid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getValid() {
		return valid;
	}

	public String getValidDes() {
		if (valid == null) {
			return null;
		}
		if (valid) {
			return "未兑换";
		}
		return "已兑换";
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getCodeno() {
		return codeno;
	}

	public void setCodeno(String codeno) {
		this.codeno = codeno;
	}

	public Timestamp getStart() {
		return start;
	}

	public String getStartDes() {
		if (start == null) {
			return null;
		}
		return new Date(start.getTime()).toString();
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public String getEndDes() {
		if (end == null) {
			return null;
		}
		return new Date(end.getTime()).toString();
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public Integer getTicketTypeid() {
		return ticketTypeid;
	}

	public void setTicketTypeid(Integer ticketTypeid) {
		this.ticketTypeid = ticketTypeid;
	}

	// 优惠券是否在有效期内
	public Boolean isUsable() {
		if (start == null || end == null) {
			return null;
		}
		Timestamp now = new Timestamp(System.currentTimeMillis());
		if (start.before(now) && end.after(now)) {
			return true;
		}
		return false;
	}

}

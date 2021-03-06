package com.subang.util;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Qiang 下单页取件时间相关的流程
 */
public class TimeUtil extends BaseUtil {

	public static final int TIME_START = 7;
	public static final int TIME_END = 20;
	public static final int TIME_DELAY = 1;
	public static final int TIME_THRESHOLD = TIME_END - TIME_DELAY;
	public static final int DATE_NUM = 5;

	public static class Option implements Serializable {

		private static final long serialVersionUID = 1L;

		private String text;
		private Object value;

		public Option() {
		}

		public Option(String text, Object value) {
			this.text = text;
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

	}

	public static List<Option> getDateOptions() {
		List<Option> dates = new ArrayList<Option>();

		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour >= TIME_THRESHOLD) {
			calendar.add(Calendar.DATE, 1);
		}
		Date date = null;
		for (int i = 0; i < DATE_NUM; i++) {
			date = new Date(calendar.getTime().getTime());
			dates.add(new Option(ComUtil.getDateDes(date), date));
			calendar.add(Calendar.DATE, 1);
		}
		return dates;
	}

	/**
	 * DATE_THRESHOLD减1，是为了防止异步获取时间时，用户获取到当日的时间段为空
	 */
	public static List<Option> getTimeOptions(Date date) {
		List<Option> dates = new ArrayList<Option>();

		Calendar calendar = Calendar.getInstance();
		Date curDate = new Date(calendar.getTime().getTime());

		int curHour = calendar.get(Calendar.HOUR_OF_DAY);
		int hour = TIME_START;
		if ((date.toString()).equals(curDate.toString())) {
			hour = curHour + TIME_DELAY;
			if (hour < TIME_START)
				hour = TIME_START;
		}
		for (; hour < TIME_END; hour++) {
			dates.add(new Option(ComUtil.getTimeDes(hour), hour));
		}
		return dates;
	}

}

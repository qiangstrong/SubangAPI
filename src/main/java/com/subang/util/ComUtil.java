package com.subang.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;

import com.subang.bean.Result;

/**
 * @author Qiang 与业务无关的公用函数
 */
public class ComUtil extends BaseUtil {

	public static Random random = new Random();
	public static Timer timer = new Timer();
	public static NumberFormat nf = NumberFormat.getInstance();
	public static SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf_datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf_timestamp = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String getLikeStr(String str) {
		return "%" + str + "%";
	}

	public static <T> T getFirst(List<T> list) {
		T t = null;
		if (list != null && !list.isEmpty()) {
			t = list.get(0);
		}
		return t;
	}

	// 把一个整数转换为固定长度的字符串
	public static String intToStr(int value, int length) {
		nf.setGroupingUsed(false);
		nf.setMaximumIntegerDigits(length);
		nf.setMinimumIntegerDigits(length);
		return nf.format(value);
	}

	// 生成指定长度的由数字组成的随机字符串
	public static String getRandomStr(int length) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < length; i++) {
			str.append(ComUtil.random.nextInt(10));
		}
		return str.toString();
	}

	public static String getDes(Object object) {
		if (object == null) {
			return "未确定";
		}
		return object.toString();
	}

	public static String getDateDes(Date date) {
		if (date == null) {
			return null;
		}
		return date.toString();
	}

	public static String getTimeDes(Integer time) {
		if (time == null) {
			return null;
		}
		String description = "";
		description = time + ":00-" + (time + 1) + ":00";
		return description;
	}

	public static Date toDate(String dateValue) {
		Date date = null;
		try {
			date = new Date(ComUtil.sdf_date.parse(dateValue).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean isTaday(Long time) {
		Calendar calendar_cur = Calendar.getInstance();
		Calendar calendar_old = Calendar.getInstance();
		calendar_old.setTimeInMillis(time);
		int day_cur = calendar_cur.get(Calendar.DAY_OF_YEAR);
		int day_old = calendar_old.get(Calendar.DAY_OF_YEAR);
		if (day_cur == day_old) {
			return true;
		} else {
			return false;
		}
	}

	public static String getTimestamp() {
		java.util.Date date = new java.util.Date();
		return sdf_timestamp.format(date);
	}

	public static Map<String, String> listToMap(List<Result> results) {
		if (results == null) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		for (Result result : results) {
			map.put(result.getCode(), result.getMsg());
		}
		return map;
	}

	public static Double round(Double d) {
		if (d == null) {
			return null;
		}
		return BigDecimal.valueOf(d).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static Double round(Double d, int scale) {
		if (d == null) {
			return null;
		}
		return BigDecimal.valueOf(d).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static boolean equal(double d1, double d2) {
		if (Math.abs(d1 - d2) < 0.1) {
			return true;
		}
		return false;
	}

	// 计算文件的后缀名
	public static String getSuffix(String filename) {
		int index = filename.lastIndexOf(".");
		if (index == -1) {
			return "";
		}
		return filename.substring(index);
	}

	public static String hideCellnum(String cellnum) {
		StringBuffer cellnumBuffer = new StringBuffer();
		int i = 0;
		for (; i < 3; i++) {
			cellnumBuffer.append(cellnum.charAt(i));
		}
		for (; i < 7; i++) {
			cellnumBuffer.append('*');
		}
		for (; i < Validator.CELLNUM_LENGTH; i++) {
			cellnumBuffer.append(cellnum.charAt(i));
		}
		return cellnumBuffer.toString();
	}

	public static void main(String[] args) {

	}
}

package com.subang.util;

import com.subang.bean.Result;

/**
 * @author Qiang
 */
public class Validator extends BaseUtil {

	public static final int CELLNUM_LENGTH = 11;
	public static final int BARCODE_LENGTH = 13;

	// 11位数字
	public static Result validCellnum(String cellnum) {
		Result result = new Result();
		if (cellnum == null) {
			result.setCode(Result.ERR);
			result.setMsg("手机号不能为空。");
			return result;
		}
		cellnum = cellnum.trim();
		if (cellnum.length() != CELLNUM_LENGTH) {
			result.setCode(Result.ERR);
			result.setMsg("手机号必须是11位的数字。");
			return result;
		}
		char c;
		for (int i = 0; i < CELLNUM_LENGTH; i++) {
			c = cellnum.charAt(i);
			if (c < '0' || c > '9') {
				result.setCode(Result.ERR);
				result.setMsg("手机号必须是11位的数字。");
				return result;
			}
		}
		result.setCode(Result.OK);
		return result;
	}

	public static Result validPassword(String password) {
		Result result = new Result();
		if (password == null) {
			result.setCode(Result.ERR);
			result.setMsg("密码不能为空。");
			return result;
		}
		if (password.length() < 1 || password.length() > 50) {
			result.setCode(Result.ERR);
			result.setMsg("密码的长度需要在1-50之间。");
			return result;
		}
		result.setCode(Result.OK);
		return result;
	}

	public static Result validMax(int length, String string) {
		Result result = new Result();
		if (string == null) {
			result.setCode(Result.ERR);
			result.setMsg("不能为空。");
			return result;
		}
		if (string.length() > length) {
			result.setCode(Result.ERR);
			result.setMsg("长度不能超过" + length + "个字符。");
			return result;
		}
		result.setCode(Result.OK);
		return result;
	}

	public static Result validBarcode(String barcode) {
		Result result = new Result();
		if (barcode == null) {
			result.setCode(Result.ERR);
			result.setMsg("条形码不能为空。");
			return result;
		}
		barcode = barcode.trim();
		if (barcode.length() != CELLNUM_LENGTH) {
			result.setCode(Result.ERR);
			result.setMsg("条形码必须是13位的数字。");
			return result;
		}
		char c;
		for (int i = 0; i < CELLNUM_LENGTH; i++) {
			c = barcode.charAt(i);
			if (c < '0' || c > '9') {
				result.setCode(Result.ERR);
				result.setMsg("条形码必须是13位的数字。");
				return result;
			}
		}
		result.setCode(Result.OK);
		return result;
	}

	public static void main(String[] args) {

	}
}

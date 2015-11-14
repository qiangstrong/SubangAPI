package com.subang.api;

import com.subang.util.SmsUtil;

public class SubangAPI {

	public static void conf(Integer type, String cellnum, String password, String basePath) {
		BaseAPI.conf(type, cellnum, password, basePath);
		SmsUtil.init();
	}

	public static boolean isConfed() {
		if (BaseAPI.BASE_PATH == null || BaseAPI.appArg == null) {
			return false;
		}
		return true;
	}

	public static void invalidate() {
		BaseAPI.BASE_PATH = null;
		BaseAPI.appArg = null;
	}
}

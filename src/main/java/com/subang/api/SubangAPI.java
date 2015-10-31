package com.subang.api;

import com.subang.util.SmsUtil;

public class SubangAPI {
	public static String BASE_PATH;

	public static void conf(Integer type, String cellnum, String password, String basePath) {
		BASE_PATH = basePath;
		BaseAPI.conf(type, cellnum, password, basePath);
		SmsUtil.init();
	}

	public static boolean isConfed() {
		if (BASE_PATH == null || BaseAPI.BASE_PATH == null || BaseAPI.appArg == null) {
			return false;
		}
		return true;
	}
}

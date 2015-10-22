package com.subang.api;

import com.subang.util.SmsUtil;

public class SubangAPI {

	public static void conf(Integer type, String cellnum, String password, String basePath) {
		BaseAPI.conf(type, cellnum, password, basePath);
		SmsUtil.init();
	}
}

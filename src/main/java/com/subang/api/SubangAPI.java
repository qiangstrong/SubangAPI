package com.subang.api;

import com.subang.util.SmsUtil;

public class SubangAPI {

	public static void conf(Integer type, String cellnum, String password) {
		BaseAPI.conf(type, cellnum, password);
		SmsUtil.init();
	}
}

package com.subang.api;

public class SubangAPI {

	public static void conf(Integer type, String cellnum, String basePath) {
		BaseAPI.conf(type, cellnum, basePath);
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

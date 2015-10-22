package com.subang.api;

import org.junit.Test;

import com.subang.util.SuUtil;

public class APITest {

	String url_base = "http://202.118.18.56/";
	String path_base = "C:\\Users\\lenovo\\Desktop\\临时\\转码\\";
	String path = "image/info/scope/葫芦岛.jpg";

	@Test
	public void test() {
		SuUtil.saveUrl(url_base + path, path_base + path);
	}

	public void pause() {

	}
}

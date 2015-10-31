package com.subang.api;

import org.junit.Test;

import com.subang.bean.Result;
import com.subang.domain.User;

public class APITest {

	String url_base = "http://202.118.18.56/";
	String path_base = "C:\\Users\\lenovo\\Desktop\\临时\\转码\\";
	String path = "image/info/scope/葫芦岛.jpg";

	@Test
	public void test() {
		User user = new User();
		user.setCellnum("15502457990");
		user.setPassword("123");
		Result result = UserAPI.login(user);
		pause();
	}

	public void pause() {

	}
}

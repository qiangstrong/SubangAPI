package com.subang.api;

import com.subang.bean.AppArg;
import com.subang.util.WebConst;
import com.support.client.PostBuilder;

public class BaseAPI {

	protected static final String BASE_URI = WebConst.HOST_URI + "app";
	protected static String BASE_PATH;

	protected static AppArg appArg;

	protected static void conf(Integer type, String cellnum, String password, String basePath) {
		appArg = new AppArg();
		appArg.setType(type);
		appArg.setCellnum(cellnum);
		appArg.setPassword(password);
		BASE_PATH = basePath;
	}

	protected static PostBuilder getFreePostBuilder() {
		PostBuilder builder = PostBuilder.create();
		return builder;
	}

	protected static PostBuilder getPostBuilder() {
		appArg.generate();
		PostBuilder builder = PostBuilder.create()
				.addParameter("type_auth", appArg.getType().toString())
				.addParameter("cellnum_auth", appArg.getCellnum())
				.addParameter("timestamp_auth", appArg.getTimestamp())
				.addParameter("signature_auth", appArg.getSignature());
		return builder;
	}

}

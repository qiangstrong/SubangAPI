package com.subang.api;

import org.apache.http.client.methods.RequestBuilder;

import com.subang.bean.AppArg;

public class BaseAPI {

	protected static final String HOST_URI = "http://202.118.18.56/";
	protected static final String BASE_URI = HOST_URI + "app";

	protected static AppArg appArg;

	protected static void conf(Integer type, String cellnum, String password) {
		appArg = new AppArg();
		appArg.setType(type);
		appArg.setCellnum(cellnum);
		appArg.setPassword(password);
	}

	protected static RequestBuilder getFreeRequestBuilder() {
		RequestBuilder builder = RequestBuilder.post();
		return builder;
	}

	protected static RequestBuilder getRequestBuilder() {
		appArg.generate();
		RequestBuilder builder = RequestBuilder.post()
				.addParameter("type_auth", appArg.getType().toString())
				.addParameter("cellnum_auth", appArg.getCellnum())
				.addParameter("timestamp_auth", appArg.getTimestamp())
				.addParameter("signature_auth", appArg.getSignature());
		return builder;
	}
}

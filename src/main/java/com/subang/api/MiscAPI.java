package com.subang.api;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.AppInfo;
import com.subang.bean.Result;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class MiscAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/misc";

	public static Result checkApp(AppInfo appInfo) {
		HttpEntity entity = EntityBuilder.create().addObject(appInfo).build();
		HttpUriRequest httpUriRequest = getFreePostBuilder().setUri(URI_PREFIX + "/checkapp.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}
}

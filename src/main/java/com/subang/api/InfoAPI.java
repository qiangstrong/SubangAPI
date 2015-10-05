package com.subang.api;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.domain.Info;
import com.support.client.LocalHttpClient;

public class InfoAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/info";

	public static Info getInfo() {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/get.html")
				.build();
		Info info = LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Info.class);
		return info;
	}
}
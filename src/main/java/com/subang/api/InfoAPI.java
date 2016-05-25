package com.subang.api;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.Result;
import com.subang.domain.Info;
import com.subang.util.Validator;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class InfoAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/info";

	public static Info get(Info filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/get.html")
				.setEntity(entity).build();
		Info info = LocalHttpClient.executeJsonResult(httpUriRequest, Info.class);
		return info;
	}

	public static Result addFeedback(String comment) {
		Result result = Validator.validMaxlen(comment, 1000);
		if (!result.isOk()) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("comment", comment).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/addfeedback.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}
}

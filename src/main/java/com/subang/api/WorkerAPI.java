package com.subang.api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.Result;
import com.subang.domain.Worker;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class WorkerAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/worker";

	public static Worker get() {
		HttpEntity entity = EntityBuilder.create().build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/get.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Worker.class);
	}

	public static Result login(Worker worker) {
		HttpEntity entity = EntityBuilder.create().addObject(worker).build();
		HttpUriRequest httpUriRequest = getFreeRequestBuilder().setUri(URI_PREFIX + "/login.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result chgCellnum(String cellnum) {
		HttpEntity entity = EntityBuilder.create().addParameter("cellnum", cellnum).build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/chgcellnum.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result chgPassword(String password) {
		HttpEntity entity = EntityBuilder.create().addParameter("password", password).build();
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/chgpassword.html").setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}
}

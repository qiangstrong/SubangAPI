package com.subang.api;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.Result;
import com.subang.domain.Worker;
import com.support.client.LocalHttpClient;

public class WorkerAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/worker";

	public static Worker get(Integer orderid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/get.html")
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Worker.class);
	}

	public static Result login(Worker worker) {
		HttpUriRequest httpUriRequest = getFreeRequestBuilder(worker).setUri(
				URI_PREFIX + "/login.html").build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result chgCellnum(String cellnum) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/chgcellnum.html")
				.addParameter("cellnum", cellnum).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result chgPassword(String password) {
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/chgpassword.html").addParameter("password", password)
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}
}

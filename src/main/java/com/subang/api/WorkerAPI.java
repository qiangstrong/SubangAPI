package com.subang.api;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.Result;
import com.subang.domain.Worker;
import com.subang.util.Validator;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class WorkerAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/worker";

	public static Worker get() {
		HttpEntity entity = EntityBuilder.create().build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/get.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Worker.class);
	}

	public static Result login(Worker worker) {
		HttpEntity entity = EntityBuilder.create().addObject(worker).build();
		HttpUriRequest httpUriRequest = getFreePostBuilder().setUri(URI_PREFIX + "/login.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result chgCellnum(String cellnum) {
		Result result = Validator.ValidCellnum(cellnum);
		if (result.getCode() != Result.OK) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("cellnum", cellnum).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/chgcellnum.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result chgPassword(String password) {
		Result result = Validator.ValidPassword(password);
		if (result.getCode() != Result.OK) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("password", password).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/chgpassword.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}
}

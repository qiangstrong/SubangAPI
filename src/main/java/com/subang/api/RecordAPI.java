package com.subang.api;

import java.util.List;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.RecordDetail;
import com.subang.bean.Result;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class RecordAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/record";

	public static List<RecordDetail> workerList(Integer stateType, RecordDetail filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("type", stateType.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/workerlist.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, RecordDetail.class);
	}

	public static RecordDetail get(Integer recordid) {
		HttpEntity entity = EntityBuilder.create().addParameter("recordid", recordid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/get.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, RecordDetail.class);
	}

	public static Result deliver(Integer recordid) {
		HttpEntity entity = EntityBuilder.create().addParameter("recordid", recordid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/deliver.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}
}

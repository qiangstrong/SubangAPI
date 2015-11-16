package com.subang.api;

import java.util.List;
import java.util.Map;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.OrderDetail;
import com.subang.bean.Result;
import com.subang.domain.Clothes;
import com.subang.domain.History;
import com.subang.domain.Order;
import com.subang.util.ComUtil;
import com.subang.util.Validator;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class OrderAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/order";

	public static List<OrderDetail> userList(Integer stateType, OrderDetail filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("type", stateType.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/userlist.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, OrderDetail.class);
	}

	public static List<OrderDetail> workerList(Integer stateType, OrderDetail filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("type", stateType.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/workerlist.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, OrderDetail.class);
	}

	public static OrderDetail get(Integer orderid) {
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/get.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, OrderDetail.class);
	}

	public static Map<String, String> add(Order order) {
		HttpEntity entity = EntityBuilder.create().addObject(order).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/add.html")
				.setEntity(entity).build();
		List<Result> results = LocalHttpClient.executeJsonList(httpUriRequest, Result.class);
		return ComUtil.listToMap(results);
	}

	public static Result price(Integer orderid, Double money) {
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.addParameter("money", money.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/price.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result fetch(Integer orderid, String barcode) {
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.addParameter("barcode", barcode).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/fetch.html")

		.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static OrderDetail scan(String barcode) {
		HttpEntity entity = EntityBuilder.create().addParameter("barcode", barcode).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/scan.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, OrderDetail.class);
	}

	public static Result comment(Integer orderid, String comment) {
		Result result = Validator.ValidMax(100, comment);
		if (result.getCode() != Result.OK) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.addParameter("comment", comment).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/comment.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result cancel(Integer orderid) {
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/cancel.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result deliver(Integer orderid) {
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/deliver.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result remark(Integer orderid, String remark) {
		Result result = Validator.ValidMax(100, remark);
		if (result.getCode() != Result.OK) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("orderid", orderid.toString())
				.addParameter("remark", remark).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/remark.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static List<History> listHistory(Integer orderid, History filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("orderid", orderid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/history.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, History.class);
	}

	public static List<Clothes> listClothes(Integer orderid, Clothes filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("orderid", orderid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/clothes.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, Clothes.class);
	}

}

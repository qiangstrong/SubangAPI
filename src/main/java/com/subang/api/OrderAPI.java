package com.subang.api;

import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.OrderDetail;
import com.subang.bean.Result;
import com.subang.domain.Clothes;
import com.subang.domain.History;
import com.subang.domain.Order;
import com.subang.util.ComUtil;
import com.support.client.LocalHttpClient;

public class OrderAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/order";

	public static List<OrderDetail> userList(Integer stateType, OrderDetail filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/userlist.html").addParameter("type", stateType.toString())
				.build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, OrderDetail.class);
	}

	public static List<OrderDetail> workerList(Integer stateType, OrderDetail filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/workerlist.html").addParameter("type", stateType.toString())
				.build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, OrderDetail.class);
	}

	public static OrderDetail get(Integer orderid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/get.html")
				.addParameter("orderid", orderid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, OrderDetail.class);
	}

	public static Map<String, String> add(Order order) {
		HttpUriRequest httpUriRequest = getRequestBuilderData(order).setUri(
				URI_PREFIX + "/add.html").build();
		List<Result> results = LocalHttpClient.executeJsonList(CHARSET, httpUriRequest,
				Result.class);
		return ComUtil.listToMap(results);
	}

	public static Result price(Integer orderid, Double money) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/price.html")
				.addParameter("orderid", orderid.toString())
				.addParameter("money", money.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result fetch(Integer orderid, String barcode) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/fetch.html")
				.addParameter("orderid", orderid.toString()).addParameter("barcode", barcode)
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static OrderDetail scan(String barcode) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/scan.html")
				.addParameter("barcode", barcode).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, OrderDetail.class);
	}

	public static Result comment(Integer orderid, String comment) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/comment.html")
				.addParameter("orderid", orderid.toString()).addParameter("comment", comment)
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result cancel(Integer orderid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/cancel.html")
				.addParameter("orderid", orderid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result deliver(Integer orderid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/deliver.html")
				.addParameter("orderid", orderid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result remark(Integer orderid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/remark.html")
				.addParameter("orderid", orderid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static List<History> listHistory(Integer orderid, History filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/listhistory.html")
				.addParameter("orderid", orderid.toString()).build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, History.class);
	}

	public static List<Clothes> listClothes(Integer orderid, Clothes filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/listclothes.html")
				.addParameter("orderid", orderid.toString()).build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, Clothes.class);
	}

}

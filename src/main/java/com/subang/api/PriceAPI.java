package com.subang.api;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;

import com.subang.domain.Category;
import com.subang.domain.Price;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class PriceAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/price";

	public static List<Category> listcategory(Integer cityid, Category filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("cityid", cityid.toString()).build();
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/listcategory.html").setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, Category.class);
	}

	public static Category getCategory(Integer categoryid) {
		HttpEntity entity = EntityBuilder.create()
				.addParameter("categoryid", categoryid.toString()).build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/category.html")
				.setEntity(entity).build();
		Category category = LocalHttpClient.executeJsonResult(httpUriRequest, Category.class);
		return category;
	}

	public static List<Price> listprice(Integer categoryid, Price filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("categoryid", categoryid.toString()).build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/listprice.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, Price.class);
	}
}

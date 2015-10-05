package com.subang.api;

import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.domain.Category;
import com.support.client.LocalHttpClient;

public class PriceAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/price";

	public static List<Category> listcategory(Integer cityid, Category filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/listcategory.html")
				.addParameter("cityid", cityid.toString()).build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, Category.class);
	}

	public static Category getCategory(Integer categoryid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/category.html")
				.addParameter("categoryid", categoryid.toString()).build();
		Category category = LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest,
				Category.class);
		return category;
	}
}

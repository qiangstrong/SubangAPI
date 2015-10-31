package com.subang.api;

import java.util.List;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.domain.Category;
import com.subang.domain.Price;
import com.subang.util.SuUtil;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class PriceAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/price";

	public static List<Category> listcategory(Integer cityid, Category filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("cityid", cityid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/category.html")
				.setEntity(entity).build();
		List<Category> categorys = LocalHttpClient.executeJsonList(httpUriRequest, Category.class);

		if (categorys != null && (filter == null || filter.getIcon() != null)) {
			for (Category category : categorys) {
				if (category.getIcon() != null) {
					SuUtil.saveUrl(HOST_URI + category.getIcon(), BASE_PATH + category.getIcon());
				}
			}
		}

		return categorys;
	}

	public static Category getCategory(Integer categoryid) {
		HttpEntity entity = EntityBuilder.create()
				.addParameter("categoryid", categoryid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/getcategory.html")
				.setEntity(entity).build();
		Category category = LocalHttpClient.executeJsonResult(httpUriRequest, Category.class);
		if (category != null && category.getIcon() != null) {
			SuUtil.saveUrl(HOST_URI + category.getIcon(), BASE_PATH + category.getIcon());
		}
		return category;
	}

	public static List<Price> listprice(Integer categoryid, Price filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("categoryid", categoryid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/price.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, Price.class);
	}
}

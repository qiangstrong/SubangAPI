package com.subang.api;

import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.domain.City;
import com.subang.util.ComUtil;
import com.support.client.LocalHttpClient;

public class RegionAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/region";

	public static City scope(Integer cityid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/scope.html")
				.addParameter("cityid", cityid.toString()).build();
		City city = LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, City.class);
		ComUtil.saveUrl(HOST_URI + city.getScope(), basePath + city.getScope());
		return city;
	}

	public static List<City> listcity(City filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter).setUri(
				URI_PREFIX + "/listcity.html").build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, City.class);
	}

	public static Integer test() {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/test.html")
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Integer.class);
	}

	public static void main(String[] args) {
		SubangAPI.init("15502457990", "123", "E:\\MY\\其他\\Job\\速帮\\临时\\local\\");
		City city = scope(1);
		System.out.println();
	}
}

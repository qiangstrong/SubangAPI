package com.subang.api;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.Result;
import com.subang.domain.City;
import com.subang.domain.District;
import com.subang.domain.Location;
import com.subang.domain.Region;
import com.subang.util.APIConst;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class RegionAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/region";

	public static Integer setLocation(Location location) {
		HttpEntity entity = EntityBuilder.create().addObject(location).build();
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/setlocation.html").setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Integer.class);
	}

	public static List<City> listCity(City filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/listcity.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, City.class);
	}

	public static List<District> listDistrict(Integer cityid, District filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("cityid", cityid.toString()).build();
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/listdistrict.html").setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, District.class);
	}

	public static List<Region> listRegion(Integer districtid, Region filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("cityid", districtid.toString()).build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/listregion.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, Region.class);
	}

	public static City getCity(Integer cityid) {
		HttpEntity entity = EntityBuilder.create().addParameter("cityid", cityid.toString())
				.build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/getcity.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, City.class);
	}

	public static Result test() {
		HttpEntity entity = EntityBuilder.create().addParameter("arg", "清").build();
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/test.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static void main(String[] args) {
		SubangAPI.conf(APIConst.USER, "15502457990", "123");
		Result result = test();
		System.out.println();
	}
}

package com.subang.api;

import java.util.List;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.OrderDetail;
import com.subang.bean.Result;
import com.subang.domain.City;
import com.subang.domain.District;
import com.subang.domain.Region;
import com.subang.util.SuUtil;
import com.subang.util.WebConst;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class RegionAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/region";

	public static Integer getCityid() {
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/getcityid.html")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Integer.class);
	}

	public static List<City> listCity(City filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/city.html")
				.setEntity(entity).build();
		List<City> citys = LocalHttpClient.executeJsonList(httpUriRequest, City.class);
		if (citys != null && (filter == null || filter.getScope() != null)) {
			for (City city : citys) {
				if (city.getScope() != null) {
					SuUtil.saveUrl(WebConst.HOST_URI + city.getScope(), BASE_PATH + city.getScope());
				}
			}
		}
		return citys;
	}

	public static List<District> listDistrict(Integer cityid, District filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("cityid", cityid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/district.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, District.class);
	}

	public static List<Region> listRegion(Integer districtid, Region filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter)
				.addParameter("districtid", districtid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/region.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, Region.class);
	}

	public static City getCity(Integer cityid) {
		HttpEntity entity = EntityBuilder.create().addParameter("cityid", cityid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/getcity.html")
				.setEntity(entity).build();
		City city = LocalHttpClient.executeJsonResult(httpUriRequest, City.class);
		if (city != null && city.getScope() != null) {
			SuUtil.saveUrl(WebConst.HOST_URI + city.getScope(), BASE_PATH + city.getScope());
		}

		return city;
	}

	public static Result test() {
		HttpEntity entity = EntityBuilder.create().addParameter("arg", "强").build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/test.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static void main(String[] args) {
		SubangAPI.conf(WebConst.WORKER, "15502457990", "123", "C:\\Users\\lenovo\\Desktop\\临时\\转码");
		OrderDetail orderDetails = OrderAPI.get(WebConst.ORDER_GET_BARCODE, "9787121194856");
		System.out.println(orderDetails);
	}
}

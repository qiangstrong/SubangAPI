package com.subang.api;

import java.util.List;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.BasePrepayResult;
import com.subang.bean.PayArg;
import com.subang.bean.Result;
import com.subang.domain.City;
import com.subang.domain.District;
import com.subang.domain.Payment.PayType;
import com.subang.domain.Region;
import com.subang.domain.User;
import com.subang.util.SuUtil;
import com.subang.util.WebConst;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class RegionAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/region";

	public static City getUserCity() {
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/getusercity.html")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, City.class);
	}

	public static List<City> listCity(City filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/city.html")
				.setEntity(entity).build();
		List<City> citys = LocalHttpClient.executeJsonList(httpUriRequest, City.class);
		if (citys != null && (filter == null || filter.getScope() != null)) {
			for (City city : citys) {
				if (city.getScope() != null) {
					if (!SuUtil.fileExist(BASE_PATH + city.getScope())) {
						SuUtil.saveUrl(WebConst.HOST_URI + city.getScope(),
								BASE_PATH + city.getScope());
					}
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
			if (!SuUtil.fileExist(BASE_PATH + city.getScope())) {
				SuUtil.saveUrl(WebConst.HOST_URI + city.getScope(), BASE_PATH + city.getScope());
			}
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
		SubangAPI.conf(WebConst.USER, "15502457990", "C:\\Users\\lenovo\\Desktop\\临时\\转码\\");
		PayArg payArg = new PayArg();
		payArg.setClient(User.Client.user);
		payArg.setPayType(PayType.weixin);
		BasePrepayResult prepayResult = OrderAPI.prepay(payArg);

		System.out.println(prepayResult);
	}
}

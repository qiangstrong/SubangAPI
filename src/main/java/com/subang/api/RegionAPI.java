package com.subang.api;

import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.Result;
import com.subang.domain.City;
import com.subang.domain.District;
import com.subang.domain.Location;
import com.subang.domain.Region;
import com.subang.util.APIConst;
import com.support.client.LocalHttpClient;

public class RegionAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/region";

	public static Integer setLocation(Location location) {
		HttpUriRequest httpUriRequest = getRequestBuilderData(location).setUri(
				URI_PREFIX + "/setlocation.html").build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Integer.class);
	}

	public static List<City> listCity(City filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter).setUri(
				URI_PREFIX + "/listcity.html").build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, City.class);
	}

	public static List<District> listDistrict(Integer cityid, District filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/listdistrict.html")
				.addParameter("cityid", cityid.toString()).build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, District.class);
	}

	public static List<Region> listRegion(Integer districtid, Region filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter)
				.setUri(URI_PREFIX + "/listregion.html")
				.addParameter("cityid", districtid.toString()).build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, Region.class);
	}

	public static City getCity(Integer cityid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/getcity.html")
				.addParameter("cityid", cityid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, City.class);
	}

	public static Result test() {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/test.html")
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static void main(String[] args) {
		SubangAPI.conf(APIConst.OTHER, null, null);
		Result result = test();
		System.out.println();
	}
}

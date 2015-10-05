package com.subang.api;

import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.AddrData;
import com.subang.bean.AddrDetail;
import com.subang.bean.Result;
import com.subang.bean.TicketDetail;
import com.subang.domain.Addr;
import com.subang.domain.User;
import com.subang.util.ComUtil;
import com.support.client.LocalHttpClient;

public class UserAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/user";

	public static User get(Integer orderid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/get.html")
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, User.class);
	}

	public static Result login(User user) {
		HttpUriRequest httpUriRequest = getFreeRequestBuilder(user).setUri(
				URI_PREFIX + "/login.html").build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Map<String, String> add(User user) {
		HttpUriRequest httpUriRequest = getFreeRequestBuilder(user)
				.setUri(URI_PREFIX + "/add.html").build();
		List<Result> results = LocalHttpClient.executeJsonList(CHARSET, httpUriRequest,
				Result.class);
		return ComUtil.listToMap(results);
	}

	public static Result chgCellnum(String cellnum) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/chgcellnum.html")
				.addParameter("cellnum", cellnum).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static Result chgPassword(String password) {
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/chgpassword.html").addParameter("password", password)
				.build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static List<AddrDetail> listAddr(AddrDetail filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter).setUri(
				URI_PREFIX + "/listaddr.html").build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, AddrDetail.class);
	}

	public static AddrData getAddrData(Integer regionid) {
		HttpUriRequest httpUriRequest = getRequestBuilder()
				.setUri(URI_PREFIX + "/getaddrdata.html")
				.addParameter("regionid", regionid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, AddrData.class);
	}

	public static Map<String, String> addAddr(Addr addr) {
		HttpUriRequest httpUriRequest = getRequestBuilderData(addr).setUri(
				URI_PREFIX + "/addaddr.html").build();
		List<Result> results = LocalHttpClient.executeJsonList(CHARSET, httpUriRequest,
				Result.class);
		return ComUtil.listToMap(results);
	}

	public static Result deleteAddr(Integer addrid) {
		HttpUriRequest httpUriRequest = getRequestBuilder().setUri(URI_PREFIX + "/deleteaddr.html")
				.addParameter("addrid", addrid.toString()).build();
		return LocalHttpClient.executeJsonResult(CHARSET, httpUriRequest, Result.class);
	}

	public static List<TicketDetail> listTicket(TicketDetail filter) {
		HttpUriRequest httpUriRequest = getRequestBuilderFilter(filter).setUri(
				URI_PREFIX + "/listticket.html").build();
		return LocalHttpClient.executeJsonList(CHARSET, httpUriRequest, TicketDetail.class);
	}

}

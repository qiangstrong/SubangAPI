package com.subang.api;

import java.util.List;
import java.util.Map;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.bean.AddrData;
import com.subang.bean.AddrDetail;
import com.subang.bean.Result;
import com.subang.bean.TicketDetail;
import com.subang.domain.Addr;
import com.subang.domain.Location;
import com.subang.domain.User;
import com.subang.util.ComUtil;
import com.subang.util.SuUtil;
import com.subang.util.Validator;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class UserAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/user";

	public static User get() {
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/get.html").build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, User.class);
	}

	public static Result login(User user) {
		HttpEntity entity = EntityBuilder.create().addObject(user).build();
		HttpUriRequest httpUriRequest = getFreePostBuilder().setUri(URI_PREFIX + "/login.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Map<String, String> add(User user) {
		HttpEntity entity = EntityBuilder.create().addObject(user).build();
		HttpUriRequest httpUriRequest = getFreePostBuilder().setUri(URI_PREFIX + "/add.html")
				.setEntity(entity).build();
		List<Result> results = LocalHttpClient.executeJsonList(httpUriRequest, Result.class);
		return ComUtil.listToMap(results);
	}

	public static Result chgCellnum(String cellnum) {
		Result result = Validator.ValidCellnum(cellnum);
		if (result.getCode() != Result.OK) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("cellnum", cellnum).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/chgcellnum.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static Result chgPassword(String password) {
		Result result = Validator.ValidPassword(password);
		if (result.getCode() != Result.OK) {
			return result;
		}
		HttpEntity entity = EntityBuilder.create().addParameter("password", password).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/chgpassword.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static List<AddrDetail> listAddr(AddrDetail filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/addr.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonList(httpUriRequest, AddrDetail.class);
	}

	public static AddrDetail getDefaultAddr() {
		HttpUriRequest httpUriRequest = getPostBuilder()
				.setUri(URI_PREFIX + "/getdefaultaddr.html").build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, AddrDetail.class);
	}

	public static AddrData getAddrData(Integer regionid) {
		HttpEntity entity = EntityBuilder.create().addParameter("regionid", regionid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/getaddrdata.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, AddrData.class);
	}

	public static Map<String, String> addAddr(Addr addr) {
		HttpEntity entity = EntityBuilder.create().addObject(addr).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/addaddr.html")
				.setEntity(entity).build();
		List<Result> results = LocalHttpClient.executeJsonList(httpUriRequest, Result.class);
		return ComUtil.listToMap(results);
	}

	public static Result deleteAddr(Integer addrid) {
		HttpEntity entity = EntityBuilder.create().addParameter("addrid", addrid.toString())
				.build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/deleteaddr.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}

	public static List<TicketDetail> listTicket(TicketDetail filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/ticket.html")
				.setEntity(entity).build();
		List<TicketDetail> ticketDetails = LocalHttpClient.executeJsonList(httpUriRequest,
				TicketDetail.class);
		if (ticketDetails != null && (filter == null || filter.getIcon() != null)) {
			for (TicketDetail ticketDetail : ticketDetails) {
				if (ticketDetail.getIcon() != null) {
					SuUtil.saveUrl(HOST_URI + ticketDetail.getIcon(),
							BASE_PATH + ticketDetail.getIcon());
				}
			}
		}
		return ticketDetails;
	}

	public static Result setLocation(Location location) {
		HttpEntity entity = EntityBuilder.create().addObject(location).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/setlocation.html")
				.setEntity(entity).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, Result.class);
	}
}

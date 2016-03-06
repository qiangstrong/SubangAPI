package com.subang.api;

import java.util.List;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.subang.domain.Banner;
import com.subang.domain.Rebate;
import com.subang.domain.TicketType;
import com.subang.util.SuUtil;
import com.subang.util.WebConst;
import com.support.client.EntityBuilder;
import com.support.client.LocalHttpClient;

public class ActivityAPI extends BaseAPI {

	private static final String URI_PREFIX = BASE_URI + "/activity";

	public static List<TicketType> listTicketType(TicketType filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/tickettype.html")
				.setEntity(entity).build();
		List<TicketType> ticketTypes = LocalHttpClient.executeJsonList(httpUriRequest,
				TicketType.class);
		if (ticketTypes != null && (filter == null || filter.getIcon() != null)) {
			for (TicketType ticketType : ticketTypes) {
				if (ticketType.getIcon() != null) {
					if (!SuUtil.fileExist(BASE_PATH + ticketType.getIcon())) {
						SuUtil.saveUrl(WebConst.HOST_URI + ticketType.getIcon(), BASE_PATH
								+ ticketType.getIcon());
					}
				}
			}
		}
		return ticketTypes;
	}

	public static TicketType getTicketType(Integer ticketTypeid) {
		HttpEntity entity = EntityBuilder.create()
				.addParameter("tickettypeid", ticketTypeid.toString()).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/gettickettype.html")
				.setEntity(entity).build();
		TicketType ticketType = LocalHttpClient.executeJsonResult(httpUriRequest, TicketType.class);
		if (ticketType != null && ticketType.getIcon() != null) {
			if (!SuUtil.fileExist(BASE_PATH + ticketType.getIcon())) {
				SuUtil.saveUrl(WebConst.HOST_URI + ticketType.getIcon(),
						BASE_PATH + ticketType.getIcon());
			}
		}

		return ticketType;
	}

	public static List<Banner> listBanner(Banner filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/banner.html")
				.setEntity(entity).build();
		List<Banner> banners = LocalHttpClient.executeJsonList(httpUriRequest, Banner.class);
		if (banners != null && (filter == null || filter.getIcon() != null)) {
			for (Banner banner : banners) {
				if (banner.getIcon() != null) {
					if (!SuUtil.fileExist(BASE_PATH + banner.getIcon())) {
						SuUtil.saveUrl(WebConst.HOST_URI + banner.getIcon(),
								BASE_PATH + banner.getIcon());
					}
				}
			}
		}
		return banners;
	}

	public static List<Rebate> listRebate(Rebate filter) {
		HttpEntity entity = EntityBuilder.create().addFilter(filter).build();
		HttpUriRequest httpUriRequest = getPostBuilder().setUri(URI_PREFIX + "/rebate.html")
				.setEntity(entity).build();
		List<Rebate> rebates = LocalHttpClient.executeJsonList(httpUriRequest, Rebate.class);
		return rebates;
	}
}

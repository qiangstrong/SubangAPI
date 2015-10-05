package com.subang.api;

import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.client.methods.RequestBuilder;
import org.apache.log4j.Logger;

import com.subang.bean.AppArg;
import com.subang.util.BaseUtil;
import com.support.util.JsonUtil;
import com.support.util.MapUtil;

public class BaseAPI {

	protected static final Logger LOG = Logger.getLogger(BaseUtil.class.getName());

	protected static final String HOST_URI = "http://202.118.18.56/";
	protected static final String BASE_URI = HOST_URI + "app";
	protected static final String CHARSET = "utf-8";

	protected static AppArg appArg;

	protected static void conf(Integer type, String cellnum, String password) {
		appArg = new AppArg();
		appArg.setType(type);
		appArg.setCellnum(cellnum);
		appArg.setPassword(password);
	}

	protected static RequestBuilder getFreeRequestBuilder(Object data) {
		RequestBuilder builder = RequestBuilder.post();
		if (data != null) {
			Set<Entry<String, String>> set = MapUtil.objectToSet(data);
			for (Entry<String, String> entry : set) {
				builder.addParameter(entry.getKey(), entry.getValue());
			}
		}
		return builder;
	}

	protected static RequestBuilder getFreeRequestBuilder() {
		return getFreeRequestBuilder(null);
	}

	protected static RequestBuilder getRequestBuilder(Object data, Object filter) {
		appArg.generate();
		RequestBuilder builder = RequestBuilder.post()
				.addParameter("type_auth", appArg.getType().toString())
				.addParameter("cellnum_auth", appArg.getCellnum())
				.addParameter("timestamp_auth", appArg.getTimestamp())
				.addParameter("signature_auth", appArg.getSignature());
		if (data != null) {
			Set<Entry<String, String>> set = MapUtil.objectToSet(data);
			for (Entry<String, String> entry : set) {
				builder.addParameter(entry.getKey(), entry.getValue());
			}
		}
		if (filter != null) {
			builder.addParameter("filter", JsonUtil.toJSONString(filter));
		}
		return builder;
	}

	protected static RequestBuilder getRequestBuilder() {
		return getRequestBuilder(null, null);
	}

	protected static RequestBuilder getRequestBuilderData(Object data) {
		return getRequestBuilder(data, null);
	}

	protected static RequestBuilder getRequestBuilderFilter(Object filter) {
		return getRequestBuilder(null, filter);
	}

}

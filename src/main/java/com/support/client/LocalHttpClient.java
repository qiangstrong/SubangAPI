package com.support.client;

import java.util.ArrayList;
import java.util.List;

import ytx.org.apache.http.client.HttpClient;
import ytx.org.apache.http.client.ResponseHandler;
import ytx.org.apache.http.client.methods.HttpUriRequest;

import com.alibaba.fastjson.JSONObject;
import com.support.util.JsonUtil;

public class LocalHttpClient {

	protected static HttpClient httpClient = HttpClientFactory.createHttpClient();

	public static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler) {
		try {
			return httpClient.execute(request, responseHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 数据返回自动JSON对象解析
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T executeJsonResult(HttpUriRequest request, Class<T> clazz) {
		return execute(request, JsonResponseHandler.createResponseHandler(clazz));
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> executeJsonList(HttpUriRequest request, Class<T> clazz) {
		List<JSONObject> listJson = execute(request,
				JsonResponseHandler.createResponseHandler(List.class));
		if (listJson == null) {
			return null;
		}
		List<T> listResult = new ArrayList<T>();
		for (JSONObject jsonObject : listJson) {
			listResult.add(JsonUtil.parseObject(jsonObject.toJSONString(), clazz));
		}
		return listResult;
	}
}

package com.support.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.support.util.JsonUtil;

public class JsonResponseHandler {

	private static Map<String, ResponseHandler<?>> map = new HashMap<String, ResponseHandler<?>>();

	public static <T> ResponseHandler<T> createResponseHandler(final Class<T> clazz) {
		return createResponseHandler("iso-8859-1", clazz);
	}

	@SuppressWarnings("unchecked")
	public static <T> ResponseHandler<T> createResponseHandler(final String charsetName,
			final Class<T> clazz) {

		if (map.containsKey(clazz.getName())) {
			return (ResponseHandler<T>) map.get(clazz.getName());
		} else {
			ResponseHandler<T> responseHandler = new ResponseHandler<T>() {
				@Override
				public T handleResponse(HttpResponse response) throws ClientProtocolException,
						IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						String str = EntityUtils.toString(entity);
						return JsonUtil.parseObject(new String(str.getBytes(charsetName), "utf-8"),
								clazz);
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			map.put(clazz.getName(), responseHandler);
			return responseHandler;
		}
	}

}
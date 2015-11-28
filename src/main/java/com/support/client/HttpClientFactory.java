package com.support.client;

import com.support.util.HttpConst;

import ytx.org.apache.http.client.HttpClient;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.impl.conn.PoolingClientConnectionManager;
import ytx.org.apache.http.params.BasicHttpParams;
import ytx.org.apache.http.params.HttpConnectionParams;
import ytx.org.apache.http.params.HttpParams;

public class HttpClientFactory {

	public static HttpClient createHttpClient() {

		PoolingClientConnectionManager poolingHttpClientConnectionManager = new PoolingClientConnectionManager();
		poolingHttpClientConnectionManager.setMaxTotal(HttpConst.MAX_TOTAL);

		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, HttpConst.CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParams, HttpConst.SOCKET_TIMEOUT);

		HttpClient httpClient = new DefaultHttpClient(poolingHttpClientConnectionManager,
				httpParams);
		return httpClient;

	}
}
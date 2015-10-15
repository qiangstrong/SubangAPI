package com.support.client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientFactory {

	public static HttpClient createHttpClient() {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().build();
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
			poolingHttpClientConnectionManager.setMaxTotal(HttpConst.MAX_TOTAL);
			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(HttpConst.MAX_PER_ROUTE);

			RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(HttpConst.CONNECTION_TIMEOUT)
					.setSocketTimeout(HttpConst.SOCKET_TIMEOUT).build();

			return HttpClientBuilder.create()
					.setConnectionManager(poolingHttpClientConnectionManager)
					.setDefaultRequestConfig(config).setSSLSocketFactory(sf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}

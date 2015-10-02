package com.support.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

import com.alibaba.fastjson.JSONObject;
import com.support.util.JsonUtil;

public class LocalHttpClient {

	protected static HttpClient httpClient = HttpClientFactory.createHttpClient(100, 10);

	private static Map<String, HttpClient> httpClient_mchKeyStore = new HashMap<String, HttpClient>();

	public static void init(int maxTotal, int maxPerRoute) {
		httpClient = HttpClientFactory.createHttpClient(maxTotal, maxPerRoute);
	}

	/**
	 * 初始化 MCH HttpClient KeyStore
	 * 
	 * @param keyStoreName
	 *            keyStore 名称
	 * @param keyStoreFilePath
	 *            私钥文件路径
	 * @param mch_id
	 * @param maxTotal
	 * @param maxPerRoute
	 */
	public static void initMchKeyStore(String keyStoreName, String keyStoreFilePath, String mch_id,
			int maxTotal, int maxPerRoute) {
		try {
			KeyStore keyStore = KeyStore.getInstance(keyStoreName);
			FileInputStream instream = new FileInputStream(new File(keyStoreFilePath));
			keyStore.load(instream, mch_id.toCharArray());
			instream.close();
			HttpClient httpClient = HttpClientFactory.createKeyMaterialHttpClient(keyStore, mch_id,
					new String[] { "TLSv1" }, maxTotal, maxPerRoute);
			httpClient_mchKeyStore.put(mch_id, httpClient);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static HttpResponse execute(HttpUriRequest request) {
		try {
			return httpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler) {
		try {
			return httpClient.execute(request, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	public static <T> T executeJsonResult(String charsetName, HttpUriRequest request, Class<T> clazz) {
		return execute(request, JsonResponseHandler.createResponseHandler(charsetName, clazz));
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> executeJsonList(String charsetName, HttpUriRequest request,
			Class<T> clazz) {
		List<JSONObject> listJson = execute(request,
				JsonResponseHandler.createResponseHandler(charsetName, List.class));
		List<T> listResult = new ArrayList<T>();
		try {
			for (JSONObject jsonObject : listJson) {
				listResult.add(JsonUtil
						.parseObject(new String(jsonObject.toJSONString().getBytes(charsetName),
								"utf-8"), clazz));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return listResult;
	}

}

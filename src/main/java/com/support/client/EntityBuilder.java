package com.support.client;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.Args;

import com.support.util.JsonUtil;
import com.support.util.MapUtil;

public class EntityBuilder {

	private LinkedList<NameValuePair> parameters;

	private EntityBuilder() {
	}

	public static EntityBuilder create() {
		return new EntityBuilder();
	}

	public List<NameValuePair> getParameters() {
		return parameters != null ? new ArrayList<NameValuePair>(parameters)
				: new ArrayList<NameValuePair>();
	}

	public EntityBuilder addParameter(final NameValuePair nvp) {
		Args.notNull(nvp, "Name value pair");
		if (parameters == null) {
			parameters = new LinkedList<NameValuePair>();
		}
		parameters.add(nvp);
		return this;
	}

	public EntityBuilder addParameter(final String name, final String value) {
		return addParameter(new BasicNameValuePair(name, value));
	}

	public EntityBuilder addParameters(final NameValuePair... nvps) {
		for (final NameValuePair nvp : nvps) {
			addParameter(nvp);
		}
		return this;
	}

	public EntityBuilder addObject(Object object) {
		if (object != null) {
			Set<Entry<String, String>> set = MapUtil.objectToSet(object);
			for (Entry<String, String> entry : set) {
				addParameter(entry.getKey(), entry.getValue());
			}
		}
		return this;
	}

	public EntityBuilder addFilter(Object filter) {
		if (filter != null) {
			addParameter("filter", JsonUtil.toJSONString(filter));
		}
		return this;
	}

	public HttpEntity build() {
		HttpEntity entity = null;
		if (parameters != null && !parameters.isEmpty()) {
			try {
				entity = new UrlEncodedFormEntity(parameters, HttpConst.CHARSET);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return entity;
	}
}

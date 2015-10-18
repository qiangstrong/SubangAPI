package com.support.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.NameValuePair;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.client.utils.URIBuilder;
import ytx.org.apache.http.message.BasicNameValuePair;

public class PostBuilder {

	private URI uri;
	private HttpEntity entity;
	private LinkedList<NameValuePair> parameters;

	private PostBuilder() {
	}

	public static PostBuilder create() {
		return new PostBuilder();
	}

	public URI getUri() {
		return uri;
	}

	public PostBuilder setUri(final URI uri) {
		this.uri = uri;
		return this;
	}

	public PostBuilder setUri(final String uri) {
		this.uri = uri != null ? URI.create(uri) : null;
		return this;
	}

	public HttpEntity getEntity() {
		return entity;
	}

	public PostBuilder setEntity(final HttpEntity entity) {
		this.entity = entity;
		return this;
	}

	public List<NameValuePair> getParameters() {
		return parameters != null ? new ArrayList<NameValuePair>(parameters)
				: new ArrayList<NameValuePair>();
	}

	public PostBuilder addParameter(final NameValuePair nvp) {
		if (parameters == null) {
			parameters = new LinkedList<NameValuePair>();
		}
		parameters.add(nvp);
		return this;
	}

	public PostBuilder addParameter(final String name, final String value) {
		return addParameter(new BasicNameValuePair(name, value));
	}

	public PostBuilder addParameters(final NameValuePair... nvps) {
		for (final NameValuePair nvp : nvps) {
			addParameter(nvp);
		}
		return this;
	}

	public HttpPost build() {
		HttpPost httpPost = new HttpPost();
		uri = uri != null ? uri : URI.create("/");
		if (parameters != null) {
			URIBuilder uriBuilder = new URIBuilder(uri);
			for (NameValuePair nvp : parameters) {
				uriBuilder.addParameter(nvp.getName(), nvp.getValue());
			}
			try {
				uri = uriBuilder.build();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		httpPost.setURI(uri);
		httpPost.setEntity(entity);
		return httpPost;
	}

}

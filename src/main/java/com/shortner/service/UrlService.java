package com.shortner.service;

import com.shortner.model.UrlModel;

public interface UrlService {

	public UrlModel createUrl(UrlModel urlModel);

	public UrlModel findUrl(String slug);

}

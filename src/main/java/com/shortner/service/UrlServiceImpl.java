package com.shortner.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortner.exception.NotFoundException;
import com.shortner.exception.UrlFoundException;
import com.shortner.model.UrlModel;
import com.shortner.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {

	
	@Autowired
	UrlRepository repository;

	@Override
	public UrlModel createUrl(UrlModel urlModel) {
		UrlModel foundUrl = repository.findBySlug(urlModel.getSlug());
		if (foundUrl != null) {
			throw new UrlFoundException("Url Found with slug: " + urlModel.getSlug());
		} else {
			if (urlModel.getSlug() == null) {
				String slug = UUID.randomUUID().toString();
				urlModel.setSlug(slug);
				return repository.save(urlModel);
			} else {
				return repository.save(urlModel);
			}
		}
	}

	@Override
	public UrlModel findUrl(String slug) {
		UrlModel foundUrl = repository.findBySlug(slug);
		if (foundUrl != null) {
			return foundUrl;
		} else {
			throw new NotFoundException("Url not found with slug: " + slug);
		}
	}

}

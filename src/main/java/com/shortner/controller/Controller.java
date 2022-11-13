package com.shortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.shortner.model.UrlModel;
import com.shortner.service.UrlService;

@RestController
@RequestMapping("/url")
public class Controller {
	
	@Autowired
	UrlService urlService;

	@PostMapping("/create")
	public UrlModel createUrl(@RequestBody UrlModel urlModel) {
		return urlService.createUrl(urlModel);
	}
	
	@GetMapping("/{slug}")
	public RedirectView redirectToUrl(@PathVariable String slug) {
		
		UrlModel urlModel = urlService.findUrl(slug);
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(urlModel.getLongURL());
	    
	    
		return redirectView;
	}
	
}

package com.shopperstar.project.communication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shopperstar.project.communication.repository.NewsletterSubscriptionDTO;

@RestController
@RequestMapping("/api/subscribe")
public class NewsletterSubscriptionController {
	private final NewsletterSubscriptionService service;
	
	@Autowired
	NewsletterSubscriptionController(NewsletterSubscriptionService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	NewsletterSubscriptionDTO create(@RequestBody @Valid NewsletterSubscriptionDTO newsletterSubscriptionDTO) {
		return service.create(newsletterSubscriptionDTO);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	NewsletterSubscriptionDTO delete(@PathVariable("id") String id) {
		return service.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<NewsletterSubscriptionDTO> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	NewsletterSubscriptionDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	NewsletterSubscriptionDTO update(@RequestBody @Valid NewsletterSubscriptionDTO newletterSubscriptionDTO) {
		return service.update(newletterSubscriptionDTO);
	}
}

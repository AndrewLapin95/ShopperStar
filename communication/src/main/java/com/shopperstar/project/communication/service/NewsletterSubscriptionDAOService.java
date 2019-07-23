package com.shopperstar.project.communication.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.shopperstar.project.communication.entity.NewsletterSubscription;

@Repository
@Transactional
public class NewsletterSubscriptionDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public String insert(NewsletterSubscription newsletterSubscription) {
		entityManager.persist(newsletterSubscription);
		return newsletterSubscription.getUserId();
	}
}

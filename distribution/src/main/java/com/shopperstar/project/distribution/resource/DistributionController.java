package com.shopperstar.project.distribution.resource;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopperstar.project.distribution.model.Distribution;
import com.shopperstar.project.distribution.repository.DistributionRepository;

@RestController
public class DistributionController {
	
	private static final Logger logger = LoggerFactory.getLogger(DistributionController.class);
	
	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndpoint;
	
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	@Autowired
	private DistributionRepository distributionRepository;
	
	@SqsListener(value = "${cloud.aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void getMessage(Distribution distribution) {
		System.out.println(distribution.toString());
		try {
			
			logger.info("Saving order for user: " + distribution.getUserId());
			distributionRepository.save(distribution);
			logger.info("Successfully saved order for user: " + distribution.getUserId());
			
		} catch (Exception e) {
			
			logger.error("Failed to save order for: " + distribution.getUserId());
			logger.error(e.toString());
			
		}
	}
	
	@GetMapping("/api/get-order-details/{userId}")
	public Optional<Distribution> getOrderDetails(@PathVariable String userId) {
		return distributionRepository.findById(userId);
	}
	
	@DeleteMapping("/api/remove-order-details/{userId}")
	public boolean deleteOrderDetails(@PathVariable String userId) {
		
		Optional<Distribution> orderDetailsToDelete = getOrderDetails(userId);
		
		if (!orderDetailsToDelete.isPresent()) {
			logger.warn("No order to remove for user: " + userId);
			return false;
		}
		
		try {
			
			logger.info("Attempting to remove order for user: " + userId);
			distributionRepository.deleteById(userId);
			logger.info("Successfully removed order for user: " + userId);
			
		} catch (Exception e){
			
			logger.error("Failed to remove user of user: " + userId);
			logger.error(e.toString());
			return false;
			
		}
		
		return true;
	}
}

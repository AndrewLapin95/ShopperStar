package com.shopperstar.project.distribution.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	public void getOrder() {
		while(true) {
			Distribution distribution = queueMessagingTemplate.receiveAndConvert(sqsEndpoint, Distribution.class);
			logger.info(distribution.toString());
		}
	}
	
}

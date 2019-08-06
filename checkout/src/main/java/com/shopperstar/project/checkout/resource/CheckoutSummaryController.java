package com.shopperstar.project.checkout.resource;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shopperstar.project.checkout.model.Address;
import com.shopperstar.project.checkout.model.CheckoutSummary;
import com.shopperstar.project.checkout.model.OrderDetails;
import com.shopperstar.project.checkout.repository.AddressRepository;
import com.shopperstar.project.checkout.repository.OrderDetailsRepository;

@RestController
public class CheckoutSummaryController {

	private static final Logger logger = LoggerFactory.getLogger(CheckoutSummaryController.class);
	
	private static final String cartServiceUri = "http://localhost:8082/api/get-cart/{userId}";
	
	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndpoint;
	
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@GetMapping("/api/get-checkout-summary/{userId}")
	public CheckoutSummary getCheckoutSummary(@PathVariable String userId) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("userId", userId);
		
		ResponseEntity<CheckoutSummary> responseEntity = null;
		
		try {
			
			logger.info("Attempting to extract cart information for user: " + userId);
			responseEntity = new RestTemplate().getForEntity(cartServiceUri, CheckoutSummary.class, uriVariables);
			logger.info("Successfully extracted cart information for user" + userId);
			
		} catch (Exception ex) {
			logger.error("Failed to extract cart information for user: " + userId);
			logger.error(ex.toString());
		}

		return responseEntity.getBody();
	}
	
	@PostMapping("/api/save-address/{userId}")
	public ResponseEntity<Address> saveCheckoutAddress(@PathVariable String userId, @Valid @RequestBody Address userAddress) {
		
		Address savedAddress = null;
		userAddress.setUserId(userId);
		
		try {
			
			logger.info("Saving new address for user: " + userId);
			savedAddress = addressRepository.save(userAddress);
			logger.info("Successfully saved new address for user: " + userId);
			
		} catch (Exception e) {
			logger.error("Failed to save address for user: " + userId);
			logger.error(e.toString());
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .buildAndExpand(savedAddress.getUserId())
												  .toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/api/get-address/{userId}")
	public Optional<Address> getAddress(@PathVariable String userId) {
		return addressRepository.findById(userId);
	}
	
	@DeleteMapping("/api/delete-address/{userId}")
	public boolean deleteAddress(@PathVariable String userId) {
		
		Optional<Address> addressToDelete = addressRepository.findById(userId);
		
		if (!addressToDelete.isPresent()) {
			logger.warn("No address for user: " + userId + " has been found...");
			return true;
		}
		
		try {
			
			logger.info("Attempting to delete address for user: " + userId);
			addressRepository.deleteById(userId);
			logger.info("Successfully removed address for user: " + userId);
			
		} catch (Exception ex) {
			
			logger.error("Failed to remove address for user: " + userId);
			logger.error(ex.toString());
			
			return false;
		}
		
		return true;
	}
	
	@PostMapping("/api/save-order-details/{userId}")
	public OrderDetails saveOrderDetails(@PathVariable String userId) {
		
		OrderDetails orderDetails = null;
		
		try {
			
			logger.info("Attempting to post an order for user: " + userId);
			
			orderDetails = new OrderDetails(userId, getAddress(userId).get(), getCheckoutSummary(userId));
			queueMessagingTemplate.convertAndSend(sqsEndpoint, orderDetails);
			
			logger.info("Successfully posted an order for user: " + userId);
			
		} catch (Exception e) {
			
			logger.error("Failed to post an order for user: " + userId);
			logger.error(e.toString());
		}
		
		return orderDetails;
	}
	
	@SqsListener(value = "${cloud.aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void getMessage(OrderDetails orderDetails) {
		
		try {
			
			logger.info("Saving order for user: " + orderDetails.getUserId());
			orderDetailsRepository.save(orderDetails);
			logger.info("Successfully saved order for user: " + orderDetails.getUserId());
			
		} catch (Exception e) {
			
			logger.error("Failed to save order for: " + orderDetails.getUserId());
			logger.error(e.toString());
			
		}
	}
	
	@GetMapping("/api/get-order-details/{userId}")
	public Optional<OrderDetails> getOrderDetails(@PathVariable String userId) {
		return orderDetailsRepository.findById(userId);
	}
}

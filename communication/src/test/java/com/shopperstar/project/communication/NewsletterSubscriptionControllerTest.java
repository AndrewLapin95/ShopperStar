package com.shopperstar.project.communication;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shopperstar.project.communication.model.NewsletterSubscription;
import com.shopperstar.project.communication.resource.NewsletterSubscriptionController;

@WebMvcTest(value = NewsletterSubscriptionController.class)
public class NewsletterSubscriptionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NewsletterSubscriptionController service;
	
	private List<NewsletterSubscription> subscriptions = new ArrayList<NewsletterSubscription>();
	
	@Test
	public void retrieveNewsletterSubscriptions() throws Exception {
		
		NewsletterSubscription firstTestSubscription = new NewsletterSubscription("test1@gmail.com");
		NewsletterSubscription secondTestSubscription = new NewsletterSubscription("test2@gmail.com");
		
		subscriptions.add(firstTestSubscription);
		subscriptions.add(secondTestSubscription);
		
		Mockito.when(service.getNewsletterSubscriptions()).thenReturn(subscriptions);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-newsletter-subscriptions")
															  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$", hasSize(2)))		
									   .andExpect(jsonPath("$[0].email", is("test1@gmail.com")))
									   .andExpect(jsonPath("$[1].email", is("test2@gmail.com")));
		
		verify(service, times(1)).getNewsletterSubscriptions();
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void retrieveNewsletterSubscription() throws Exception {
		
		String testId = "5d38fd2df7ae3c5b4b74faaa";
		String testEmail = "test1@gmail.com";
		
		NewsletterSubscription firstTestSubscription = new NewsletterSubscription(testId, testEmail);
		
		Mockito.when(service.getNewsletterSubscription(firstTestSubscription.getId())).thenReturn(Optional.of(firstTestSubscription));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-newsletter-subscription/" + testId)
															  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$.id", is(testId)))
									   .andExpect(jsonPath("$.email", is(testEmail)));
		
		verify(service, times(1)).getNewsletterSubscription(testId);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void saveNewsletterSubscriptionBasic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/subscribe")
															  .contentType(MediaType.APPLICATION_JSON)
															  .content("{\"email\":\"test1@gmail.com\"}");
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void saveNewsletterSubscriptionBadRequest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/subscribe")
															  .contentType(MediaType.APPLICATION_JSON)
															  .content("{\"email\":\"test1\"}");
		
		mockMvc.perform(requestBuilder).andExpect(status().isBadRequest());
	}
	
	@Test
	public void deleteNewsletterSubscription() throws Exception {
		
		String testId = "5d38fd2df7ae3c5b4b74faaa";
		String testEmail = "test1@gmail.com";
		
		NewsletterSubscription testNewsletterSubscription = new NewsletterSubscription(testId, testEmail);
		
		Mockito.when(service.saveNewsletterSubscription(testNewsletterSubscription)).thenReturn(testEmail);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/unsubscribe/" + testId)
															  .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
}

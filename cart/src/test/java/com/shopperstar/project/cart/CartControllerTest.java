package com.shopperstar.project.cart;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shopperstar.project.cart.model.Cart;
import com.shopperstar.project.cart.resource.CartController;

@WebMvcTest(value = CartController.class)
public class CartControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CartController service;
	
	@Test
	public void retrieveCartTest() throws Exception {
		
		String testUserId = "5d018bc7017a80e18ff1737b";
		
		Cart testCart = new Cart(testUserId);
		
		Mockito.when(service.getCart(testCart.getUserId())).thenReturn(Optional.of(testCart));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-cart/" + testUserId)
															  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$.userId", is(testUserId)))
									   .andExpect(jsonPath("$.productCount", is(0)))
									   .andExpect(jsonPath("$.products", hasSize(0)));
		
		verify(service, times(1)).getCart(testUserId);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void saveNewCartTest() throws Exception {
		
		String testUserId = "5d018bc7017a80e18ff1737b";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/create-cart/" + testUserId)
										.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void saveAlreadyExistingCartTest() throws Exception {
		
		String testUserId = "5d018bc7017a80e18ff1737b";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/create-cart/" + testUserId)
										.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());	
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void addItemToCartTest() throws Exception {
		
	}
	
	//@Test
	//public void deleteItemFromCartTest() throws Exception {
		
	//}
	
	//@Test
	//public void deleteAllItemsFromCartTest() throws Exception {
		
	//}
}

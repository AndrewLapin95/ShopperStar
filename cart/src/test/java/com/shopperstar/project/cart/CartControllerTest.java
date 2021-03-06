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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shopperstar.project.cart.model.Cart;
import com.shopperstar.project.cart.model.DeliveryRequestBody;
import com.shopperstar.project.cart.model.ProductInCart;
import com.shopperstar.project.cart.model.ProductToDelete;
import com.shopperstar.project.cart.resource.CartController;


@WebMvcTest(value = CartController.class)
public class CartControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CartController service;
	
	private String testProductId = "1";
	private String testProductTitle = "Test Product Title";
	private Integer testProductCount = 1;
	private Integer testProductPrice = 100;
	
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
	public void addItemToCartTest() throws Exception {

		Cart testCart = new Cart("5d018bc7017a80e18ff1737a");
		
		ProductInCart testProduct = new ProductInCart(testProductId, testProductTitle, testProductCount, testProductPrice);
		
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
		
		Mockito.when(service.addItemToCart(testCart.getUserId(), testProduct)).thenReturn(testProduct);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/add-item/" + testCart.getUserId())
											   .content("{\"productId\":\"" + testProduct.getProductId() + 
													    "\",\"count\":" + testProduct.getProductId() + "}")
											   .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void updateDeliveryMethodTest() throws Exception {
		
		String testDeliveryMethod = "NEXT_DAY_DELIVERY";
		
		Cart testCart = new Cart("5d018bc7017a80e18ff1737a");
		
		ProductInCart testProduct = new ProductInCart(testProductId, testProductTitle, testProductCount, testProductPrice);
		
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
		
		Mockito.when(service.updateDeliveryMethod(testCart.getUserId(), new DeliveryRequestBody(testDeliveryMethod))).thenReturn(testCart);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/update-delivery-method/" + testCart.getUserId())
															  .content("{\"deliveryMethod\": \"" + testDeliveryMethod + "\"}")
															  .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
	}
	
	@Test
	public void deleteItemFromCartTest() throws Exception {
		
		Cart testCart = new Cart("5d018bc7017a80e18ff1737a");
		
		ProductInCart testProduct = new ProductInCart(testProductId, testProductTitle, testProductCount, testProductPrice);
		
		Mockito.when(service.deleteItemInCart(testCart.getUserId(), new ProductToDelete(testProduct.getProductId()))).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/delete-item/" + testCart.getUserId())
				   											  .content("{\"productId\":\"" + testProduct.getProductId() + 
				   													   "\",\"count\":" + testProduct.getProductId() + "}")
											   .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());		
	
	}
	
	@Test
	public void deleteAllItemsFromCartTest() throws Exception {
		
		Cart testCart = new Cart("5d018bc7017a80e18ff1737a");
		
		ProductInCart testProduct = new ProductInCart(testProductId, testProductTitle, testProductCount, testProductPrice);
		
		Mockito.when(service.deleteAllItemsInCart(testCart.getUserId())).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/delete-items/" + testCart.getUserId())
											   				  .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
	}
}

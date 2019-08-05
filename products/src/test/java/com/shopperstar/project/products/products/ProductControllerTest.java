package com.shopperstar.project.products.products;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
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

import com.shopperstar.project.products.model.Availability;
import com.shopperstar.project.products.model.Category;
import com.shopperstar.project.products.model.ImageUri;
import com.shopperstar.project.products.model.Product;
import com.shopperstar.project.products.resource.ProductController;

@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductController service;
	
	private String testId = "5d4795e04f69a72aeb1642f5";
	private String testTitle = "Test Title";
	private Integer testOldPrice = 1;
	private Integer testNewPrice = 2;
	private Category testCategory = Category.HEADPHONES;
	private Availability testAvailability = Availability.IN_STOCK;
	private String testDescription = "Test Description";
	private Product testProduct = new Product(testId, testTitle, testOldPrice, 
					testNewPrice, testCategory, 
					testAvailability, new ArrayList<ImageUri>(), 
					testDescription);
	
	@Test
	public void saveNewProductTest() throws Exception {
		
		String contentString = "{\n" + 
								"	\"title\": \"" + testTitle + "\",\n" + 
								"	\"oldPrice\": " + testOldPrice + ",\n" + 
								"	\"newPrice\": " + testNewPrice + ",\n" + 
								"	\"category\": \"" + testCategory.toString() +"\",\n" + 
								"	\"availability\": \"" + testAvailability.toString() +"\",\n" + 
								"	\"images\": [],\n" + 
								"	\"description\": \"" + testDescription + "\"\n" + 
								"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/create-product")
															  .content(contentString)
															  .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void retrieveProductTest() throws Exception {
		
		Mockito.when(service.getProduct(testId)).thenReturn(Optional.of(testProduct));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-product/" + testId)
															  .contentType(MediaType.APPLICATION_JSON)
				  											  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$.id", is(testId)))
									   .andExpect(jsonPath("$.title", is(testTitle)))
									   .andExpect(jsonPath("$.description", is(testDescription)));
		
		verify(service, times(1)).getProduct(testProduct.getId());
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void retrieveAllProductsTest() throws Exception {
		
		List<Product> listOfProducts = new ArrayList<Product>();
		listOfProducts.add(testProduct);
		
		Mockito.when(service.getAllProducts()).thenReturn(listOfProducts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-products")
				  											  .contentType(MediaType.APPLICATION_JSON)
				  											  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$[0].id", is(testId)))
									   .andExpect(jsonPath("$[0].title", is(testTitle)))
									   .andExpect(jsonPath("$[0].description", is(testDescription)));
		
		verify(service, times(1)).getAllProducts();
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void removeProduct() throws Exception {
		
		Mockito.when(service.removeProduct(testId)).thenReturn(new ResponseEntity<Product>(HttpStatus.OK));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/remove-product/" + testId)
 				  											  .contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
}

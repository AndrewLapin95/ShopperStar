package com.shopperstar.project.query;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shopperstar.project.query.model.SearchedProduct;
import com.shopperstar.project.query.resource.QueryController;

@WebMvcTest(value = QueryController.class)
public class QueryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private QueryController service;
	
	private String testId1 = "5d4cc2d6e50d121a51afcb6e";
	private String testCategory1 = "headphones";
	private String testImage1 = "Test image url";
	private Integer testPrice1 = 100;
	private String testTitle1 = "Test title";
	
	private String testId2 = "5d4cc2d6e50d121a51afcb6f";
	private String testCategory2 = "phones";
	private String testImage2 = "Second test image url";
	private Integer testPrice2 = 900;
	private String testTitle2 = "Test title two";
	
	private List<SearchedProduct> testProducts = new ArrayList<SearchedProduct>();
	
	@Test
	public void retrieveProductsTest() throws Exception {
		testProducts.add(new SearchedProduct(testId1, testCategory1, testImage1, testPrice1, testTitle1));
		testProducts.add(new SearchedProduct(testId2, testCategory2, testImage2, testPrice2, testTitle2));
		
		Mockito.when(service.getAllProducts()).thenReturn(testProducts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-products")
				                                              .contentType(MediaType.APPLICATION_JSON)
				                                              .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());

		verify(service, times(1)).getAllProducts();
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void retrieveProductByCategoryTest() throws Exception {
		testProducts.add(new SearchedProduct(testId2, testCategory2, testImage2, testPrice2, testTitle2));
		
		Mockito.when(service.getProductsByCategory(testCategory2)).thenReturn(testProducts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-products-by-category/" + testCategory2)
				                                              .contentType(MediaType.APPLICATION_JSON)
				                                              .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
		                               .andExpect(jsonPath("$[0].category", is(testCategory2)));

		verify(service, times(1)).getProductsByCategory(testCategory2);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void retrieveProductByTitle() throws Exception {
		testProducts.add(new SearchedProduct(testId1, testCategory1, testImage1, testPrice1, testTitle1));
		
		Mockito.when(service.getProductsByTitle(testTitle1)).thenReturn(testProducts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-products-by-title/" + testTitle1)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].title", is(testTitle1)));

		verify(service, times(1)).getProductsByTitle(testTitle1);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void searchProductsTest() throws Exception {
		testProducts.add(new SearchedProduct(testId2, testCategory2, testImage2, testPrice2, testTitle2));
		
		Mockito.when(service.searchProducts(testTitle2)).thenReturn(testProducts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/search-products/" + testTitle2)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].title", is(testTitle2)));

		verify(service, times(1)).searchProducts(testTitle2);
		verifyNoMoreInteractions(service);
	}
}

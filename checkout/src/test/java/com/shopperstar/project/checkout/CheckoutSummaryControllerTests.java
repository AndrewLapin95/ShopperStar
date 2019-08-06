package com.shopperstar.project.checkout;

import static org.hamcrest.CoreMatchers.is;
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

import com.shopperstar.project.checkout.model.Address;
import com.shopperstar.project.checkout.resource.CheckoutSummaryController;

@WebMvcTest(value = CheckoutSummaryController.class)
public class CheckoutSummaryControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CheckoutSummaryController service;
	
	private String testUserId = "5d018bc7017a80e18ff1737a";
	private String testFirstName = "Bob";
	private String testLastName = "Marley";
	private String testCompany = "Test Company";
	private String testCountry = "Test Country";
	private String testMailingAddress = "Test Address";
	private String testZipCode = "Test Zipcode";
	private String testCity = "Test City";
	private String testProvince = "Test Province";
	private String testPhoneNumber = "Test Phonenumber";
	private String testEmail = "test-email@gmail.com";
	private Address testAddress = new Address(testUserId, testFirstName, 
											  testLastName, testCompany, 
											  testCountry, testMailingAddress, 
											  testZipCode, testCity, testProvince, 
											  testPhoneNumber, testEmail);
	
	@Test
	public void saveAddressTest() throws Exception {
		
		String content = "{\n" + 
				"	\"firstName\": \"" + this.testFirstName + "\",\n" + 
				"	\"lastName\": \"" + this.testLastName + "\",\n" + 
				"	\"company\": \"" + this.testCompany + "\",\n" + 
				"	\"country\": \"" + this.testCountry + "\",\n" + 
				"	\"address\": \"" + this.testMailingAddress + "\",\n" + 
				"	\"zipCode\": \"" + this.testZipCode + "\",\n" + 
				"	\"city\": \"" + this.testCity + "\",\n" + 
				"	\"province\": \"" + this.testProvince + "\",\n" + 
				"	\"phoneNumber\": \"" + this.testPhoneNumber + "\",\n" + 
				"	\"email\": \"" + this.testEmail + "\"\n" + 
				"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/save-address/" + this.testUserId)
															  .content(content)
															  .contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void retrieveAddressTest() throws Exception {
		
		Mockito.when(service.getAddress(this.testUserId)).thenReturn(Optional.of(this.testAddress));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-address/" + this.testUserId)
															  .contentType(MediaType.APPLICATION_JSON)
															  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$.userId", is(this.testUserId)))
									   .andExpect(jsonPath("$.firstName", is(this.testFirstName)))
									   .andExpect(jsonPath("$.email", is(this.testEmail)));
							
		verify(service, times(1)).getAddress(testAddress.getUserId());
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void retrieveAddress() throws Exception {
		
		Mockito.when(service.deleteAddress(this.testUserId)).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/delete-address/" + this.testUserId)
 				  											  .contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
	}
}

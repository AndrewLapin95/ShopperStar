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

import com.shopperstar.project.communication.model.Contact;
import com.shopperstar.project.communication.resource.ContactController;

@WebMvcTest(value = ContactController.class)
public class ContactControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactController service;
	
	private List<Contact> contacts = new ArrayList<Contact>();
	
	@Test
	public void retrieveContacts() throws Exception {
		
		Contact firstTestContact = new Contact("Bob", "Marley", "Hello There!", "Test message 1");
		Contact secondTestContact = new Contact("Stephen", "Spielberg", null, "Test message 2");
		
		contacts.add(firstTestContact);
		contacts.add(secondTestContact);
		
		Mockito.when(service.getContacts()).thenReturn(contacts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-contact-requests")
															  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$", hasSize(2)))
									   .andExpect(jsonPath("$[0].firstName", is("Bob")))
									   .andExpect(jsonPath("$[0].lastName", is("Marley")))
									   .andExpect(jsonPath("$[0].subject", is("Hello There!")))
									   .andExpect(jsonPath("$[0].message", is("Test message 1")))
									   .andExpect(jsonPath("$[1].firstName", is("Stephen")))
									   .andExpect(jsonPath("$[1].lastName", is("Spielberg")))
									   .andExpect(jsonPath("$[1].subject", is("")))
									   .andExpect(jsonPath("$[1].message", is("Test message 2")));
		
		verify(service, times(1)).getContacts();
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void retrieveContact() throws Exception {
		
		String testId = "5d40bc89550c3c7b111bba13";
		String testfirstName = "Bob";
		String testLastName = "Marley";
		String testSubject = "Hello There!";
		String testMessage = "Test message 1";
		
		Contact firstTestContact = new Contact(testId, testfirstName, testLastName, testSubject, testMessage);
		
		Mockito.when(service.getContact(firstTestContact.getId())).thenReturn(Optional.of(firstTestContact));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-contact-request/" + testId)
															  .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
									   .andExpect(jsonPath("$.id", is(testId)))
									   .andExpect(jsonPath("$.firstName", is(testfirstName)))
									   .andExpect(jsonPath("$.lastName", is(testLastName)))
									   .andExpect(jsonPath("$.subject", is(testSubject)))
									   .andExpect(jsonPath("$.message", is(testMessage)));
		
		verify(service, times(1)).getContact(testId);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void saveContactBasic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/save-contact")
															  .contentType(MediaType.APPLICATION_JSON)
															  .content("{\"firstName\":\"Bob\", \"lastName\": \"Marley\", "
															  		 + "\"subject\": \"Hello There!\", \"message\": "
															  		 + "\"Hello There!\"}");
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void deleteContact() throws Exception {
		
		String testId = "5d40bc89550c3c7b111bba13";
		String testfirstName = "Bob";
		String testLastName = "Marley";
		String testSubject = "Hello There!";
		String testMessage = "Test message 1";
		
		Contact firstTestContact = new Contact(testId, testfirstName, testLastName, testSubject, testMessage);
		
		Mockito.when(service.saveContact(firstTestContact)).thenReturn(firstTestContact.getId());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/remove-contact-request/" + testId)
															  .contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
}

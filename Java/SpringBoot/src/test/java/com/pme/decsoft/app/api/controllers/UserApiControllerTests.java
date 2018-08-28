package com.pme.decsoft.app.api.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.pme.decsoft.app.api.controllers.UserApiController;
import com.pme.decsoft.app.repositories.UserRepository;
import com.pme.decsoft.app.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserApiController.class)
public class UserApiControllerTests {
    @Autowired
    private MockMvc mvc;
     
    @MockBean
    private UserRepository userRepository;
        
    @MockBean
    private UserService userService;

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

   @Test
    public void givenUser_whenGetUserName_thenReturnJsonArray()
      throws Exception {       
//        mvc.perform(get("/find/peyman").with(SecurityMockMvcRequestPostProcessors.user("").password(""))
//          .contentType(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk())
//          .andExpect(JsonPath());
	   headers.setContentType(MediaType.APPLICATION_JSON);
		
	   HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/find/peyman"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\r\n" + 
				"  \"id\": 1,\r\n" + 
				"  \"username\": \"peyman\",\r\n" + 
				"  \"password\": \"$2a$10$7kBO1oLGNSIFa4G0j9CQDOxM.t5ZYWJQpYc3XGVg8EpwWIcjaNTmC\",\r\n" + 
				"  \"passwordConfirm\": \"12345678\",\r\n" + 
				"  \"email\": \"peyman.ekhtiar@decsoft.com.pl\",\r\n" + 
				"  \"roles\": [\r\n" + 
				"    \r\n" + 
				"  ]\r\n" + 
				"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);

    }
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

   }

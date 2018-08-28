package com.pme.decsoft.app;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*import com.pme.decsoft.app.api.controllers.HomeApiController;
import com.pme.decsoft.app.api.controllers.UserApiController;
*/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebGalleryApplication.class)
public class WebApiTests {

//	@InjectMocks
//	HomeApiController homeApicontroller;
//	@InjectMocks
//	UserApiController userApicontroller;
	
	@Autowired
	private WebApplicationContext context;

    private MockMvc mockMvc;

    
    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    

    @Test
    public void testGreetingApi() throws Exception {
    	mockMvc.perform(get("/api")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("api", equalTo("Hi to demo test.")));    	    	
    }

    @Test
    public void testUserApi() throws Exception {
    	String username = "peyman";
    	mockMvc.perform(get("/api/user/find/"+ username)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("username", equalTo("peyman")));    	    	
    }
	
}

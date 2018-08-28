package com.pme.decsoft.app;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pme.decsoft.app.api.controllers.UserApiController;
import com.pme.decsoft.app.api.controllers.HomeApiController;
import com.pme.decsoft.app.web.controllers.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebGalleryApplication.class)
public class SmokeTests {

	@InjectMocks
	HomeApiController controller;
	@InjectMocks
	UserApiController userApicontroller;
	@InjectMocks
	UserController usercontroller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(userApicontroller).isNotNull();
        assertThat(usercontroller).isNotNull();
    }
    
}
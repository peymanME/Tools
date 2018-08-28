package com.pme.decsoft.app.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class HomeApiController {
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String homeApi() {
		System.out.println("Got json request");    	
    	return "{ \"api\": \"Hi to demo test.\"}";
    }
}

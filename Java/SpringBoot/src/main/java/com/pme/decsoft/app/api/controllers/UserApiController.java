package com.pme.decsoft.app.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pme.decsoft.app.models.User;
import com.pme.decsoft.app.services.UserService;

@RestController
public class UserApiController {
   @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user/find/{username}", method = RequestMethod.GET, produces = { "application/json"})
    public ResponseEntity<?> findByUsername(@PathVariable("username") String username) {
    	
    	User result = userService.findByUsername(username );
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

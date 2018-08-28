package com.pme.decsoft.app.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.pme.decsoft.app.models.User;
import com.pme.decsoft.app.repositories.RoleRepository;
import com.pme.decsoft.app.repositories.UserRepository;
import com.pme.decsoft.app.services.UserService;
import com.pme.decsoft.app.services.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceImplTests {
    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
    	@Bean
    	public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	    return new BCryptPasswordEncoder();
    	}  
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }
 
    @Autowired
    private UserService userService;
 
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private RoleRepository roleRepository;
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("peyman");
        user.setPassword("peyman");
        user.setPasswordConfirm("peyman");
        user.setEmail("peyman.ekhtiar@decsoft.com.pl");
     
        Mockito.when(userRepository.findByUsername(user.getUsername()))
          .thenReturn(user);
    }

    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String name = "peyman";
        User found = userService.findByUsername(name);
      
         assertThat(found.getUsername())
          .isEqualTo(name);
     } 
 
    @Test
    public void whenNotValidName_thenUserNotFound() {
        String name = "kamil";
        User found = userService.findByUsername(name);
      
         assertThat(found)
          .isNotEqualTo(name);
     }  
}

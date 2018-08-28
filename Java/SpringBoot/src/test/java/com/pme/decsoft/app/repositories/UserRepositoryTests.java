package com.pme.decsoft.app.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pme.decsoft.app.models.User;
import com.pme.decsoft.app.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        User user = new User();
        user.setUsername("peyman");
        user.setPassword("peyman");
        user.setPasswordConfirm("peyman");
        user.setEmail("peyman.ekhtiar@decsoft.com.pl");
        entityManager.persist(user);
        entityManager.flush();
        // when
        User found = userRepository.findByUsername(user.getUsername());
     
        // then
        assertThat(found.getUsername())
          .isEqualTo(user.getUsername());
    }

}

package com.pme.decsoft.app.services;

import com.pme.decsoft.app.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
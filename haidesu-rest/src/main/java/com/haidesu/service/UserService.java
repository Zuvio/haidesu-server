package com.haidesu.service;

import com.haidesu.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final ConcurrentHashMap<Long, User> database = new ConcurrentHashMap<>();

    public User addUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setSecretword(user.getSecretword());
        database.put(1L, newUser);
        return newUser;
    }


}

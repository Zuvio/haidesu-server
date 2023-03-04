package com.haidesu.service;

import com.haidesu.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    /**
     * Deze database variabele mocked een database connectie.
     * Werkelijke persistence implementatie volgt later.
     */
    private final ConcurrentHashMap<Long, User> database = new ConcurrentHashMap<>();

    public User addUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setSecretword(user.getSecretword());

        // mocked het toevoegen aan de 'database' en returned de user zoals de db dat zou doen
        database.put(1L, newUser);
        return newUser;
    }


}

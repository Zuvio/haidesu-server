package com.haidesu.controller;

import com.haidesu.api.UsersApiDelegate;
import com.haidesu.model.User;
import com.haidesu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserController implements UsersApiDelegate {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> addNewUser(User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
}

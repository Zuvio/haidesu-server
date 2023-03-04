package com.haidesu.controller;

import com.haidesu.api.UsersApiDelegate;
import com.haidesu.model.User;
import com.haidesu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Deze class UsersApiDelegateImpl implementeert de {@link UsersApiDelegate} interface gegenereerd door OpenAPI.
 * Dit is <b>niet</b> de {@link org.springframework.stereotype.Controller} class die calls afhandelt,
 * dit is de {@link org.springframework.stereotype.Service} class die de {@link UsersApiDelegate} methods override
 * voor correcte implementatie.
 * </p>
 * <p>
 * Deze implementatie class met achterliggende {@link UserService} om business logic uit te voeren,
 * zou altijd moeten blijven werken, ook al verandert de OpenAPI Specification.
 * Dat is het doel van de OpenAPI delegatePattern=true.
 * </p>
 */

@Service
public class UsersApiDelegateImpl implements UsersApiDelegate {

    private final UserService userService;

    public UsersApiDelegateImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> addNewUser(User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
}

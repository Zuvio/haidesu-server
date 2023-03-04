package com.haidesu.controller;

import com.haidesu.api.UsersApiDelegate;
import com.haidesu.model.User;
import com.haidesu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Deze class UsersApiDelegateImpl implementeert de UsersApiDelegate interface gegenereerd door OpenAPI.
 * Dit is niet de RestController class die calls afhandelt, dit is de @Service class die de UsersApiDelegate
 * methods override voor correcte implementatie.
 * </p>
 * <p>
 * Deze implementatie class met achterliggende services om business logic uit te voeren zou altijd moeten blijven
 * werken, ook al verandert de OpenAPI Specification. Dat is het doel van de OpenAPI delegatePattern.
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

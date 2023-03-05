package com.haidesu.service;

import com.haidesu.api.UsersApiDelegate;
import com.haidesu.entities.User;
import com.haidesu.exceptions.UserNotFoundException;
import com.haidesu.mappers.UserMapper;
import com.haidesu.model.CreateUserJson;
import com.haidesu.model.UpdateUserJson;
import com.haidesu.model.UserJson;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

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

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    public UsersApiDelegateImpl(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<List<UserJson>> getAllUsers(Integer page, Integer limit) {
        List<UserJson> userJsonList = userService.getAllUsers(PageRequest.of(page, limit))
                .getContent()
                .stream()
                .map(userMapper::toUserJson)
                .toList();
        return new ResponseEntity<>(userJsonList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserJson> addNewUser(CreateUserJson userJson) {
        User user = userService.addNewUser(userMapper.toUserEntity(userJson));
        return new ResponseEntity<>(userMapper.toUserJson(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserJson> getUserById(Long userId) {
        User user = userService.getUserById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return new ResponseEntity<>(userMapper.toUserJson(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateUser(Long userId, UpdateUserJson updateUserJson) {
        userService.updateUser(userId, userMapper.toUserPatch(updateUserJson));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

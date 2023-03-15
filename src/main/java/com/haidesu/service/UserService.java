package com.haidesu.service;

import com.haidesu.entities.User;
import com.haidesu.entities.UserPatch;
import com.haidesu.model.UserJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    User addNewUser(User user);

    Optional<User> getUserById(long id);

    void updateUser(long id, UserPatch userPatch);

    void deleteUserById(long id);

    Optional<User> getUserByEmailAndPassword(UserJson user);
}

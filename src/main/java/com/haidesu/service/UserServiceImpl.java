package com.haidesu.service;

import com.haidesu.entities.User;
import com.haidesu.entities.UserPatch;
import com.haidesu.exceptions.UserNotFoundException;
import com.haidesu.model.UserJson;
import com.haidesu.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public User addNewUser(User user) {
        user.setCreatedAt(OffsetDateTime.now());
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, UserPatch userPatch) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user = userPatch.updateUser(user);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(UserJson userJson) {
        Optional<User> user = userRepository.findByEmailAndPassword(userJson.getEmail(), userJson.getPassword());
        if(user.isPresent()) {
            user.get().setLastLogin(OffsetDateTime.now());
            userRepository.save(user.get());
        }
        return user;
    }
}

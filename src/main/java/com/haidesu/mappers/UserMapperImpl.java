package com.haidesu.mappers;

import com.haidesu.entities.User;
import com.haidesu.entities.UserPatch;
import com.haidesu.model.CreateUserJson;
import com.haidesu.model.UpdateUserJson;
import com.haidesu.model.UserJson;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserJson toUserJson(User entity) {
        return new UserJson()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .lastLogin(entity.getLastLogin());
    }

    @Override
    public User toUserEntity(CreateUserJson dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }

    @Override
    public UserPatch toUserPatch(UpdateUserJson jsonPatch) {
        return UserPatch.builder()
                .password(jsonPatch.getPassword())
                .email(jsonPatch.getEmail())
                .build();
    }
}

package com.haidesu.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@AllArgsConstructor
public class UserPatch {
    private final JsonNullable<String> password, email, secretword;

    public User updateUser(User user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(password.orElse(user.getPassword()))
                .email(email.orElse(user.getEmail()))
                .secretword(secretword.orElse(user.getSecretword()))
                .build();
    }

}

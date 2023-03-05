package com.haidesu.mappers;

import com.haidesu.entities.User;
import com.haidesu.entities.UserPatch;
import com.haidesu.model.CreateUserJson;
import com.haidesu.model.UpdateUserJson;
import com.haidesu.model.UserJson;

public interface UserMapper {
    UserJson toUserJson(User entity);

    User toUserEntity(CreateUserJson dto);

    UserPatch toUserPatch(UpdateUserJson jsonPatch);
}

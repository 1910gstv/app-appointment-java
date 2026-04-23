package com.appointment.userdept.infra.controllers;

import com.appointment.userdept.domain.entity.User;

import java.util.Collections;

public class UserDTOMapper {
    CreateUserResponse toResponse(User user){
        return new CreateUserResponse(user.username(), user.email(), user.role());
    }

    public User toUser(CreateUserRequest request){
        return new User(request.username(), request.email(), request.password(), request.role());
    }
}

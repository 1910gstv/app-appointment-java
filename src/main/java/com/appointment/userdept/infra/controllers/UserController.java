package com.appointment.userdept.infra.controllers;

import com.appointment.userdept.application.usecases.UserInteractor;
import com.appointment.userdept.domain.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserInteractor userInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(UserInteractor userInteractor, UserDTOMapper userDTOMapper) {
        this.userInteractor = userInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    CreateUserResponse create(@RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        User user = userInteractor.createUser(userBusinessObj);
        return userDTOMapper.toResponse(user);
    }

    @GetMapping
    List<User> getAll() {
        return userInteractor.getAll();
    }

}

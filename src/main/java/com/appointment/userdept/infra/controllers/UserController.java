package com.appointment.userdept.infra.controllers;

import com.appointment.userdept.application.usecases.UserInteractor;
import com.appointment.userdept.domain.entity.User;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("/{id}")
    ResponseEntity<CreateUserResponse> editUser(@PathVariable Long id, @RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        User updatedUser = userInteractor.editUser(id, userBusinessObj);

        return ResponseEntity.ok(userDTOMapper.toResponse(updatedUser));
    }

    @GetMapping
    List<User> getAll() {
        return userInteractor.getAll();
    }

}

package com.appointment.userdept.application.gateways;

import com.appointment.userdept.domain.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserGateway {
    User createUser(User user);
    List<User> getAllUsers();
    User findByEmail(String email);
    User editUser(Long id, User newData);
    Optional findById(Long id);
}

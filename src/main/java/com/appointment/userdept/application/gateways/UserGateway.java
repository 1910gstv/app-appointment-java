package com.appointment.userdept.application.gateways;

import com.appointment.userdept.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

public interface UserGateway {
    User createUser(User user);
    List<User> getAllUsers();
    UserDetails findByEmail(String email);
    User editUser(String userId, Map<String, Object> newData);
}

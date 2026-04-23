package com.appointment.userdept.application.usecases;

import com.appointment.userdept.application.gateways.UserGateway;
import com.appointment.userdept.domain.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserInteractor {
    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder; // Injete a interface do Spring Security

    public UserInteractor(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {

        if(userGateway.findByEmail(user.email()) != null) {
            throw new RuntimeException("Usuário já cadastrado");
        };

        String passwordEncoded = passwordEncoder.encode(user.password());
        User userWithEncodedPassword = new User(
                user.username(),
                user.email(),
                passwordEncoded,
                user.role()
        );

        return userGateway.createUser(userWithEncodedPassword);
    }

    public List<User> getAll() {
        return userGateway.getAllUsers();
    }


}

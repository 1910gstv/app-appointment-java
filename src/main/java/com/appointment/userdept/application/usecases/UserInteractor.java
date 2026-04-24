package com.appointment.userdept.application.usecases;

import com.appointment.userdept.application.gateways.UserGateway;
import com.appointment.userdept.domain.entity.User;
import com.appointment.userdept.domain.enums.UserRole;
import com.appointment.userdept.infra.persistance.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public User editUser(Long id, User newData) {
        Optional<User> userOptional = userGateway.findById(id);
        if(userOptional == null) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        User existingUser = userOptional.get();
        String name = (newData.username() != null) ? newData.username() : existingUser.username();
        String email = (newData.email() != null) ? newData.email() : existingUser.email();
        UserRole role = (newData.role() != null) ? newData.role() : existingUser.role();

        String password = existingUser.password();
        if(newData.password() != null && !newData.password().isBlank()) {
            password = passwordEncoder.encode(newData.password());
        }

        User updatedUser = new User (
                id,
                name,
                email,
                password,
                role
        );

        return userGateway.editUser(id, updatedUser);
    };


}

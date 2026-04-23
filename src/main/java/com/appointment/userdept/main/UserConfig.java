package com.appointment.userdept.main;

import com.appointment.userdept.application.gateways.UserEntityMapper;
import com.appointment.userdept.application.gateways.UserGateway;
import com.appointment.userdept.application.usecases.UserInteractor;
import com.appointment.userdept.infra.controllers.UserDTOMapper;
import com.appointment.userdept.infra.gateways.UserRepositoryGateway;
import com.appointment.userdept.infra.persistance.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    @Bean
    UserInteractor createUserCase(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        return new UserInteractor(userGateway, passwordEncoder);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}

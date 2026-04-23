package com.appointment.userdept.application.gateways;

import com.appointment.userdept.domain.entity.User;
import com.appointment.userdept.infra.persistance.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public class UserEntityMapper {
    public UserEntity toEntity(User userDomainObject){
        return new UserEntity(userDomainObject.username(), userDomainObject.email(), userDomainObject.password(), userDomainObject.role());
    }

    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getUsername(),userEntity.getEmail(), userEntity.getPassword(), userEntity.getRole());
    }

}

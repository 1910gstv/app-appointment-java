package com.appointment.userdept.infra.gateways;

import com.appointment.userdept.application.gateways.UserEntityMapper;
import com.appointment.userdept.application.gateways.UserGateway;
import com.appointment.userdept.domain.entity.User;
import com.appointment.userdept.infra.persistance.UserEntity;
import com.appointment.userdept.infra.persistance.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper){
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObject){
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObject);
        UserEntity savedObj = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedObj);
    }

    @Override
    public List<User> getAllUsers(){
        List<UserEntity> user = userRepository.findAll();
        return user.stream().map(userEntityMapper::toDomain).toList();
    }

    @Override
    public UserDetails findByEmail(String email){
        UserDetails user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User editUser(String userId, Map<String, Object> newData){
        

        return userEntityMapper.toDomain(updatedObj);
    }

}

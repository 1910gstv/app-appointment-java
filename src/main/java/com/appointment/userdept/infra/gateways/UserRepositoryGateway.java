package com.appointment.userdept.infra.gateways;

import com.appointment.userdept.application.gateways.UserEntityMapper;
import com.appointment.userdept.application.gateways.UserGateway;
import com.appointment.userdept.domain.entity.User;
import com.appointment.userdept.infra.persistance.UserEntity;
import com.appointment.userdept.infra.persistance.UserRepository;

import java.util.List;
import java.util.Optional;

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
    public User findByEmail(String email){
        UserEntity user = userRepository.findByEmail(email);
        return userEntityMapper.toDomain(user);
    }

    @Override
    public User editUser(Long id,User newData){
        UserEntity entity = userEntityMapper.toEntity(newData);
        UserEntity savedEntity = userRepository.save(entity);
        return userEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return userEntityMapper.toDomainOptional(user);
    }

}

package com.appointment.userdept.infra.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
}

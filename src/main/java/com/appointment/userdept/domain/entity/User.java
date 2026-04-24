package com.appointment.userdept.domain.entity;

import com.appointment.userdept.domain.enums.UserRole;

import java.util.List;

public record User(Long id, String username, String email, String password, UserRole role) {
    public User(String username, String email, String password, UserRole role) {
        this(null, username, email, password, role);
    }
}

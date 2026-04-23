package com.appointment.userdept.domain.entity;

import com.appointment.userdept.domain.enums.UserRole;

import java.util.List;

public record User(String username, String email, String password, UserRole role) {
}

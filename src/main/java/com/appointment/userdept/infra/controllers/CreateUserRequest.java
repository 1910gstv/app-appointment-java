package com.appointment.userdept.infra.controllers;

import com.appointment.userdept.domain.enums.UserRole;

public record CreateUserRequest(String username, String email, String password, UserRole role) {
}

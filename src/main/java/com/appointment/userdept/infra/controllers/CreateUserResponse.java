package com.appointment.userdept.infra.controllers;

import com.appointment.userdept.domain.enums.UserRole;

public record CreateUserResponse(String username, String email, UserRole role) {
}

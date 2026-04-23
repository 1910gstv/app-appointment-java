package com.appointment.userdept.domain.DTOs.Auth;

import com.appointment.userdept.domain.enums.UserRole;

public record RegisterDTO(String username, String email, String password, UserRole role) {
}

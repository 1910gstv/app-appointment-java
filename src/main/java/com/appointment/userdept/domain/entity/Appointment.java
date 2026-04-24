package com.appointment.userdept.domain.entity;

import java.time.LocalDateTime;

public record Appointment(
        Long id,
        Long userId,
        LocalDateTime dateTime,
        Boolean isActive,
        String description,
        AppointmentType type,
        Long providerId,
        Location location,
        HealthInsurance healthInsurance
){};
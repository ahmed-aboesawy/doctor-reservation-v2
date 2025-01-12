package com.spring.reservation.business_logic.io_schema.dto;

import jakarta.validation.constraints.NotEmpty;


public record DoctorDto(
        @NotEmpty(message = "Name should not be empty")
        String name,
        @NotEmpty(message = "Speciality should not be empty")
        String speciality,
        @NotEmpty(message = "Address should not be empty")
        String address,
        @NotEmpty(message = "Education should not be empty")
        String education) {

}

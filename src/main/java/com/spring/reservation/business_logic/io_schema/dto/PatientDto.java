package com.spring.reservation.business_logic.io_schema.dto;

import com.spring.reservation.utils.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record PatientDto(
        @NotEmpty(message = "Name should not be empty")
        String name,
        @Past(message = "birthdate must be in the past")
        @NotNull(message = "birthdate should not be empty")
        LocalDate birthdate,
        @NotNull(message = "Gender should not be empty")
        Gender gender) {


}

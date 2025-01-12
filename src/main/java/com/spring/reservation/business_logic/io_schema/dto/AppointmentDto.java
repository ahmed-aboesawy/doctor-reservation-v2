package com.spring.reservation.business_logic.io_schema.dto;

import jakarta.validation.constraints.NotNull;

public record AppointmentDto(
        @NotNull(message = "Doctor should not be empty")
        int doctorId,
        @NotNull(message = "Patient should not be empty")
        int patientId,
        @NotNull(message = "Brief Complain should not be empty")
        String briefComplain) {

}

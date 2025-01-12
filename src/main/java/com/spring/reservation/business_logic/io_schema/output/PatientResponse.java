package com.spring.reservation.business_logic.io_schema.output;

import com.spring.reservation.utils.Gender;

import java.util.List;

public record PatientResponse(
        String patientName,
        int age,
        Gender gender,
        List<AppointmentView> appointments
) {
}

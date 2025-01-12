package com.spring.reservation.business_logic.mappers;

import com.spring.reservation.business_logic.io_schema.dto.PatientDto;
import com.spring.reservation.business_logic.io_schema.output.AppointmentView;
import com.spring.reservation.business_logic.io_schema.output.PatientResponse;
import com.spring.reservation.database.entity.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public enum PatientMapper {
    ;

    public static PatientResponse convertPatientToResponse(Patient patient)
            throws NullPointerException {
        Objects.requireNonNull(patient, "Patient Should not be Null.");
        final int patientAge =
                LocalDate.now().getYear() - patient.getBirthdate().getYear();

        List<AppointmentView> appointments =
                Objects.requireNonNull(patient.getAppointments())
                        .stream()
                        .map(AppointmentMapper::toView)
                        .toList();

        return
                new PatientResponse(
                        patient.getName(),
                        patientAge,
                        patient.getGender(),
                        appointments);
    }

    public static Patient convertDtoToPatient
            (PatientDto patientDto, Patient patient) throws NullPointerException {
        Objects.requireNonNull(patientDto, "Patient Should not be Null.");
        patient.setName(patientDto.name());
        patient.setGender(patientDto.gender());
        patient.setBirthdate(patientDto.birthdate());
        return patient;
    }


}

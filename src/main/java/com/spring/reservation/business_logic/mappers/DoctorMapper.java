package com.spring.reservation.business_logic.mappers;

import com.spring.reservation.business_logic.io_schema.dto.DoctorDto;
import com.spring.reservation.database.entity.Doctor;

import java.util.Objects;

public enum DoctorMapper {
    ;

    public static DoctorDto convertDoctorToDto(Doctor doctor)
            throws NullPointerException {
        Objects.requireNonNull(doctor, "Doctor Should not be Null.");
        return new DoctorDto(
                doctor.getName(),
                doctor.getSpeciality(),
                doctor.getAddress(),
                doctor.getEducation());
    }

    public static Doctor convertDtoToDoctor(DoctorDto doctorDto)
            throws NullPointerException {
        return convertDtoToDoctor(doctorDto, new Doctor());
    }

    public static Doctor convertDtoToDoctor(DoctorDto doctorDto, Doctor doctor)
            throws NullPointerException {
        Objects.requireNonNull(doctorDto, "Doctor Should not be Null.");
        doctor.setName(doctorDto.name());
        doctor.setEducation(doctorDto.education());
        doctor.setSpeciality(doctorDto.speciality());
        doctor.setAddress(doctorDto.address());
        return doctor;
    }
}

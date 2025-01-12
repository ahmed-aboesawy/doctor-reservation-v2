package com.spring.reservation.business_logic.mappers;

import com.spring.reservation.business_logic.io_schema.dto.AppointmentDto;
import com.spring.reservation.business_logic.io_schema.output.AppointmentView;
import com.spring.reservation.business_logic.service.DoctorService;
import com.spring.reservation.business_logic.service.PatientService;
import com.spring.reservation.database.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppointmentMapper {

    private final DoctorService doctorService;
    private final PatientService patientService;

    public AppointmentMapper(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public static AppointmentView toView(Appointment appointment) {
        return
                new AppointmentView(appointment.getDoctor().getName(),
                        appointment.getDoctor().getSpeciality(),
                        appointment.getBriefComplain(),
                        appointment.getDate().toString());
    }

    public Appointment convertDtoToAppointment(AppointmentDto dto)
            throws NullPointerException {
        return convertDtoToAppointment(dto, new Appointment());
    }

    public Appointment convertDtoToAppointment(AppointmentDto dto, Appointment appointment)
            throws NullPointerException {
        Objects.requireNonNull(dto, "Appointment Should not be Null.");
        appointment.setDoctor(this.doctorService.findById(dto.doctorId()));
        appointment.setPatient(this.patientService.findById(dto.patientId()));
        appointment.setBriefComplain(dto.briefComplain());

        return appointment;
    }
}

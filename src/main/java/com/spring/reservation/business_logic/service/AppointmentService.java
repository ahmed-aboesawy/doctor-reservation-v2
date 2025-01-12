package com.spring.reservation.business_logic.service;

import com.spring.reservation.business_logic.io_schema.dto.AppointmentDto;
import com.spring.reservation.business_logic.io_schema.output.AppointmentView;
import com.spring.reservation.business_logic.mappers.AppointmentMapper;
import com.spring.reservation.database.AppointmentRepository;
import com.spring.reservation.database.entity.Appointment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class AppointmentService {
    private final AppointmentMapper dtoMapper;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(
            AppointmentMapper dtoMapper,
            AppointmentRepository appointmentRepository) {
        this.dtoMapper = dtoMapper;
        this.appointmentRepository = appointmentRepository;
    }

//    public Page<AppointmentResponse> findAll(Pageable pageable){
//        return this.appointmentRepository
//                        .findAll(pageable)
//                        .map(AppointmentMapper::convertAppointmentToResponse);
//    }

    public Page<AppointmentRepository.AppointmentResponse> getAll(Pageable pageable) {
        return this.appointmentRepository.findAllAppointments(pageable);
    }

    public Appointment findById(Integer id) throws NullPointerException {
        return this.appointmentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Appointment Not Existed!"));
    }

    public AppointmentRepository.AppointmentResponse getAppointment(Integer id) {
        var data = this.appointmentRepository.findAppointment(id)
                .orElseThrow(() -> new NullPointerException("Appointment Not Existed!"));

        return data;
    }

    public String countDoctorAppointments(Integer doctorId) {
        long result = this.appointmentRepository.countDoctorAppointments(doctorId);
        return "This doctor has " + result + " Appointments.";
    }

    public String countPatientAppointments(Integer patientId) {
        long result = this.appointmentRepository.countPatientAppointments(patientId);
        return "This patient has " + result + " Appointments.";
    }

    public Appointment save(AppointmentDto appointmentDto)
            throws DataIntegrityViolationException {
        Appointment appointment = dtoMapper.convertDtoToAppointment(appointmentDto);
        return this.appointmentRepository.save(appointment);
    }

    public AppointmentView update(int id, AppointmentDto dto) throws NoSuchElementException {
        Appointment appointment = dtoMapper.convertDtoToAppointment(dto, findById(id));
        return AppointmentMapper.toView(this.appointmentRepository.save(appointment));
    }

    public void deleteById(Integer id) {
        Objects.requireNonNull(id);
        this.appointmentRepository.deleteById(id);
    }
}

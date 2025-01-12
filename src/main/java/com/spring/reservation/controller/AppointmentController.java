package com.spring.reservation.controller;

import com.spring.reservation.business_logic.io_schema.dto.AppointmentDto;
import com.spring.reservation.business_logic.io_schema.output.AppointmentView;
import com.spring.reservation.business_logic.mappers.AppointmentMapper;
import com.spring.reservation.business_logic.service.AppointmentService;
import com.spring.reservation.database.AppointmentRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = {"/api/reserve", "/api/reserve/"})
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

//    @GetMapping
//    public Page<AppointmentResponse> getAllAppointments(Pageable pageable){
//        return this.appointmentService.findAll(pageable);
//    }

    @GetMapping
    public Page<AppointmentRepository.AppointmentResponse> getAllAppointments(Pageable pageable) {
        return this.appointmentService.getAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable int id) {
        return ResponseEntity.ok(this.appointmentService.getAppointment(id));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<String> getTotalDoctorAppointments(@PathVariable Integer doctorId) {
        return ResponseEntity.ok(this.appointmentService.countDoctorAppointments(doctorId));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<String> getTotalPatientAppointments(@PathVariable Integer id) {
        return ResponseEntity.ok(this.appointmentService.countPatientAppointments(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentView> addAppointment(
            @Valid @RequestBody AppointmentDto appointmentDto
    ) {
        var appointment = this.appointmentService.save(appointmentDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}").build(appointment.getId());
        return ResponseEntity.created(uri)
                .body(AppointmentMapper.toView(appointment));
    }

    @PutMapping("{id}")
    public ResponseEntity<AppointmentView> updateAppointment(@PathVariable int id, @Valid @RequestBody AppointmentDto dto) {
        return ResponseEntity.accepted()
                .body(this.appointmentService.update(id, dto));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeAppointment(@PathVariable int id) {
        this.appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

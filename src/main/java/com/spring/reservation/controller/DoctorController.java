package com.spring.reservation.controller;

import com.spring.reservation.business_logic.io_schema.dto.DoctorDto;
import com.spring.reservation.business_logic.service.DoctorService;
import com.spring.reservation.database.entity.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = {"/api/doctors", "/api/doctors/"})
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public Page<DoctorDto> getAllDoctors(Pageable pageable
    ) {
        return this.service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDoctor(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        Doctor doctor = service.save(doctorDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}").build(doctor.getId());
        return ResponseEntity.created(uri).body(doctorDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(
            @PathVariable int id,
            @RequestBody DoctorDto doctorDto) {
        return ResponseEntity.accepted().body(service.update(doctorDto, id));
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<DoctorDto> updateDoctorPartially(
//            @PathVariable int id,
//            @RequestBody DoctorDto doctorDto) {
//        return ResponseEntity.accepted().body(service.update(doctorDto, id));
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

package com.spring.reservation.controller;

import com.spring.reservation.business_logic.io_schema.dto.PatientDto;
import com.spring.reservation.business_logic.io_schema.output.PatientResponse;
import com.spring.reservation.business_logic.service.PatientService;
import com.spring.reservation.database.entity.Patient;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public Page<PatientResponse> findAll(Pageable pageable) {

        return this.patientService.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable Integer id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @PostMapping
    public ResponseEntity<PatientDto> save(@Valid @RequestBody PatientDto dto) {
        Patient patient = this.patientService.save(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}").build(patient.getId());
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable int id,
                                                         @Valid @RequestBody PatientDto dto) {
        return ResponseEntity.accepted().body(this.patientService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removePatient(@PathVariable int id) {
        this.patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

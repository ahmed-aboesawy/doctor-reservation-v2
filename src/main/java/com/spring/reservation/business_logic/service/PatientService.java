package com.spring.reservation.business_logic.service;

import com.spring.reservation.business_logic.io_schema.dto.PatientDto;
import com.spring.reservation.business_logic.io_schema.output.PatientResponse;
import com.spring.reservation.business_logic.mappers.PatientMapper;
import com.spring.reservation.database.PatientRepository;
import com.spring.reservation.database.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository repository) {
        this.patientRepository = repository;
    }

    public Page<PatientResponse> findAll(Pageable pageable) {
        return this.patientRepository
                .findAll(pageable)
                .map(PatientMapper::convertPatientToResponse);
    }

    public Patient save(PatientDto dto) {
        return this.patientRepository.save(
                PatientMapper.convertDtoToPatient(dto, new Patient())
        );
    }

    public Patient findById(int id) throws NoSuchElementException {
        return this.patientRepository.findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("No Patient with ID: " + id)
                );
    }

    public PatientResponse getPatient(int id) {
        return PatientMapper.convertPatientToResponse(findById(id));
    }

    public PatientResponse update(int id, PatientDto dto) throws NullPointerException {
        Patient patient = findById(id);
        PatientMapper.convertDtoToPatient(dto, patient);
        this.patientRepository.save(patient);
        return PatientMapper.convertPatientToResponse(patient);
    }

    public void deleteById(int id) throws NullPointerException {
        this.patientRepository.deleteById(id);
    }
}

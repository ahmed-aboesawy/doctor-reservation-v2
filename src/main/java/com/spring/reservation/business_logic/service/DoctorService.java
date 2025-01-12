package com.spring.reservation.business_logic.service;

import com.spring.reservation.business_logic.io_schema.dto.DoctorDto;
import com.spring.reservation.business_logic.mappers.DoctorMapper;
import com.spring.reservation.database.DoctorRepository;
import com.spring.reservation.database.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public Page<DoctorDto> findAll(Pageable pageable) {
        return this.doctorRepository
                .findAll(pageable)
                .map(DoctorMapper::convertDoctorToDto);
    }

    public Doctor findById(int id) throws NoSuchElementException {
        var result = this.doctorRepository.findById(id);
        return result
                .orElseThrow(() -> new NoSuchElementException("No Doctor with ID: " + id));
    }

    public DoctorDto getDoctor(int id) {
        return DoctorMapper.convertDoctorToDto(findById(id));
    }

    public Doctor save(DoctorDto doctorDto) {
        Doctor doctor = DoctorMapper.convertDtoToDoctor(doctorDto);
        return doctorRepository.save(doctor);
    }

    public DoctorDto update(DoctorDto doctorDto, int doctorId) {
        Doctor doctor = DoctorMapper.convertDtoToDoctor(doctorDto, findById(doctorId));
        doctorRepository.save(doctor);
        return doctorDto;
    }

//    public DoctorDto partUpdate(DoctorDto doctorDto, Integer doctorId) throws NoSuchElementException{
//        Doctor doctor = this.findById(doctorId);
//        doctor = DoctorMapper.convertDtoToDoctor(doctorDto);
//        doctorRepository.save(doctor);
//
//        return doctorDto;
//    }

    public void deleteById(Integer id) {
        doctorRepository.deleteById(id);
    }


}

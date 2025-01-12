package com.spring.reservation.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String speciality;
    private String address;
    private String education;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}

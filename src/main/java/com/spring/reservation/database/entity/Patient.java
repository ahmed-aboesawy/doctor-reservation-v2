package com.spring.reservation.database.entity;

import com.spring.reservation.utils.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private LocalDate birthdate;
    private Gender gender;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
package com.spring.reservation.database;

import com.spring.reservation.database.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "select count(*) from appointments where doctor_id = ?1",
            nativeQuery = true)
    int countDoctorAppointments(int id);

    @Query(value = "select count(*) from appointments where patient_id = ?1",
            nativeQuery = true)
    int countPatientAppointments(int id);

    @Query(value = "select * from appointment_view av",
            nativeQuery = true)
    Page<AppointmentResponse> findAllAppointments(Pageable pageable);


    @Query(value = "select * from appointment_view a " +
            "where a.id = ?1",
            nativeQuery = true)
    Optional<AppointmentResponse> findAppointment(Integer id);

    public static interface AppointmentResponse {
        // get appointment info
        String getBriefComplain();

        String getDate();

        // get doctor info
        String getDoctorName();

        String getSpeciality();

        // get patient info
        String getPatientName();

        String getGender();

        String getBirthdate();
    }


}

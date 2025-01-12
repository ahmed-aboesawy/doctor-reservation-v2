package com.spring.reservation.business_logic.io_schema.output;

public record AppointmentView(String doctorName,
                              String speciality,
                              String briefComplain,
                              String date) {
}
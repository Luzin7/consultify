package com.luanvictor.Consultify.repositories.appointment;

import com.luanvictor.Consultify.entities.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

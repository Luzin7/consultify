package com.luanvictor.Consultify.modules.appointment.repositories;

import com.luanvictor.Consultify.modules.appointment.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

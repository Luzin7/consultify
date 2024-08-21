package com.luanvictor.Consultify.modules.inviteToken.repositories;

import com.luanvictor.Consultify.modules.inviteToken.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

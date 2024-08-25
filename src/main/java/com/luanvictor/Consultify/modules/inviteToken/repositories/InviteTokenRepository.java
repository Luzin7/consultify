package com.luanvictor.Consultify.modules.appointment.repositories;

import com.luanvictor.Consultify.modules.appointment.entities.InviteToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteTokenRepository extends JpaRepository<InviteToken, String> {
}

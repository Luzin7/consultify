package com.luanvictor.Consultify.modules.inviteToken.repositories;

import com.luanvictor.Consultify.modules.inviteToken.entities.InviteToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteTokenRepository extends JpaRepository<InviteToken, String> {
}

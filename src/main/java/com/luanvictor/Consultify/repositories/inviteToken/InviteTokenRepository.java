package com.luanvictor.Consultify.repositories.inviteToken;

import com.luanvictor.Consultify.entities.inviteToken.InviteToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteTokenRepository extends JpaRepository<InviteToken, String> {
}

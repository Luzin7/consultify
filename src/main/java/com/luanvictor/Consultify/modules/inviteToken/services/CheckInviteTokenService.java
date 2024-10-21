package com.luanvictor.Consultify.modules.inviteToken.services;

import com.luanvictor.Consultify.modules.inviteToken.dto.InviteTokenRequestDTO;
import com.luanvictor.Consultify.modules.inviteToken.entities.InviteToken;
import com.luanvictor.Consultify.modules.inviteToken.repositories.InviteTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInviteTokenService {
    private final InviteTokenRepository inviteTokenRepository;

    private Boolean isInviteTokenExpired(InviteToken inviteToken) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationTime = inviteToken.getExpiration();

        return now.isAfter(expirationTime);
    }


    public void execute(InviteTokenRequestDTO request) {
        String token = request.inviteToken();

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is required");
        }

        Optional<InviteToken> inviteToken = inviteTokenRepository.findByToken(token);

        if (inviteToken.isEmpty()) {
            throw new IllegalArgumentException("Invalid token");
        }

        if (isInviteTokenExpired(inviteToken.get())) {
            throw new IllegalArgumentException("Token has expired");
        }

    }
}



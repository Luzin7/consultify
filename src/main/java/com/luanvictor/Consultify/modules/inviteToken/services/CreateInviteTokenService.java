package com.luanvictor.Consultify.modules.inviteToken.services;

import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import com.luanvictor.Consultify.modules.inviteToken.entities.InviteToken;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import com.luanvictor.Consultify.shared.exceptions.InvalidAuthTokenException;
import com.luanvictor.Consultify.shared.exceptions.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateInviteTokenService {
    private final JwtEncryption jwtEncryption;
    private final AdminRepository adminRepository;

    private LocalDateTime generateInviteTokenExpiration() {
        return LocalDateTime.now().plusMinutes(30);
    }

    public void execute(AuthRequestDTO request) {
        String id = jwtEncryption.validateToken(request.accessToken());

        if (id == null) {
            throw new InvalidAuthTokenException();
        }

        Optional<Admin> admin = this.adminRepository.findById(Long.parseLong(id));

        if (admin.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        if (!admin.get().getRole().equals("ADMIN")) {
            throw new IllegalArgumentException("Unauthorized to create an invite token");
        }

        InviteToken newInviteToken = new InviteToken();
        newInviteToken.setAdminId(admin.get().getId());
        newInviteToken.setRole(admin.get().getRole());
        newInviteToken.setExpiration(generateInviteTokenExpiration());
    }
}



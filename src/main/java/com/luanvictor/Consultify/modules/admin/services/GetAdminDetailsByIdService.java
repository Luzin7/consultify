package com.luanvictor.Consultify.modules.admin.services;

import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.providers.cryptography.PasswordEncryption;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import com.luanvictor.Consultify.shared.exceptions.InvalidAuthTokenException;
import com.luanvictor.Consultify.shared.exceptions.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAdminDetailsByIdService {
    private final AdminRepository adminRepository;
    private final PasswordEncryption passwordEncryption;
    private final JwtEncryption jwtEncryption;

    public Admin execute(AuthRequestDTO request) {
        String id = jwtEncryption.validateToken(request.accessToken());

        if (id == null) {
            throw new InvalidAuthTokenException();
        }

        Optional<Admin> admin = this.adminRepository.findById(Long.parseLong(id));

        if (admin.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        return admin.get();
    }
}

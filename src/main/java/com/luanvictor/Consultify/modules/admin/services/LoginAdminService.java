package com.luanvictor.Consultify.modules.admin.services;

import com.luanvictor.Consultify.modules.admin.dto.LoginRequestDTO;
import com.luanvictor.Consultify.modules.admin.dto.LoginResponseDTO;
import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.providers.cryptography.PasswordEncryption;
import com.luanvictor.Consultify.shared.exceptions.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginAdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncryption passwordEncryption;
    private final JwtEncryption jwtEncryption;

    public LoginResponseDTO execute(LoginRequestDTO request) {
        Optional<Admin> admin = this.adminRepository.findByEmail(request.email());

        if (admin.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        boolean isPasswordValid = passwordEncryption.checkPassword(request.password(), admin.get().getPassword());

        if (!isPasswordValid) {
            throw new InvalidCredentialsException();
        }

        String accessToken = jwtEncryption.generateToken(admin.get());

        return new LoginResponseDTO(accessToken);
    }
}

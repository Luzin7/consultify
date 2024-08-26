package com.luanvictor.Consultify.modules.admin.services;

import com.luanvictor.Consultify.modules.admin.dto.LoginRequestDTO;
import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.errors.InvalidCredentialsException;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.providers.cryptography.PasswordEncryption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginAdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncryption passwordEncryption;
    private final JwtEncryption jwtEncryption;

    public Admin execute(LoginRequestDTO request) {
        Optional<Admin> admin = this.adminRepository.findByEmail(request.email());

        if (admin.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        boolean isPasswordValid = passwordEncryption.checkPassword(request.password(), admin.get().getPassword());

        if (!isPasswordValid) {
            throw new InvalidCredentialsException();
        }

//        TODO: create token entity
//        TODO: add token entity here

        return admin.get();
    }
}

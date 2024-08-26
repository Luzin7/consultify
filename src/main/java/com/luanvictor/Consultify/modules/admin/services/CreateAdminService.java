package com.luanvictor.Consultify.modules.admin.services;

import com.luanvictor.Consultify.modules.admin.dto.RegisterRequestDTO;
import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.errors.EmailAlreadyInUseException;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import com.luanvictor.Consultify.providers.cryptography.PasswordEncryption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateAdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncryption passwordEncryption;

    public void execute(RegisterRequestDTO request) {
        Optional<Admin> admin = this.adminRepository.findByEmail(request.email());

        if (admin.isPresent()) {
            throw new EmailAlreadyInUseException();
        }

        Admin newAdmin = new Admin();
        newAdmin.setName(request.name());
        newAdmin.setEmail(request.email());
        newAdmin.setPassword(passwordEncryption.encryptPassword(request.password()));
        newAdmin.setRole("ADMIN");
        newAdmin.setCreatedAt(new Date());

        this.adminRepository.save(newAdmin);
    }
}

package com.luanvictor.Consultify.modules.admin.services;

import com.luanvictor.Consultify.modules.admin.dto.RegisterRequestDTO;
import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.errors.EmailAlreadyInUseException;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateAdminService {
    private final AdminRepository adminRepository;

    public void execute(RegisterRequestDTO request) {
        Optional<Admin> admin = this.adminRepository.findByEmail(request.email());

        if (admin.isPresent()) {
            throw new EmailAlreadyInUseException();
        }

        Admin newAdmin = new Admin();
        newAdmin.setName(request.name());
        newAdmin.setEmail(request.email());
        newAdmin.setPassword(request.password()); // TODO: Hash the password
        newAdmin.setCreatedAt(new Date());

        this.adminRepository.save(newAdmin);
    }
}

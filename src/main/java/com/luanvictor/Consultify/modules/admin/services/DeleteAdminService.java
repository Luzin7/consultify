package com.luanvictor.Consultify.modules.admin.services;

import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.repositories.AdminRepository;
import com.luanvictor.Consultify.modules.professional.dto.DeleteRequestDTO;
import com.luanvictor.Consultify.modules.professional.exceptions.ProfessionalNotFoundException;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import com.luanvictor.Consultify.shared.exceptions.InvalidAuthTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteAdminService {
    private final AdminRepository adminRepository;
    private final JwtEncryption jwtEncryption;

    public void execute(AuthRequestDTO authRequest, DeleteRequestDTO request) {
        String id = jwtEncryption.validateToken(authRequest.accessToken());

        if (id == null) {
            throw new InvalidAuthTokenException();
        }

        Optional<Admin> professional = this.adminRepository.findById(Long.parseLong(id));

        if (professional.isEmpty()) {
            throw new ProfessionalNotFoundException();
        }

        if (!professional.get().getRole().equals("ADMIN")) {
            throw new IllegalArgumentException("Unauthorized to delete this administrator");
        }

        this.adminRepository.deleteById(Long.parseLong(request.professionalId()));
    }
}

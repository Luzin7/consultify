package com.luanvictor.Consultify.modules.professional.services;

import com.luanvictor.Consultify.modules.professional.entities.Professional;
import com.luanvictor.Consultify.modules.professional.repositories.ProfessionalRepository;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import com.luanvictor.Consultify.shared.exceptions.InvalidAuthTokenException;
import com.luanvictor.Consultify.shared.exceptions.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProfessionalDetailsByIdService {
    private final ProfessionalRepository professionalRepository;
    private final JwtEncryption jwtEncryption;

    public Professional execute(AuthRequestDTO request) {
        String id = jwtEncryption.validateToken(request.accessToken());

        if (id == null) {
            throw new InvalidAuthTokenException();
        }

        Optional<Professional> admin = this.professionalRepository.findById(Long.parseLong(id));

        if (admin.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        return admin.get();
    }
}

package com.luanvictor.Consultify.modules.professional.services;

import com.luanvictor.Consultify.modules.professional.dto.DeleteRequestDTO;
import com.luanvictor.Consultify.modules.professional.entities.Professional;
import com.luanvictor.Consultify.modules.professional.exceptions.ProfessionalNotFoundException;
import com.luanvictor.Consultify.modules.professional.repositories.ProfessionalRepository;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import com.luanvictor.Consultify.shared.exceptions.InvalidAuthTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProfessionalService {
    private final ProfessionalRepository professionalRepository;
    private final JwtEncryption jwtEncryption;

    public void execute(AuthRequestDTO authRequest, DeleteRequestDTO request) {
        String id = jwtEncryption.validateToken(authRequest.accessToken());

        if (id == null) {
            throw new InvalidAuthTokenException();
        }

        Optional<Professional> professional = this.professionalRepository.findById(Long.parseLong(id));

        if (professional.isEmpty()) {
            throw new ProfessionalNotFoundException();
        }

        if (!professional.get().getRole().equals("RECEPTIONIST") && !professional.get().getRole().equals("ADMIN")) {
            throw new IllegalArgumentException("Unauthorized to delete this professional");
        }

        if (!professional.get().getId().equals(Long.parseLong(request.professionalId())) && !professional.get().getRole().equals("ADMIN")) {
            throw new IllegalArgumentException("id does not match with the authenticated user");
        }

        this.professionalRepository.deleteById(Long.parseLong(request.professionalId()));
    }
}

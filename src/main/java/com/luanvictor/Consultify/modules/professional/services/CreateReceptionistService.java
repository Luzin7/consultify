package com.luanvictor.Consultify.modules.professional.services;

import com.luanvictor.Consultify.modules.professional.dto.RegisterRequestDTO;
import com.luanvictor.Consultify.modules.professional.entities.Professional;
import com.luanvictor.Consultify.modules.professional.repositories.ProfessionalRepository;
import com.luanvictor.Consultify.providers.cryptography.PasswordEncryption;
import com.luanvictor.Consultify.shared.exceptions.EmailAlreadyInUseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateReceptionistService {
    private final ProfessionalRepository professionalRepository;
    private final PasswordEncryption passwordEncryption;

    public void execute(RegisterRequestDTO request) {
        Optional<Professional> admin = this.professionalRepository.findByEmail(request.email());

        if (admin.isPresent()) {
            throw new EmailAlreadyInUseException();
        }

        Professional professional = new Professional();
        professional.setName(request.name());
        professional.setEmail(request.email());
        professional.setPassword(passwordEncryption.encryptPassword(request.password()));
        professional.setRole("RECEPTIONIST");
        professional.setCreatedAt(new Date());
    }
}

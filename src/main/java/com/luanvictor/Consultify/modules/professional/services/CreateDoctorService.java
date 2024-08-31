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
public class CreateDoctorService {
    private final ProfessionalRepository professionalRepository;
    private final PasswordEncryption passwordEncryption;

    public void execute(RegisterRequestDTO request) {
        Optional<Professional> professional = this.professionalRepository.findByEmail(request.email());

        if (professional.isPresent()) {
            throw new EmailAlreadyInUseException();
        }

        Professional newProfessional = new Professional();
        newProfessional.setName(request.name());
        newProfessional.setEmail(request.email());
        newProfessional.setPassword(passwordEncryption.encryptPassword(request.password()));
        newProfessional.setRole("DOCTOR");
        newProfessional.setCreatedAt(new Date());
    }
}

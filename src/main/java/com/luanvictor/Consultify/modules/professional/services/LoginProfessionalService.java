package com.luanvictor.Consultify.modules.professional.services;

import com.luanvictor.Consultify.modules.professional.dto.LoginRequestDTO;
import com.luanvictor.Consultify.modules.professional.dto.LoginResponseDTO;
import com.luanvictor.Consultify.modules.professional.entities.Professional;
import com.luanvictor.Consultify.modules.professional.repositories.ProfessionalRepository;
import com.luanvictor.Consultify.providers.auth.JwtEncryption;
import com.luanvictor.Consultify.providers.cryptography.PasswordEncryption;
import com.luanvictor.Consultify.shared.exceptions.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginProfessionalService {
    private final ProfessionalRepository professionalRepository;
    private final PasswordEncryption passwordEncryption;
    private final JwtEncryption jwtEncryption;

    public LoginResponseDTO execute(LoginRequestDTO request) {
        Optional<Professional> professional = this.professionalRepository.findByEmail(request.email());

        if (professional.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        boolean isPasswordValid = passwordEncryption.checkPassword(request.password(), professional.get().getPassword());

        if (!isPasswordValid) {
            throw new InvalidCredentialsException();
        }

        String accessToken = jwtEncryption.generateToken(professional.get());

        return new LoginResponseDTO(accessToken);
    }
}

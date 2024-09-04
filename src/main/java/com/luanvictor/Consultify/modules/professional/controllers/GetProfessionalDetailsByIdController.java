package com.luanvictor.Consultify.modules.professional.controllers;

import com.luanvictor.Consultify.modules.professional.entities.Professional;
import com.luanvictor.Consultify.modules.professional.services.GetProfessionalDetailsByIdService;
import com.luanvictor.Consultify.providers.decorators.authToken.AuthToken;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professional")
@RequiredArgsConstructor
public class GetProfessionalDetailsByIdController {
    private final GetProfessionalDetailsByIdService getProfessionalDetailsByIdService;

    @PostMapping("/get-by-id")
    public ResponseEntity<Professional> handle(@AuthToken AuthRequestDTO body) {
        Professional result = this.getProfessionalDetailsByIdService.execute(body);

        return ResponseEntity.ok(result);
    }
}

package com.luanvictor.Consultify.modules.professional.controllers;

import com.luanvictor.Consultify.modules.professional.dto.LoginRequestDTO;
import com.luanvictor.Consultify.modules.professional.dto.LoginResponseDTO;
import com.luanvictor.Consultify.modules.professional.services.LoginProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professional")
@RequiredArgsConstructor
public class LoginProfessionalController {
    private final LoginProfessionalService loginProfessionalService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> handle(@RequestBody LoginRequestDTO body) {
        LoginResponseDTO result = this.loginProfessionalService.execute(body);

        return ResponseEntity.ok(result);
    }
}

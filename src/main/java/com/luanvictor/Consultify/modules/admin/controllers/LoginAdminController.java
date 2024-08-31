package com.luanvictor.Consultify.modules.admin.controllers;

import com.luanvictor.Consultify.modules.admin.dto.LoginRequestDTO;
import com.luanvictor.Consultify.modules.admin.dto.LoginResponseDTO;
import com.luanvictor.Consultify.modules.admin.services.LoginAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LoginAdminController {
    private final LoginAdminService loginAdminService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> handle(@RequestBody LoginRequestDTO body) {
        LoginResponseDTO result = this.loginAdminService.execute(body);

        return ResponseEntity.ok(result);
    }
}

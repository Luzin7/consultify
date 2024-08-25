package com.luanvictor.Consultify.modules.admin.controllers;

import com.luanvictor.Consultify.providers.decorators.authToken.AuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateAdminController {
    public ResponseEntity<String> Teste(@AuthToken String authToken) {
        return ResponseEntity.ok(authToken);
    }
}

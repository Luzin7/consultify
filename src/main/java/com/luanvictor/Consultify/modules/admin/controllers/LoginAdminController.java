package com.luanvictor.Consultify.modules.admin.controllers;

import com.luanvictor.Consultify.modules.admin.dto.LoginRequestDTO;
import com.luanvictor.Consultify.modules.admin.services.LoginAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@ResponseStatus(HttpStatus.OK)
@RequiredArgsConstructor
public class LoginAdminController {
    private final LoginAdminService loginAdminService;

    @PostMapping("/login")
    public ResponseEntity<String> handle(@RequestBody LoginRequestDTO body) {
        String result = this.loginAdminService.execute(body);

        return ResponseEntity.ok(result);
    }
}

package com.luanvictor.Consultify.modules.admin.controllers;

import com.luanvictor.Consultify.modules.admin.entities.Admin;
import com.luanvictor.Consultify.modules.admin.services.GetAdminDetailsByIdService;
import com.luanvictor.Consultify.providers.decorators.authToken.AuthToken;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class GetAdminDetailsByIdController {
    private final GetAdminDetailsByIdService getAdminDetailsById;

    @PostMapping("/get-by-id")
    public ResponseEntity<Admin> handle(@AuthToken AuthRequestDTO body) {
        Admin result = this.getAdminDetailsById.execute(body);

        return ResponseEntity.ok(result);
    }
}

package com.luanvictor.Consultify.modules.professional.controllers;

import com.luanvictor.Consultify.modules.admin.services.DeleteAdminService;
import com.luanvictor.Consultify.modules.professional.dto.DeleteRequestDTO;
import com.luanvictor.Consultify.providers.decorators.authToken.AuthToken;
import com.luanvictor.Consultify.shared.dto.AuthRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professional")
@ResponseStatus(HttpStatus.NO_CONTENT)
@RequiredArgsConstructor
public class DeleteProfessionalController {
    private final DeleteAdminService deleteAdminService;

    @PostMapping("/delete")
    public void handle(@AuthToken AuthRequestDTO authToken, @RequestBody DeleteRequestDTO body) {
        this.deleteAdminService.execute(authToken, body);
    }
}

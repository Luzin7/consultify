package com.luanvictor.Consultify.modules.admin.controllers;

import com.luanvictor.Consultify.modules.admin.dto.RegisterRequestDTO;
import com.luanvictor.Consultify.modules.admin.services.CreateAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@ResponseStatus(HttpStatus.CREATED)
@RequiredArgsConstructor
public class CreateAdminController {
    private final CreateAdminService createAdminService;

    @PostMapping("/create")
    public void handle(@RequestBody RegisterRequestDTO body) {
        this.createAdminService.execute(body);
    }
}
